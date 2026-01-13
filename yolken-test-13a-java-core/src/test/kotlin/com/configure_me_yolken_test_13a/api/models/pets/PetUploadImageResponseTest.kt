// File generated from our OpenAPI spec by Stainless.

package com.configure_me_yolken_test_13a.api.models.pets

import com.configure_me_yolken_test_13a.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PetUploadImageResponseTest {

    @Test
    fun create() {
        val petUploadImageResponse =
            PetUploadImageResponse.builder().code(0).message("message").type("type").build()

        assertThat(petUploadImageResponse.code()).contains(0)
        assertThat(petUploadImageResponse.message()).contains("message")
        assertThat(petUploadImageResponse.type()).contains("type")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val petUploadImageResponse =
            PetUploadImageResponse.builder().code(0).message("message").type("type").build()

        val roundtrippedPetUploadImageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(petUploadImageResponse),
                jacksonTypeRef<PetUploadImageResponse>(),
            )

        assertThat(roundtrippedPetUploadImageResponse).isEqualTo(petUploadImageResponse)
    }
}
