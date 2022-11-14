package com.mnisdh.currency.service.external.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ExternalYahooFinanceQuoteResponse(
    val quoteResponse: ExternalYahooFinanceQuoteDto?
)

data class ExternalYahooFinanceQuoteDto (
    val result: List<ExternalYahooFinanceQuoteResult>?,
    val error: Any?
)

data class ExternalYahooFinanceQuoteResult (
    val language: String?,
    val region: String?,
    val quoteType: String?,
    val typeDisp: String?,
    val quoteSourceName: String?,
    val triggerable: Boolean?,
    val customPriceAlertConfidence: String?,
    val currency: String?,
    val marketState: String?,
    val financialCurrency: String?,
    val regularMarketOpen: Double?,
    val averageDailyVolume3Month: Long?,
    val averageDailyVolume10Day: Long?,
    val fiftyTwoWeekLowChange: Double?,
    val fiftyTwoWeekLowChangePercent: Double?,
    val fiftyTwoWeekRange: String?,
    val fiftyTwoWeekHighChange: Double?,
    val fiftyTwoWeekHighChangePercent: Double?,
    val fiftyTwoWeekLow: Double?,
    val fiftyTwoWeekHigh: Double?,
    val earningsTimestamp: Long?,
    val earningsTimestampStart: Long?,
    val earningsTimestampEnd: Long?,
    val trailingAnnualDividendRate: Double?,
    val trailingPE: Double?,
    val trailingAnnualDividendYield: Double?,
    val epsTrailingTwelveMonths: Double?,
    val epsForward: Double?,
    val epsCurrentYear: Double?,
    val priceEpsCurrentYear: Double?,
    val regularMarketChangePercent: Double?,
    val regularMarketPrice: Double?,
    val sharesOutstanding: Long?,
    val bookValue: Double?,
    val fiftyDayAverage: Double?,
    val fiftyDayAverageChange: Double?,
    val fiftyDayAverageChangePercent: Double?,
    val twoHundredDayAverage: Double?,
    val twoHundredDayAverageChange: Double?,
    val twoHundredDayAverageChangePercent: Double?,
    val marketCap: Long?,
    val forwardPE: Double?,
    val priceToBook: Double?,
    val sourceInterval: Long?,
    val exchangeDataDelayedBy: Long?,
    val averageAnalystRating: String?,
    val exchange: String?,
    val shortName: String?,
    val longName: String?,

    @JsonProperty("messageBoardId")
    val messageBoardID: String?,

    val exchangeTimezoneName: String?,
    val exchangeTimezoneShortName: String?,
    val gmtOffSetMilliseconds: Long?,
    val market: String?,
    val esgPopulated: Boolean?,
    val tradeable: Boolean?,
    val cryptoTradeable: Boolean?,
    val firstTradeDateMilliseconds: Long?,
    val priceHint: Long?,
    val postMarketChangePercent: Double?,
    val postMarketTime: Long?,
    val postMarketPrice: Double?,
    val postMarketChange: Double?,
    val regularMarketChange: Double?,
    val regularMarketTime: Long?,
    val regularMarketDayHigh: Double?,
    val regularMarketDayRange: String?,
    val regularMarketDayLow: Double?,
    val regularMarketVolume: Long?,
    val regularMarketPreviousClose: Double?,
    val bid: Double?,
    val ask: Double?,
    val bidSize: Long?,
    val askSize: Long?,
    val fullExchangeName: String?,
    val displayName: String?,
    val symbol: String?,
    val dividendDate: Long?
)