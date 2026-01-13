// File generated from our OpenAPI spec by Stainless.

package com.configure_me_yolken_test_13a.api.services.async

import com.configure_me_yolken_test_13a.api.TestServerExtension
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClientAsync
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class StoreServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun listInventory() {
        val client =
            YolkenTest13aOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val storeServiceAsync = client.store()

        val responseFuture = storeServiceAsync.listInventory()

        val response = responseFuture.get()
        response.validate()
    }
}
