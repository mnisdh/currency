package com.mnisdh.currency.service.external

import com.mnisdh.currency.enums.CurrencyType
import com.mnisdh.currency.enums.InstitutionType
import com.mnisdh.currency.service.external.dto.ExternalYahooQuoteResponse
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.LocalDate

@Service
class ExternalYahooFinanceService(
    private val restTemplate: RestTemplate
) {
//    private val currencyUrl: String = "https://query1.finance.yahoo.com/v10/finance/quoteSummary"
    private val currencyUrl: String = "https://query1.finance.yahoo.com/v7/finance/quote"

    fun getCurrency(baseCurrencyType: CurrencyType, exchangeCurrencyType: CurrencyType, exchangeDate: LocalDate): ExternalYahooQuoteResponse? {
        val symbol = InstitutionType.YAHOO.symbol(exchangeCurrencyType, baseCurrencyType)
        val url = "%s?&symbols=%s".format(currencyUrl, symbol)

        val result = restTemplate.getForEntity(url, ExternalYahooQuoteResponse::class.java)

        if(baseCurrencyType == CurrencyType.KRW && exchangeCurrencyType == CurrencyType.JPY) {
            val regularMarketPrice = result.body?.getLatest()?.regularMarketPrice
            if(regularMarketPrice != null) result.body?.getLatest()?.regularMarketPrice = regularMarketPrice * 100
        }

        return result.body
    }

}