package org.jesperancinha.talks.carparts.carpartsdatascructures.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.databind.json.JsonMapper
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule
import org.jesperancinha.talks.carparts.carpartsdatascructures.dto.CarPartDto
import org.jesperancinha.talks.carparts.carpartsmanager.ContainerTest
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import java.math.BigDecimal
import java.time.Instant


@SpringBootTest
@AutoConfigureMockMvc
class CarPartsControllerTest @Autowired constructor(
    val mockMvc: MockMvc
) : ContainerTest() {

    val objectMapper: ObjectMapper by lazy {
        JsonMapper.builder()
            .addModule(JavaTimeModule())
            .build()
    }


    @Test
    fun `should send a valid request`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post(
                "/create",

                ).content(
                objectMapper.writeValueAsString(
                    CarPartDto(
                        name = "Bolt",
                        productionDate = Instant.now(),
                        expiryDate = Instant.now(),
                        barCode = 1001L,
                        cost = BigDecimal.TEN
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isOk)
    }

    @Test
    fun `should detect invalid request to the controller`() {
        mockMvc.perform(
            MockMvcRequestBuilders.post(
                "/create",

                ).content(
                objectMapper.writeValueAsString(
                    CarPartDto(
                        name = "Bolt",
                        productionDate = Instant.now(),
                        expiryDate = Instant.now(),
                        barCode = -1000L,
                        cost = BigDecimal.TEN
                    )
                )
            ).contentType(MediaType.APPLICATION_JSON)
        ).andExpect(MockMvcResultMatchers.status().isBadRequest)
    }
}