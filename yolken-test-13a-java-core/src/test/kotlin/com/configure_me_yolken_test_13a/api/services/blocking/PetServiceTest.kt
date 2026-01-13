// File generated from our OpenAPI spec by Stainless.

package com.configure_me_yolken_test_13a.api.services.blocking

import com.configure_me_yolken_test_13a.api.TestServerExtension
import com.configure_me_yolken_test_13a.api.client.okhttp.YolkenTest13aOkHttpClient
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
internal class PetServiceTest {

    @Disabled("Prism tests are disabled")
    @Test
    fun create() {
        val client =
            YolkenTest13aOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pets()

        val pet =
            petService.create(
                Pet.builder()
                    .name("doggie")
                    .addPhotoUrl("string")
                    .id(10L)
                    .category(Category.builder().id(1L).name("Dogs").build())
                    .status(Pet.Status.AVAILABLE)
                    .addTag(Pet.Tag.builder().id(0L).name("name").build())
                    .build()
            )

        pet.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun retrieve() {
        val client =
            YolkenTest13aOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pets()

        val pet = petService.retrieve(0L)

        pet.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun update() {
        val client =
            YolkenTest13aOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pets()

        val pet =
            petService.update(
                Pet.builder()
                    .name("doggie")
                    .addPhotoUrl("string")
                    .id(10L)
                    .category(Category.builder().id(1L).name("Dogs").build())
                    .status(Pet.Status.AVAILABLE)
                    .addTag(Pet.Tag.builder().id(0L).name("name").build())
                    .build()
            )

        pet.validate()
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun delete() {
        val client =
            YolkenTest13aOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pets()

        petService.delete(0L)
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun findByStatus() {
        val client =
            YolkenTest13aOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pets()

        val pets =
            petService.findByStatus(
                PetFindByStatusParams.builder()
                    .status(PetFindByStatusParams.Status.AVAILABLE)
                    .build()
            )

        pets.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun findByTags() {
        val client =
            YolkenTest13aOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pets()

        val pets = petService.findByTags(PetFindByTagsParams.builder().addTag("string").build())

        pets.forEach { it.validate() }
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun updateById() {
        val client =
            YolkenTest13aOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pets()

        petService.updateById(
            PetUpdateByIdParams.builder().petId(0L).name("name").status("status").build()
        )
    }

    @Disabled("Prism tests are disabled")
    @Test
    fun uploadImage() {
        val client =
            YolkenTest13aOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val petService = client.pets()

        val response =
            petService.uploadImage(
                PetUploadImageParams.builder()
                    .petId(0L)
                    .additionalMetadata("additionalMetadata")
                    .image("some content")
                    .build()
            )

        response.validate()
    }
}
