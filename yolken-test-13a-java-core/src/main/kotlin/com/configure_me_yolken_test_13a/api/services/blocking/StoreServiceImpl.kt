// File generated from our OpenAPI spec by Stainless.

package com.configure_me_yolken_test_13a.api.services.blocking

import com.configure_me_yolken_test_13a.api.core.ClientOptions
import com.configure_me_yolken_test_13a.api.core.RequestOptions
import com.configure_me_yolken_test_13a.api.core.handlers.errorBodyHandler
import com.configure_me_yolken_test_13a.api.core.handlers.errorHandler
import com.configure_me_yolken_test_13a.api.core.handlers.jsonHandler
import com.configure_me_yolken_test_13a.api.core.http.HttpMethod
import com.configure_me_yolken_test_13a.api.core.http.HttpRequest
import com.configure_me_yolken_test_13a.api.core.http.HttpResponse
import com.configure_me_yolken_test_13a.api.core.http.HttpResponse.Handler
import com.configure_me_yolken_test_13a.api.core.http.HttpResponseFor
import com.configure_me_yolken_test_13a.api.core.http.parseable
import com.configure_me_yolken_test_13a.api.core.prepare
import com.configure_me_yolken_test_13a.api.models.store.StoreListInventoryParams
import com.configure_me_yolken_test_13a.api.models.store.StoreListInventoryResponse
import com.configure_me_yolken_test_13a.api.services.blocking.store.OrderService
import com.configure_me_yolken_test_13a.api.services.blocking.store.OrderServiceImpl
import java.util.function.Consumer

class StoreServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    StoreService {

    private val withRawResponse: StoreService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val orders: OrderService by lazy { OrderServiceImpl(clientOptions) }

    override fun withRawResponse(): StoreService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): StoreService =
        StoreServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun orders(): OrderService = orders

    override fun listInventory(
        params: StoreListInventoryParams,
        requestOptions: RequestOptions,
    ): StoreListInventoryResponse =
        // get /store/inventory
        withRawResponse().listInventory(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StoreService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val orders: OrderService.WithRawResponse by lazy {
            OrderServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StoreService.WithRawResponse =
            StoreServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun orders(): OrderService.WithRawResponse = orders

        private val listInventoryHandler: Handler<StoreListInventoryResponse> =
            jsonHandler<StoreListInventoryResponse>(clientOptions.jsonMapper)

        override fun listInventory(
            params: StoreListInventoryParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StoreListInventoryResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("store", "inventory")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listInventoryHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
