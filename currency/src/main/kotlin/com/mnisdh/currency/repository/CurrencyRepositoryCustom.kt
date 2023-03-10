package com.mnisdh.currency.repository

import com.mnisdh.currency.entity.Currency
import com.mnisdh.currency.enums.CurrencyType
import com.mnisdh.currency.enums.InstitutionType
import java.time.LocalDate

interface CurrencyRepositoryCustom {

    fun getCurrency(institutionType: InstitutionType, baseCurrencyType: CurrencyType, exchangeCurrencyType: CurrencyType, exchangeDate: LocalDate): Currency
    fun getCurrencyByExchangeDate(institutionType: InstitutionType, baseCurrencyType: CurrencyType, exchangeCurrencyType: CurrencyType, exchangeDate: LocalDate): List<Currency>

}