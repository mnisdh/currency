package com.mnisdh.currency.schedule

import com.mnisdh.currency.enums.CurrencyType
import com.mnisdh.currency.enums.InstitutionType
import com.mnisdh.currency.service.CurrencyService
import com.mnisdh.currency.service.dto.CurrencyDto
import org.springframework.scheduling.annotation.Async
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component

@Component
class CurrencyScheduler(
    private val currencyService: CurrencyService
) {

    @Scheduled(cron = "0 10 * * * *") //매시간
    fun runByTime() {
        asnycSaveCurrencyByKRW()
    }

    @Async
    fun asnycSaveCurrencyByKRW() {
        val currencyDtos: MutableList<CurrencyDto> = mutableListOf()
        InstitutionType.allowsByKorea().forEach { institutionType ->
            CurrencyType.allowsByExcept(setOf(CurrencyType.NONE, CurrencyType.KRW)).forEach { currencyType ->
                val currencyDto = currencyService.getCurrencyByKRW(institutionType, currencyType)
                if(currencyDto != null) currencyDtos.add(currencyDto)
            }
        }

        currencyService.save(currencyDtos)
    }

}