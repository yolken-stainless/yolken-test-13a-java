// File generated from our OpenAPI spec by Stainless.

package com.configure_me_yolken_test_13a.api.errors

import com.configure_me_yolken_test_13a.api.core.JsonValue
import com.configure_me_yolken_test_13a.api.core.http.Headers

abstract class YolkenTest13aServiceException
protected constructor(message: String, cause: Throwable? = null) :
    YolkenTest13aException(message, cause) {

    abstract fun statusCode(): Int

    abstract fun headers(): Headers

    abstract fun body(): JsonValue
}
