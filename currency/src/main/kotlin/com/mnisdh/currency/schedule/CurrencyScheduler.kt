package com.mnisdh.currency.schedule

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.enum.InstitutionType
import com.mnisdh.currency.service.CurrencyService
import com.mnisdh.currency.service.dto.CurrencyDto
import org.springframework.scheduling.annotation.Scheduled


class CurrencyScheduler(
    private val currencyService: CurrencyService
) {

    @Scheduled(cron = "0 0 * * * *") //매시간
    fun runByTime() {
        saveCurrencyByKRW()
    }

    private fun saveCurrencyByKRW() {
        val currencyDtos: List<CurrencyDto> = ArrayList()
        InstitutionType.allowsByKorea().forEach { institutionType ->
            CurrencyType.allowsByExcept(setOf(CurrencyType.NONE, CurrencyType.KRW)).forEach { currencyType ->
                currencyDtos.plus(currencyService.getCurrencyByKRW(institutionType, currencyType))
            }
        }

        currencyService.save(currencyDtos)
    }

}