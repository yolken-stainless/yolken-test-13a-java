// File generated from our OpenAPI spec by Stainless.

package com.configure_me_yolken_test_13a.api.models.pets

import com.configure_me_yolken_test_13a.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CategoryTest {

    @Test
    fun create() {
        val category = Category.builder().id(1L).name("Dogs").build()

        assertThat(category.id()).contains(1L)
        assertThat(category.name()).contains("Dogs")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val category = Category.builder().id(1L).name("Dogs").build()

        val roundtrippedCategory =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(category),
                jacksonTypeRef<Category>(),
            )

        assertThat(roundtrippedCategory).isEqualTo(category)
    }
}
