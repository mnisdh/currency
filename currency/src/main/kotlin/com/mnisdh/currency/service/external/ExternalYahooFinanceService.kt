package com.mnisdh.currency.service.external

import com.mnisdh.common.util.DateUtil
import com.mnisdh.currency.enums.CurrencyType
import com.mnisdh.currency.enums.InstitutionType
import com.mnisdh.currency.service.external.dto.*
import com.mnisdh.currency.service.external.enums.YahooIncludeType
import com.mnisdh.currency.service.external.enums.YahooIntervalType
import com.mnisdh.currency.service.external.enums.YahooMetricType
import com.mnisdh.currency.service.external.enums.YahooModuleType
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.LocalDate

@Service
class ExternalYahooFinanceService(
    private val restTemplate: RestTemplate
) {
    private val currencyUrl: String = "https://query1.finance.yahoo.com/v7/finance/quote"

    fun getCurrency(baseCurrencyType: CurrencyType, exchangeCurrencyType: CurrencyType, exchangeDate: LocalDate): ExternalYahooQuoteResponse? {
        val symbol = getSymbol(exchangeCurrencyType, baseCurrencyType)
        val url = "$currencyUrl?&symbols=$symbol"

        val result = restTemplate.getForEntity(url, ExternalYahooQuoteResponse::class.java)

        if(baseCurrencyType == CurrencyType.KRW && exchangeCurrencyType == CurrencyType.JPY) {
            val regularMarketPrice = result.body?.getLatest()?.regularMarketPrice
            if(regularMarketPrice != null) result.body?.getLatest()?.regularMarketPrice = regularMarketPrice * 100
        }

        return result.body
    }

    private fun getSymbol(baseCurrencyType: CurrencyType, exchangeCurrencyType: CurrencyType): String {
        return InstitutionType.YAHOO.symbol(exchangeCurrencyType, baseCurrencyType)
    }

    private fun findSearchFinance(
        q: String
    ): ExternalYahooSearchFinanceResponse? {
        val url = "https://query1.finance.yahoo.com/v1/finance/search?q=$q"

        val result = restTemplate.getForEntity(url, ExternalYahooSearchFinanceResponse::class.java)

        return result.body
    }

    private fun findFinanceQuote(
        symbols: Set<String>,
        includes: Set<YahooIncludeType>?
    ): ExternalYahooFinanceQuoteResponse? {
        var url = "https://query1.finance.yahoo.com/v7/finance/quote?symbols=${symbols.joinToString(",")}"
        includes?.let { url += "&includes=${YahooIncludeType.toString(it)}" }

        val result = restTemplate.getForEntity(url, ExternalYahooFinanceQuoteResponse::class.java)

        return result.body
    }

    private fun findQuoteSummary(
        symbol: String,
        modules: Set<YahooModuleType>
    ): ExternalYahooQuoteSummaryResponse? {
        val url = "https://query1.finance.yahoo.com/v11/finance/quoteSummary/$symbol?modules=${YahooModuleType.toString(modules)}"
        val result = restTemplate.getForEntity(url, ExternalYahooQuoteSummaryResponse::class.java)

        return result.body
    }

    private fun findFinanceChart(
        symbol: String,
        metricTypes: Set<YahooMetricType>?,
        intervalType: YahooIntervalType?,
        range: String?,
        period1: LocalDate?,
        period2: LocalDate?,
        close: String?,
        events: String?,
        includePrePost: Boolean?
    ): ExternalYahooFinanceChartResponse? {
        var url = "https://query1.finance.yahoo.com/v8/finance/chart/$symbol"
        var params = ""
        metricTypes?.let { params += "&metrics=${YahooMetricType.toString(it)}" }
        intervalType?.let { params += "&interval=${it.getCode()}" }
        range?.let { params += "&range=$it" }
        period1?.let { params += "&period1=${DateUtil.format(it, "yyyy-MM-dd")}" }
        period2?.let { params += "&period1=${DateUtil.format(it, "yyyy-MM-dd")}" }
        close?.let { params += "&close=$it" }
        events?.let { params += "&events=$it" }
        includePrePost?.let { params += "&includePrePost=$it" }
        if(params.isNotEmpty()) url = "$url?${params.substring(1)}"

        val result = restTemplate.getForEntity(url, ExternalYahooFinanceChartResponse::class.java)

        return result.body
    }

}