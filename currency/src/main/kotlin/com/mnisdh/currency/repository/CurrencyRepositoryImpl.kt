package com.mnisdh.currency.repository

import com.mnisdh.common.jpa.BaseQueryDslRepository
import com.mnisdh.currency.entity.Currency
import com.mnisdh.currency.entity.QCurrency
import com.mnisdh.currency.enums.CurrencyType
import com.mnisdh.currency.enums.InstitutionType
import com.querydsl.jpa.impl.JPAQueryFactory
import java.time.LocalDate

class CurrencyRepositoryImpl(jpaQueryFactory: JPAQueryFactory) : BaseQueryDslRepository(jpaQueryFactory), CurrencyRepositoryCustom {

    private val currency = QCurrency.currency

    override fun getCurrency(
        institutionType: InstitutionType,
        baseCurrencyType: CurrencyType,
        exchangeCurrencyType: CurrencyType,
        exchangeDate: LocalDate
    ): Currency {
        return jpaQueryFactory
            .selectFrom(currency)
            .where(
                currency.institutionType.eq(institutionType),
                currency.baseCurrencyType.eq(baseCurrencyType),
                currency.exchangeCurrencyType.eq(exchangeCurrencyType),
                currency.exchangeDate.eq(exchangeDate)
            )
            .fetchFirst()
    }

    override fun getCurrencyByExchangeDate(
        institutionType: InstitutionType,
        baseCurrencyType: CurrencyType,
        exchangeCurrencyType: CurrencyType,
        exchangeDate: LocalDate
    ): List<Currency> {
        return jpaQueryFactory
            .selectFrom(currency)
            .where(
                currency.institutionType.eq(institutionType),
                currency.baseCurrencyType.eq(baseCurrencyType),
                currency.exchangeCurrencyType.eq(exchangeCurrencyType),
                currency.exchangeDate.eq(exchangeDate)
            )
            .fetch()
    }
}