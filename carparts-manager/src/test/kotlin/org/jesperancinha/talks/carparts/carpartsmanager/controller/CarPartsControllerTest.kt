package org.jesperancinha.talks.carparts.carpartsmanager.controller

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import com.fasterxml.jackson.module.kotlin.readValue
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import io.kotest.matchers.collections.shouldHaveSize
import org.jesperancinha.talks.carparts.carpartsmanager.ContainerTest
import org.jesperancinha.talks.carparts.carpartsmanager.dto.CarPartDto
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@SpringBootTest
@AutoConfigureMockMvc
class CarPartsControllerTest @Autowired constructor(
    val mockMvc: MockMvc
) : ContainerTest() {

    val objectMapper: ObjectMapper by lazy {
        JsonMapper.builder()
            .addModule(JavaTimeModule())
            .build()
            .registerKotlinModule()
    }

    @Test
    fun `should list car parts with a name with a non-nullable field with a null value`() {
        mockMvc.perform(
            MockMvcRequestBuilders.get("/")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk)
            .andReturn().response.contentAsString
            .let { objectMapper.readValue(it, object : TypeReference<List<CarPartDto>>() {}) }
            .shouldHaveSize(1)
    }
}