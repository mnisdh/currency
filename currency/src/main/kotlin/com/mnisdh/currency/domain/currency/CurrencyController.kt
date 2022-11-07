package com.mnisdh.currency.domain.currency

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.enum.InstitutionType
import com.mnisdh.currency.service.CurrencyService
import com.mnisdh.currency.service.external.ExternalYahooFinanceService
import com.mnisdh.currency.service.external.dto.ExternalYahooQuoteResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/currency")
class CurrencyController(
    private val service: CurrencyService,
    private val yahooService: ExternalYahooFinanceService
) {

    @GetMapping("/{institution-type}/{currency-type}")
    fun getCurrency(
        @PathVariable("institution-type") institutionType: InstitutionType,
        @PathVariable("currency-type") currencyType: CurrencyType
    ): ResponseEntity<ExternalYahooQuoteResponse> {
        service.getCurrency(institutionType, currencyType)

        return ResponseEntity.ok(null)
    }

}