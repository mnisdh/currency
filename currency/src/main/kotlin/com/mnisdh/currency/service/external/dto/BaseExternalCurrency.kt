package com.mnisdh.currency.service.external.dto

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.service.dto.CurrencyDto
import java.time.LocalDate

interface BaseExternalCurrency {

    fun to(exchangeDate: LocalDate, baseCurrencyType: CurrencyType, exchangeCurrencyType: CurrencyType): CurrencyDto

}