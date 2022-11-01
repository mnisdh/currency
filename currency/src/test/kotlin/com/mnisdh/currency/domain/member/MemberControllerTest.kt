package com.mnisdh.currency.domain.member

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.transaction.annotation.Transactional

@Transactional
@AutoConfigureMockMvc
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // BeforeAll
class MemberControllerTest(
    private val objectMapper: ObjectMapper,
    private val mockMvc: MockMvc,
) {

    @Test
    @DisplayName("로그인 테스트")
    fun `로그인 테스트 jwt 토큰발급 테스트` () {

        val reqSignin: ReqSignin = ReqSignin("test", "test")
        val signinDtoJson = objectMapper.writeValueAsString(reqSignin)

        mockMvc.post("/api/members/signin")
        {
            contentType = MediaType.APPLICATION_JSON
            content = signinDtoJson
        }
            .andExpect {
                status { isOk() }
            }
            .andDo {
                print()
            }
    }
}