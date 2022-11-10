package com.mnisdh.currency.repository

import com.mnisdh.currency.entity.Currency
import org.springframework.data.jpa.repository.JpaRepository

interface CurrencyRepository: JpaRepository<Currency, Long>, CurrencyRepositoryCustom {
}