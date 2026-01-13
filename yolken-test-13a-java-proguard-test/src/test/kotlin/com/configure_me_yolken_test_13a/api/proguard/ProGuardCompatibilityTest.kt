// File generated from our OpenAPI spec by Stainless.

package com.configure_me_yolken_test_13a.api.proguard

import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClient
import com.configure_me_yolken_test_13a.api.core.jsonMapper
import com.configure_me_yolken_test_13a.api.models.Order
import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import java.time.OffsetDateTime
import kotlin.reflect.full.memberFunctions
import kotlin.reflect.jvm.javaMethod
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProGuardCompatibilityTest {

    companion object {

        @JvmStatic
        fun main(args: Array<String>) {
            // To debug that we're using the right JAR.
            val jarPath = this::class.java.getProtectionDomain().codeSource.location
            println("JAR being used: $jarPath")

            // We have to manually run the test methods instead of using the JUnit runner because it
            // seems impossible to get working with R8.
            val test = ProGuardCompatibilityTest()
            test::class
                .memberFunctions
                .asSequence()
                .filter { function ->
                    function.javaMethod?.isAnnotationPresent(Test::class.java) == true
                }
                .forEach { it.call(test) }
        }
    }

    @Test
    fun proguardRules() {
        val rulesFile =
            javaClass.classLoader.getResourceAsStream(
                "META-INF/proguard/yolken-test-13a-java-core.pro"
            )

        assertThat(rulesFile).isNotNull()
    }

    @Test
    fun client() {
        val client = YolkenTest13aOkHttpClient.builder().apiKey("My API Key").build()

        assertThat(client).isNotNull()
        assertThat(client.pets()).isNotNull()
        assertThat(client.store()).isNotNull()
        assertThat(client.users()).isNotNull()
    }

    @Test
    fun orderRoundtrip() {
        val jsonMapper = jsonMapper()
        val order =
            Order.builder()
                .id(10L)
                .complete(true)
                .petId(198772L)
                .quantity(7)
                .shipDate(OffsetDateTime.parse("2019-12-27T18:11:19.117Z"))
                .status(Order.Status.APPROVED)
                .build()

        val roundtrippedOrder =
            jsonMapper.readValue(jsonMapper.writeValueAsString(order), jacksonTypeRef<Order>())

        assertThat(roundtrippedOrder).isEqualTo(order)
    }
}
