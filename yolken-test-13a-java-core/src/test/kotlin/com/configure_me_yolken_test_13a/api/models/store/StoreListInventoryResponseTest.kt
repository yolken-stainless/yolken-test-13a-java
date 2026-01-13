// File generated from our OpenAPI spec by Stainless.

package com.configure_me_yolken_test_13a.api.models.store

import com.configure_me_yolken_test_13a.api.core.JsonValue
import com.configure_me_yolken_test_13a.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StoreListInventoryResponseTest {

    @Test
    fun create() {
        val storeListInventoryResponse =
            StoreListInventoryResponse.builder()
                .putAdditionalProperty("foo", JsonValue.from(0))
                .build()
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val storeListInventoryResponse =
            StoreListInventoryResponse.builder()
                .putAdditionalProperty("foo", JsonValue.from(0))
                .build()

        val roundtrippedStoreListInventoryResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(storeListInventoryResponse),
                jacksonTypeRef<StoreListInventoryResponse>(),
            )

        assertThat(roundtrippedStoreListInventoryResponse).isEqualTo(storeListInventoryResponse)
    }
}
