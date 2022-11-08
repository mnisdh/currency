package com.mnisdh.currency.service

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.enum.InstitutionType
import com.mnisdh.currency.service.external.ExternalKbstarFinanceService
import com.mnisdh.currency.service.external.ExternalShinhanFinanceService
import com.mnisdh.currency.service.external.ExternalWooriFinanceService
import com.mnisdh.currency.service.external.ExternalYahooFinanceService
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CurrencyService(
    private val externalYahooFinanceService: ExternalYahooFinanceService,
    private val externalKbstarFinanceService: ExternalKbstarFinanceService,
    private val externalShinhanFinanceService: ExternalShinhanFinanceService,
    private val externalWooriFinanceService: ExternalWooriFinanceService
) {

    fun getCurrency(institutionType: InstitutionType, currencyType: CurrencyType): Any? {
        return when(institutionType) {
            InstitutionType.YAHOO -> externalYahooFinanceService.getCurrency(currencyType)
            InstitutionType.WOORI -> externalWooriFinanceService.getCurrency(LocalDate.now(), currencyType)
            InstitutionType.SHINHAN -> externalShinhanFinanceService.getCurrency(LocalDate.now(), currencyType)
            InstitutionType.KBSTAR -> externalKbstarFinanceService.getCurrency(LocalDate.now(), currencyType)
            else -> null
        }
    }

}