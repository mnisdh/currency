package com.mnisdh.currency.service

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.enum.InstitutionType
import com.mnisdh.currency.service.external.ExternalKbFinanceService
import com.mnisdh.currency.service.external.ExternalShinhanFinanceService
import com.mnisdh.currency.service.external.ExternalWooriFinanceService
import com.mnisdh.currency.service.external.ExternalYahooFinanceService
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class CurrencyService(
    private val externalYahooFinanceService: ExternalYahooFinanceService,
    private val externalKbFinanceService: ExternalKbFinanceService,
    private val externalShinhanFinanceService: ExternalShinhanFinanceService,
    private val externalWooriFinanceService: ExternalWooriFinanceService
) {

    fun getCurrency(institutionType: InstitutionType, currencyType: CurrencyType) {
        when(institutionType) {
            InstitutionType.YAHOO -> externalYahooFinanceService.getCurrency(currencyType)
            InstitutionType.WOORI -> externalWooriFinanceService.getCurrency(LocalDate.now(), currencyType)
            InstitutionType.SHINHAN -> null
            InstitutionType.KB -> null
            else -> null
        }
    }

}