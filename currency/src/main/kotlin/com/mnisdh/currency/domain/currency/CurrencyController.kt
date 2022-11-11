package com.mnisdh.currency.domain.currency

import com.mnisdh.currency.enums.CurrencyType
import com.mnisdh.currency.enums.InstitutionType
import com.mnisdh.currency.service.CurrencyService
import com.mnisdh.currency.service.dto.CurrencyDto
import com.mnisdh.common.rest.DefaultResponse
import org.springframework.format.annotation.DateTimeFormat
import org.springframework.web.bind.annotation.*
import java.time.LocalDate

@RestController
@RequestMapping("/api/currency")
class CurrencyController(
    private val service: CurrencyService
) {

    @GetMapping("/{institution-type}/{currency-type}")
    fun getCurrency(
        @PathVariable("institution-type") institutionType: InstitutionType,
        @PathVariable("currency-type") currencyType: CurrencyType
    ): DefaultResponse<CurrencyDto> {
        val data = service.getCurrencyByKRW(institutionType, currencyType)
        return DefaultResponse(data)
    }

    @GetMapping("/{institution-type}/{currency-type}/{target-date}")
    fun getCurrencyByDate(
        @PathVariable("institution-type") institutionType: InstitutionType,
        @PathVariable("currency-type") currencyType: CurrencyType,
        @PathVariable("target-date") @DateTimeFormat(pattern = "yyyy-MM-dd") targetDate: LocalDate
    ): DefaultResponse<CurrencyDto> {
        val data = service.getCurrencyByKRW(institutionType, currencyType, targetDate)
        return DefaultResponse(data)
    }

}