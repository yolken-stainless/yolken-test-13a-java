// File generated from our OpenAPI spec by Stainless.

package com.configure_me_yolken_test_13a.api.models.users

import com.configure_me_yolken_test_13a.api.core.jsonMapper
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UserTest {

    @Test
    fun create() {
        val user =
            User.builder()
                .id(10L)
                .email("john@email.com")
                .firstName("John")
                .lastName("James")
                .password("12345")
                .phone("12345")
                .username("theUser")
                .userStatus(1)
                .build()

        assertThat(user.id()).contains(10L)
        assertThat(user.email()).contains("john@email.com")
        assertThat(user.firstName()).contains("John")
        assertThat(user.lastName()).contains("James")
        assertThat(user.password()).contains("12345")
        assertThat(user.phone()).contains("12345")
        assertThat(user.username()).contains("theUser")
        assertThat(user.userStatus()).contains(1)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val user =
            User.builder()
                .id(10L)
                .email("john@email.com")
                .firstName("John")
                .lastName("James")
                .password("12345")
                .phone("12345")
                .username("theUser")
                .userStatus(1)
                .build()

        val roundtrippedUser =
            jsonMapper.readValue(jsonMapper.writeValueAsString(user), jacksonTypeRef<User>())

        assertThat(roundtrippedUser).isEqualTo(user)
    }
}
