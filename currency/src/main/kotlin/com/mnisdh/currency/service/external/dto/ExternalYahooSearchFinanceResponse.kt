package com.mnisdh.currency.service.external.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ExternalYahooSearchFinanceResponse(
    val explains: List<Any>?,
    val count: Long?,
    val quotes: List<ExternalYahooSearchFinanceQuote>?,
    val news: List<ExternalYahooSearchFinanceNews>?,
    val nav: List<Any>?,
    val lists: List<Any>?,
    val researchReports: List<Any>?,
    val screenerFieldResults: List<Any>?,
    val totalTime: Long?,
    val timeTakenForQuotes: Long?,
    val timeTakenForNews: Long?,
    val timeTakenForAlgowatchlist: Long?,
    val timeTakenForPredefinedScreener: Long?,
    val timeTakenForCrunchbase: Long?,
    val timeTakenForNav: Long?,
    val timeTakenForResearchReports: Long?,
    val timeTakenForScreenerField: Long?,
    val timeTakenForCulturalAssets: Long?
)

data class ExternalYahooSearchFinanceNews (
    val uuid: String?,
    val title: String?,
    val publisher: String?,
    val link: String?,
    val providerPublishTime: Long?,
    val type: String?,
    val thumbnail: ExternalYahooSearchFinanceThumbnail?,
    val relatedTickers: List<String>?
)

data class ExternalYahooSearchFinanceThumbnail (
    val resolutions: List<ExternalYahooSearchFinanceResolution>?
)

data class ExternalYahooSearchFinanceResolution (
    val url: String?,
    val width: Long?,
    val height: Long?,
    val tag: String?
)

data class ExternalYahooSearchFinanceQuote (
    val exchange: String?,
    val shortname: String?,
    val quoteType: String?,
    val symbol: String?,
    val index: String?,
    val score: Double?,
    val typeDisp: String?,
    val longname: String?,
    val exchDisp: String?,
    val sector: String?,
    val industry: String?,

    @JsonProperty("dispSecIndFlag")
    val dispSECIndFlag: Boolean?,

    val isYahooFinance: Boolean?
)