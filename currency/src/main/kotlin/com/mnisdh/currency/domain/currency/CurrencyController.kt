package com.mnisdh.currency.domain.currency

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.service.external.ExternalYahooFinanceService
import com.mnisdh.currency.service.external.dto.ExternalYahooQuoteResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/currency")
class CurrencyController(
    private val yahooService: ExternalYahooFinanceService
) {

    @GetMapping("/yahoo")
    fun getCurrency(): ResponseEntity<ExternalYahooQuoteResponse> {
        val response = yahooService.getCurrency(CurrencyType.USD, CurrencyType.KRW)

        return ResponseEntity.ok(response)
    }

}