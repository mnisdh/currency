package com.mnisdh.currency.schedule

import com.mnisdh.currency.service.CurrencyService
import org.springframework.scheduling.annotation.Scheduled


class CurrencyScheduler(
    private val currencyService: CurrencyService
) {

//    @Scheduled(cron = "0 0 6,15 * * MON-FRI")
//    fun saveCurrency() {
//
//    }

}