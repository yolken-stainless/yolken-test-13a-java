// File generated from our OpenAPI spec by Stainless.

package com.configure_me_yolken_test_13a.api.services.async

import com.configure_me_yolken_test_13a.api.TestServerExtension
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClientAsync
import com.configure_me_yolken_test_13a.api.models.pets.Category
import com.configure_me_yolken_test_13a.api.models.pets.Pet
import com.configure_me_yolken_test_13a.api.models.pets.PetFindByStatusParams
import com.configure_me_yolken_test_13a.api.models.pets.PetFindByTagsParams
import com.configure_me_yolken_test_13a.api.models.pets.PetUpdateByIdParams
import com.configure_me_yolken_test_13a.api.models.pets.PetUploadImageParams
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class PetServiceAsyncTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            YolkenTest13aOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pets()

        val petFuture =
            petServiceAsync.create(
                Pet.builder()
                    .name("doggie")
                    .addPhotoUrl("string")
                    .id(10L)
                    .category(Category.builder().id(1L).name("Dogs").build())
                    .status(Pet.Status.AVAILABLE)
                    .addTag(Pet.Tag.builder().id(0L).name("name").build())
                    .build()
            )

        val pet = petFuture.get()
        pet.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            YolkenTest13aOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pets()

        val petFuture = petServiceAsync.retrieve(0L)

        val pet = petFuture.get()
        pet.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            YolkenTest13aOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pets()

        val petFuture =
            petServiceAsync.update(
                Pet.builder()
                    .name("doggie")
                    .addPhotoUrl("string")
                    .id(10L)
                    .category(Category.builder().id(1L).name("Dogs").build())
                    .status(Pet.Status.AVAILABLE)
                    .addTag(Pet.Tag.builder().id(0L).name("name").build())
                    .build()
            )

        val pet = petFuture.get()
        pet.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            YolkenTest13aOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pets()

        val future = petServiceAsync.delete(0L)

        val response = future.get()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun findByStatus() {
        val client =
            YolkenTest13aOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pets()

        val petsFuture =
            petServiceAsync.findByStatus(
                PetFindByStatusParams.builder()
                    .status(PetFindByStatusParams.Status.AVAILABLE)
                    .build()
            )

        val pets = petsFuture.get()
        pets.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun findByTags() {
        val client =
            YolkenTest13aOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pets()

        val petsFuture =
            petServiceAsync.findByTags(PetFindByTagsParams.builder().addTag("string").build())

        val pets = petsFuture.get()
        pets.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun updateById() {
        val client =
            YolkenTest13aOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pets()

        val future =
            petServiceAsync.updateById(
                PetUpdateByIdParams.builder().petId(0L).name("name").status("status").build()
            )

        val response = future.get()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun uploadImage() {
        val client =
            YolkenTest13aOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petServiceAsync = client.pets()

        val responseFuture =
            petServiceAsync.uploadImage(
                PetUploadImageParams.builder()
                    .petId(0L)
                    .additionalMetadata("additionalMetadata")
                    .image("some content")
                    .build()
            )

        val response = responseFuture.get()
        response.validate()
    }
}
