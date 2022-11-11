package com.mnisdh.currency.service

import com.fasterxml.jackson.databind.ObjectMapper
import com.mnisdh.currency.enums.CurrencyType
import com.mnisdh.currency.enums.InstitutionType
import com.mnisdh.currency.repository.CurrencyRepository
import com.mnisdh.currency.service.dto.CurrencyDto
import com.mnisdh.currency.service.external.ExternalKbstarFinanceService
import com.mnisdh.currency.service.external.ExternalShinhanFinanceService
import com.mnisdh.currency.service.external.ExternalWooriFinanceService
import com.mnisdh.currency.service.external.ExternalYahooFinanceService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
@Transactional(readOnly = true)
class CurrencyService(
    private val objectMapper: ObjectMapper,
    private val repository: CurrencyRepository,
    private val externalYahooFinanceService: ExternalYahooFinanceService,
    private val externalKbstarFinanceService: ExternalKbstarFinanceService,
    private val externalShinhanFinanceService: ExternalShinhanFinanceService,
    private val externalWooriFinanceService: ExternalWooriFinanceService
) {

    fun getCurrencyByKRW(institutionType: InstitutionType, exchangeCurrencyType: CurrencyType, exchangeDate: LocalDate): CurrencyDto? {
        val baseCurrencyType = CurrencyType.KRW

        return when(institutionType) {
            InstitutionType.YAHOO -> externalYahooFinanceService.getCurrency(baseCurrencyType, exchangeCurrencyType, exchangeDate)
                ?.to(exchangeDate, baseCurrencyType, exchangeCurrencyType)
            InstitutionType.WOORI -> externalWooriFinanceService.getCurrency(exchangeCurrencyType, exchangeDate)
                .to(exchangeDate, baseCurrencyType, exchangeCurrencyType)
            InstitutionType.SHINHAN -> externalShinhanFinanceService.getCurrency(exchangeCurrencyType, exchangeDate)
                ?.to(exchangeDate, baseCurrencyType, exchangeCurrencyType)
            InstitutionType.KBSTAR -> externalKbstarFinanceService.getCurrency(exchangeCurrencyType, exchangeDate)
                ?.to(exchangeDate, baseCurrencyType, exchangeCurrencyType)
            else -> CurrencyDto()
        }
    }

    fun getCurrencyByKRW(institutionType: InstitutionType, exchangeCurrencyType: CurrencyType): CurrencyDto? {
        return this.getCurrencyByKRW(institutionType, exchangeCurrencyType, LocalDate.now())
    }

    @Transactional
    fun save(currencyDto: CurrencyDto) {
        repository.save(currencyDto.createEntity())
    }

    @Transactional
    fun save(currencyDtos: List<CurrencyDto>) {
        repository.saveAll(currencyDtos.map { it.createEntity() }.toList())
    }

}