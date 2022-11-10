package com.mnisdh.currency.service.dto

import com.mnisdh.currency.entity.Currency
import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.enum.InstitutionType
import com.mnisdh.currency.service.external.dto.*
import java.time.LocalDate

data class CurrencyDto(
    val institutionType: InstitutionType = InstitutionType.NONE,
    val baseCurrencyType: CurrencyType = CurrencyType.NONE,
    val exchangeCurrencyType: CurrencyType = CurrencyType.NONE,
    val exchangeDate: LocalDate = LocalDate.now(),
    val exchangeRate: Float = 0f,
    val buyingSpreadRate: Float? = null,
    val sellingSpreadRate: Float? = null
) {
    companion object {
        fun of(response: ExternalYahooQuoteItemDto, exchangeDate: LocalDate, baseCurrencyType: CurrencyType, exchangeCurrencyType: CurrencyType): CurrencyDto = CurrencyDto(
            institutionType = InstitutionType.YAHOO,
            baseCurrencyType = baseCurrencyType,
            exchangeCurrencyType = exchangeCurrencyType,
            exchangeDate = exchangeDate,
            exchangeRate = response.regularMarketPrice ?: 0f
        )
        fun of(response: ExternalWooriCurrencyResponse, exchangeDate: LocalDate, baseCurrencyType: CurrencyType, exchangeCurrencyType: CurrencyType): CurrencyDto = CurrencyDto(
            institutionType = InstitutionType.WOORI,
            baseCurrencyType = baseCurrencyType,
            exchangeCurrencyType = exchangeCurrencyType,
            exchangeDate = exchangeDate,
            exchangeRate = response.salesStandardRate ?: 0f,
            buyingSpreadRate = response.buyingSpreadRate,
            sellingSpreadRate = response.sellingSpreadRate
        )
        fun of(response: ExternalShinhanCurrencyResultDto, exchangeDate: LocalDate, baseCurrencyType: CurrencyType, exchangeCurrencyType: CurrencyType): CurrencyDto = CurrencyDto(
            institutionType = InstitutionType.SHINHAN,
            baseCurrencyType = baseCurrencyType,
            exchangeCurrencyType = exchangeCurrencyType,
            exchangeDate = exchangeDate,
            exchangeRate = response.exchangeRate ?: 0f,
            buyingSpreadRate = response.ttBuyingRate,
            sellingSpreadRate = response.ttSellingRate
        )
        fun of(response: ExternalKbstarCurrencyResponse, exchangeDate: LocalDate, baseCurrencyType: CurrencyType, exchangeCurrencyType: CurrencyType): CurrencyDto = CurrencyDto(
            institutionType = InstitutionType.KBSTAR,
            baseCurrencyType = baseCurrencyType,
            exchangeCurrencyType = exchangeCurrencyType,
            exchangeDate = exchangeDate,
            exchangeRate = response.latestRate ?: 0f,
            buyingSpreadRate = response.buyingSpreadRate,
            sellingSpreadRate = response.sellingSpreadRate
        )
    }

    fun createEntity(): Currency = Currency.create(
            institutionType = this.institutionType,
            baseCurrencyType = this.baseCurrencyType,
            exchangeCurrencyType = this.exchangeCurrencyType,
            exchangeDate = this.exchangeDate,
            exchangeRate = this.exchangeRate,
            buyingSpreadRate = this.buyingSpreadRate,
            sellingSpreadRate = this.sellingSpreadRate
    )

}
