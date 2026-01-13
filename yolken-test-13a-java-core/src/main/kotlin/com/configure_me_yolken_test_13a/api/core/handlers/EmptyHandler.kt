@file:JvmName("EmptyHandler")

package com.configure_me_yolken_test_13a.api.core.handlers

import com.configure_me_yolken_test_13a.api.core.http.HttpResponse
import com.configure_me_yolken_test_13a.api.core.http.HttpResponse.Handler

@JvmSynthetic internal fun emptyHandler(): Handler<Void?> = EmptyHandlerInternal

private object EmptyHandlerInternal : Handler<Void?> {
    override fun handle(response: HttpResponse): Void? = null
}
