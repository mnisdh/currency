package com.mnisdh.currency.service.external

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.enum.InstitutionType
import com.mnisdh.currency.service.external.dto.ExternalYahooQuoteResponse
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ExternalYahooFinanceService(
    private val restTemplate: RestTemplate,
) {
    private val currencyUrl: String = "https://query1.finance.yahoo.com/v7/finance/quote"

    fun getCurrency(from: CurrencyType, to: CurrencyType): ExternalYahooQuoteResponse? {
        val symbol = CurrencyType.symbol(from, to, InstitutionType.YAHOO)
        val url = "%s?&symbols=%s".format(currencyUrl, symbol)

        val result = restTemplate.getForEntity(url, ExternalYahooQuoteResponse::class.java)

        return result.body
    }

}