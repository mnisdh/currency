package com.mnisdh.utils.config

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate

@Component
class BaseRestConfig {

    @Bean
    fun objectMapper(): ObjectMapper {
        val objectMapper = ObjectMapper()

        return objectMapper
    }

    @Bean
    fun restTempleate(): RestTemplate {
        val headers = HttpHeaders()
        headers.contentType = MediaType.APPLICATION_JSON

        val factory = HttpComponentsClientHttpRequestFactory()
        factory.setConnectTimeout(5000)
        factory.setReadTimeout(5000)

        val restTemplate = RestTemplate(factory)

        return restTemplate
    }

}