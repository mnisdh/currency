package com.mnisdh.currency.service.external.dto

data class ExternalYahooFinanceChartResponse(
    val chart: ExternalYahooFinanceChartDto?
)

data class ExternalYahooFinanceChartDto (
    val result: List<ExternalYahooFinanceChartResult>?,
    val error: Any?
)

data class ExternalYahooFinanceChartResult (
    val meta: ExternalYahooFinanceChartMeta?,
    val timestamp: List<Long>?,
    val indicators: ExternalYahooFinanceChartIndicators?
)

data class ExternalYahooFinanceChartIndicators (
    val quote: List<ExternalYahooFinanceChartQuote>?,
    val adjclose: List<ExternalYahooFinanceChartAdjclose>?
)

data class ExternalYahooFinanceChartAdjclose (
    val adjclose: List<Double>?
)

data class ExternalYahooFinanceChartQuote (
    val low: List<Double>?,
    val open: List<Double>?,
    val high: List<Double>?,
    val volume: List<Long>?,
    val close: List<Double>?
)

data class ExternalYahooFinanceChartMeta (
    val currency: String?,
    val symbol: String?,
    val exchangeName: String?,
    val instrumentType: String?,
    val firstTradeDate: Long?,
    val regularMarketTime: Long?,
    val gmtoffset: Long?,
    val timezone: String?,
    val exchangeTimezoneName: String?,
    val regularMarketPrice: Double?,
    val chartPreviousClose: Double?,
    val priceHint: Long?,
    val currentTradingPeriod: ExternalYahooFinanceChartCurrentTradingPeriod?,
    val dataGranularity: String?,
    val range: String?,
    val validRanges: List<String>?
)

data class ExternalYahooFinanceChartCurrentTradingPeriod (
    val pre: ExternalYahooFinanceChartPost?,
    val regular: ExternalYahooFinanceChartPost?,
    val post: ExternalYahooFinanceChartPost?
)

data class ExternalYahooFinanceChartPost (
    val timezone: String?,
    val end: Long?,
    val start: Long?,
    val gmtoffset: Long?
)