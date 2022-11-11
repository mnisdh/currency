package com.mnisdh.currency.service.external.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.mnisdh.currency.enums.CurrencyType
import com.mnisdh.currency.service.dto.CurrencyDto
import com.mnisdh.common.exception.BaseNotFoundException
import java.time.LocalDate

data class ExternalYahooQuoteResponse(
    @JsonProperty("quoteResponse")
    val result: ExternalYahooQuoteResultDto?,

    val error: Any? = null
): BaseExternalCurrency {

    override fun to(exchangeDate: LocalDate, baseCurrencyType: CurrencyType, exchangeCurrencyType: CurrencyType): CurrencyDto {
        val latest = this.getLatest() ?: throw BaseNotFoundException()
        return CurrencyDto.of(latest, exchangeDate, baseCurrencyType, exchangeCurrencyType)
    }

    fun getLatest(): ExternalYahooQuoteItemDto? {
        return this.result?.items?.first()
    }

}
