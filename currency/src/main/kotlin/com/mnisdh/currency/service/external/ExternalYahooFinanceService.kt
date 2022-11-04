package com.mnisdh.currency.service.external

import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ExternalYahooFinanceService(
    private val restTemplate: RestTemplate,
) {

    fun getCurrency() {

    }

}