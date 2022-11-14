package com.mnisdh.currency.service.external.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ExternalYahooQuoteSummaryResponse(
    val quoteSummary: ExternalYahooQuoteSummaryDto?
)

data class ExternalYahooQuoteSummaryDto(
    val result: List<ExternalYahooQuoteSummaryResult>?,
    val error: Any?
)

data class ExternalYahooQuoteSummaryResult (
    val assetProfile: ExternalYahooQuoteSummaryAssetProfile?,
    val recommendationTrend: ExternalYahooQuoteSummaryRecommendationTrend?,
    val majorHoldersBreakdown: ExternalYahooQuoteSummaryMajorHoldersBreakdown?,
    val earningsHistory: ExternalYahooQuoteSummaryEarningsHistory?,
    val indexTrend: ExternalYahooQuoteSummaryIndexTrend?,
    val defaultKeyStatistics: ExternalYahooQuoteSummaryDefaultKeyStatistics?,
    val industryTrend: ExternalYahooQuoteSummaryTrend?,
    val netSharePurchaseActivity: ExternalYahooQuoteSummaryNetSharePurchaseActivity?,
    val sectorTrend: ExternalYahooQuoteSummaryTrend?,
    val insiderHolders: ExternalYahooQuoteSummaryInsiderHolders?,
    val earnings: ExternalYahooQuoteSummaryEarnings?,
    val upgradeDowngradeHistory: ExternalYahooQuoteSummaryUpgradeDowngradeHistory?,
    val earningsTrend: ExternalYahooQuoteSummaryEarningsTrend?,
    val financialData: ExternalYahooQuoteSummaryFinancialData?
)

data class ExternalYahooQuoteSummaryAssetProfile (
    val address1: String?,
    val city: String?,
    val state: String?,
    val zip: String?,
    val country: String?,
    val phone: String?,
    val website: String?,
    val industry: String?,
    val sector: String?,
    val longBusinessSummary: String?,
    val fullTimeEmployees: Long?,
    val companyOfficers: List<ExternalYahooQuoteSummaryCompanyOfficer>?,
    val auditRisk: Long?,
    val boardRisk: Long?,
    val compensationRisk: Long?,
    val shareHolderRightsRisk: Long?,
    val overallRisk: Long?,
    val governanceEpochDate: Long?,
    val compensationAsOfEpochDate: Long?,
    val maxAge: Long?
)

data class ExternalYahooQuoteSummaryCompanyOfficer (
    val maxAge: Long?,
    val name: String?,
    val age: Long?,
    val title: String?,
    val yearBorn: Long?,
    val fiscalYear: Long?,
    val totalPay: ExternalYahooQuoteSummaryEnterpriseValue?,
    val exercisedValue: ExternalYahooQuoteSummaryEnterpriseValue?,
    val unexercisedValue: ExternalYahooQuoteSummaryEnterpriseValue?
)

data class ExternalYahooQuoteSummaryEnterpriseValue (
    val raw: Long?,
    val fmt: String?,
    val longFmt: String?
)

data class ExternalYahooQuoteSummaryDefaultKeyStatistics (
    val maxAge: Long?,
    val priceHint: ExternalYahooQuoteSummaryEnterpriseValue?,
    val enterpriseValue: ExternalYahooQuoteSummaryEnterpriseValue?,
    val forwardPE: ExternalYahooQuoteSummaryTheWeekChange?,
    val profitMargins: ExternalYahooQuoteSummaryTheWeekChange?,
    val floatShares: ExternalYahooQuoteSummaryEnterpriseValue?,
    val sharesOutstanding: ExternalYahooQuoteSummaryEnterpriseValue?,
    val sharesShort: ExternalYahooQuoteSummaryEnterpriseValue?,
    val sharesShortPriorMonth: ExternalYahooQuoteSummaryEnterpriseValue?,
    val sharesShortPreviousMonthDate: ExternalYahooQuoteSummaryTheWeekChange?,
    val dateShortInterest: ExternalYahooQuoteSummaryTheWeekChange?,
    val sharesPercentSharesOut: ExternalYahooQuoteSummaryTheWeekChange?,
    val heldPercentInsiders: ExternalYahooQuoteSummaryTheWeekChange?,
    val heldPercentInstitutions: ExternalYahooQuoteSummaryTheWeekChange?,
    val shortRatio: ExternalYahooQuoteSummaryTheWeekChange?,
    val shortPercentOfFloat: ExternalYahooQuoteSummaryTheWeekChange?,
    val beta: ExternalYahooQuoteSummaryTheWeekChange?,
    val impliedSharesOutstanding: ExternalYahooQuoteSummaryEnterpriseValue?,
    val morningStarOverallRating: Any?,
    val morningStarRiskRating: Any?,
    val category: Any?,
    val bookValue: ExternalYahooQuoteSummaryTheWeekChange?,
    val priceToBook: ExternalYahooQuoteSummaryTheWeekChange?,
    val annualReportExpenseRatio: Any?,
    val ytdReturn: Any?,
    val beta3Year: Any?,
    val totalAssets: Any?,
    val yield: Any?,
    val fundFamily: Any?,
    val fundInceptionDate: Any?,
    val legalType: Any?,
    val threeYearAverageReturn: Any?,
    val fiveYearAverageReturn: Any?,
    val priceToSalesTrailing12Months: Any?,
    val lastFiscalYearEnd: ExternalYahooQuoteSummaryTheWeekChange?,
    val nextFiscalYearEnd: ExternalYahooQuoteSummaryTheWeekChange?,
    val mostRecentQuarter: ExternalYahooQuoteSummaryTheWeekChange?,
    val earningsQuarterlyGrowth: ExternalYahooQuoteSummaryTheWeekChange?,
    val revenueQuarterlyGrowth: Any?,
    val netIncomeToCommon: ExternalYahooQuoteSummaryEnterpriseValue?,
    val trailingEps: ExternalYahooQuoteSummaryTheWeekChange?,
    val forwardEps: ExternalYahooQuoteSummaryTheWeekChange?,
    val pegRatio: ExternalYahooQuoteSummaryTheWeekChange?,
    val lastSplitFactor: String?,
    val lastSplitDate: ExternalYahooQuoteSummaryTheWeekChange?,
    val enterpriseToRevenue: ExternalYahooQuoteSummaryTheWeekChange?,
    val enterpriseToEbitda: ExternalYahooQuoteSummaryTheWeekChange?,

    @JsonProperty("52WeekChange")
    val the52WeekChange: ExternalYahooQuoteSummaryTheWeekChange?,

    @JsonProperty("SandP52WeekChange")
    val sandP52WeekChange: ExternalYahooQuoteSummaryTheWeekChange?,

    val lastDividendValue: ExternalYahooQuoteSummaryTheWeekChange?,
    val lastDividendDate: ExternalYahooQuoteSummaryTheWeekChange?,
    val lastCapGain: Any?,
    val annualHoldingsTurnover: Any?
)

data class ExternalYahooQuoteSummaryTheWeekChange (
    val raw: Double?,
    val fmt: String?
)

data class ExternalYahooQuoteSummaryEarnings (
    val maxAge: Long?,
    val earningsChart: ExternalYahooQuoteSummaryEarningsChart?,
    val financialsChart: ExternalYahooQuoteSummaryFinancialsChart?,
    val financialCurrency: String?
)

data class ExternalYahooQuoteSummaryEarningsChart (
    val quarterly: List<ExternalYahooQuoteSummaryEarningsChartQuarterly>?,
    val currentQuarterEstimate: ExternalYahooQuoteSummaryTheWeekChange?,
    val currentQuarterEstimateDate: String?,
    val currentQuarterEstimateYear: Long?,
    val earningsDate: List<ExternalYahooQuoteSummaryTheWeekChange>?
)

data class ExternalYahooQuoteSummaryEarningsChartQuarterly (
    val date: String?,
    val actual: ExternalYahooQuoteSummaryTheWeekChange?,
    val estimate: ExternalYahooQuoteSummaryTheWeekChange?
)

data class ExternalYahooQuoteSummaryFinancialsChart (
    val yearly: List<ExternalYahooQuoteSummaryYearly>?,
    val quarterly: List<ExternalYahooQuoteSummaryFinancialsChartQuarterly>?
)

data class ExternalYahooQuoteSummaryFinancialsChartQuarterly (
    val date: String?,
    val revenue: ExternalYahooQuoteSummaryEnterpriseValue?,
    val earnings: ExternalYahooQuoteSummaryEnterpriseValue?
)

data class ExternalYahooQuoteSummaryYearly (
    val date: Long?,
    val revenue: ExternalYahooQuoteSummaryEnterpriseValue?,
    val earnings: ExternalYahooQuoteSummaryEnterpriseValue?
)

data class ExternalYahooQuoteSummaryEarningsHistory (
    val history: List<ExternalYahooQuoteSummaryEarningsHistoryHistory>?,
    val maxAge: Long?
)

data class ExternalYahooQuoteSummaryEarningsHistoryHistory (
    val maxAge: Long?,
    val epsActual: ExternalYahooQuoteSummaryTheWeekChange?,
    val epsEstimate: ExternalYahooQuoteSummaryTheWeekChange?,
    val epsDifference: ExternalYahooQuoteSummaryTheWeekChange?,
    val surprisePercent: ExternalYahooQuoteSummaryTheWeekChange?,
    val quarter: ExternalYahooQuoteSummaryTheWeekChange?,
    val period: String?
)

data class ExternalYahooQuoteSummaryEarningsTrend (
    val trend: List<ExternalYahooQuoteSummaryEarningsTrendTrend>?,
    val maxAge: Long?
)

data class ExternalYahooQuoteSummaryEarningsTrendTrend (
    val maxAge: Long?,
    val period: String?,
    val endDate: String?,
    val growth: ExternalYahooQuoteSummaryTheWeekChange?,
    val earningsEstimate: ExternalYahooQuoteSummaryEarningsEstimate?,
    val revenueEstimate: ExternalYahooQuoteSummaryRevenueEstimate?,
    val epsTrend: ExternalYahooQuoteSummaryEpsTrend?,
    val epsRevisions: ExternalYahooQuoteSummaryEpsRevisions?
)

data class ExternalYahooQuoteSummaryEarningsEstimate (
    val avg: ExternalYahooQuoteSummaryTheWeekChange?,
    val low: ExternalYahooQuoteSummaryTheWeekChange?,
    val high: ExternalYahooQuoteSummaryTheWeekChange?,
    val yearAgoEps: ExternalYahooQuoteSummaryTheWeekChange?,
    val numberOfAnalysts: ExternalYahooQuoteSummaryEnterpriseValue?,
    val growth: ExternalYahooQuoteSummaryTheWeekChange?
)

data class ExternalYahooQuoteSummaryEpsRevisions (
    @JsonProperty("upLast7days")
    val upLast7Days: ExternalYahooQuoteSummaryEnterpriseValue?,

    @JsonProperty("upLast30days")
    val upLast30Days: ExternalYahooQuoteSummaryEnterpriseValue?,

    @JsonProperty("downLast30days")
    val downLast30Days: ExternalYahooQuoteSummaryEnterpriseValue?,

    @JsonProperty("downLast90days")
    val downLast90Days: Any?
)

data class ExternalYahooQuoteSummaryEpsTrend (
    val current: ExternalYahooQuoteSummaryTheWeekChange?,

    @JsonProperty("7daysAgo")
    val the7DaysAgo: ExternalYahooQuoteSummaryTheWeekChange?,

    @JsonProperty("30daysAgo")
    val the30DaysAgo: ExternalYahooQuoteSummaryTheWeekChange?,

    @JsonProperty("60daysAgo")
    val the60DaysAgo: ExternalYahooQuoteSummaryTheWeekChange?,

    @JsonProperty("90daysAgo")
    val the90DaysAgo: ExternalYahooQuoteSummaryTheWeekChange?
)

data class ExternalYahooQuoteSummaryRevenueEstimate (
    val avg: ExternalYahooQuoteSummaryEnterpriseValue?,
    val low: ExternalYahooQuoteSummaryEnterpriseValue?,
    val high: ExternalYahooQuoteSummaryEnterpriseValue?,
    val numberOfAnalysts: ExternalYahooQuoteSummaryEnterpriseValue?,
    val yearAgoRevenue: ExternalYahooQuoteSummaryEnterpriseValue?,
    val growth: ExternalYahooQuoteSummaryTheWeekChange?
)

data class ExternalYahooQuoteSummaryFinancialData (
    val maxAge: Long?,
    val currentPrice: ExternalYahooQuoteSummaryTheWeekChange?,
    val targetHighPrice: ExternalYahooQuoteSummaryTheWeekChange?,
    val targetLowPrice: ExternalYahooQuoteSummaryTheWeekChange?,
    val targetMeanPrice: ExternalYahooQuoteSummaryTheWeekChange?,
    val targetMedianPrice: ExternalYahooQuoteSummaryTheWeekChange?,
    val recommendationMean: ExternalYahooQuoteSummaryTheWeekChange?,
    val recommendationKey: String?,
    val numberOfAnalystOpinions: ExternalYahooQuoteSummaryEnterpriseValue?,
    val totalCash: ExternalYahooQuoteSummaryEnterpriseValue?,
    val totalCashPerShare: ExternalYahooQuoteSummaryTheWeekChange?,
    val ebitda: ExternalYahooQuoteSummaryEnterpriseValue?,
    val totalDebt: ExternalYahooQuoteSummaryEnterpriseValue?,
    val quickRatio: ExternalYahooQuoteSummaryTheWeekChange?,
    val currentRatio: ExternalYahooQuoteSummaryTheWeekChange?,
    val totalRevenue: ExternalYahooQuoteSummaryEnterpriseValue?,
    val debtToEquity: ExternalYahooQuoteSummaryTheWeekChange?,
    val revenuePerShare: ExternalYahooQuoteSummaryTheWeekChange?,
    val returnOnAssets: ExternalYahooQuoteSummaryTheWeekChange?,
    val returnOnEquity: ExternalYahooQuoteSummaryTheWeekChange?,
    val grossProfits: ExternalYahooQuoteSummaryEnterpriseValue?,
    val freeCashflow: ExternalYahooQuoteSummaryEnterpriseValue?,
    val operatingCashflow: ExternalYahooQuoteSummaryEnterpriseValue?,
    val earningsGrowth: ExternalYahooQuoteSummaryTheWeekChange?,
    val revenueGrowth: ExternalYahooQuoteSummaryTheWeekChange?,
    val grossMargins: ExternalYahooQuoteSummaryTheWeekChange?,
    val ebitdaMargins: ExternalYahooQuoteSummaryTheWeekChange?,
    val operatingMargins: ExternalYahooQuoteSummaryTheWeekChange?,
    val profitMargins: ExternalYahooQuoteSummaryTheWeekChange?,
    val financialCurrency: String?
)

data class ExternalYahooQuoteSummaryIndexTrend (
    val maxAge: Long?,
    val symbol: String?,
    val peRatio: ExternalYahooQuoteSummaryTheWeekChange?,
    val pegRatio: ExternalYahooQuoteSummaryTheWeekChange?,
    val estimates: List<ExternalYahooQuoteSummaryEstimate>?
)

data class ExternalYahooQuoteSummaryEstimate (
    val period: String?,
    val growth: ExternalYahooQuoteSummaryTheWeekChange?
)

data class ExternalYahooQuoteSummaryTrend (
    val maxAge: Long?,
    val symbol: Any?,
    val peRatio: Any?,
    val pegRatio: Any?,
    val estimates: List<Any>?
)

data class ExternalYahooQuoteSummaryInsiderHolders (
    val holders: List<ExternalYahooQuoteSummaryHolder>?,
    val maxAge: Long?
)

data class ExternalYahooQuoteSummaryHolder (
    val maxAge: Long?,
    val name: String?,
    val relation: String?,
    val url: String?,
    val transactionDescription: String?,
    val latestTransDate: ExternalYahooQuoteSummaryTheWeekChange?,
    val positionDirect: ExternalYahooQuoteSummaryEnterpriseValue?,
    val positionDirectDate: ExternalYahooQuoteSummaryTheWeekChange?,
    val positionIndirect: ExternalYahooQuoteSummaryEnterpriseValue?,
    val positionIndirectDate: ExternalYahooQuoteSummaryTheWeekChange?
)

data class ExternalYahooQuoteSummaryMajorHoldersBreakdown (
    val maxAge: Long?,
    val insidersPercentHeld: ExternalYahooQuoteSummaryTheWeekChange?,
    val institutionsPercentHeld: ExternalYahooQuoteSummaryTheWeekChange?,
    val institutionsFloatPercentHeld: ExternalYahooQuoteSummaryTheWeekChange?,
    val institutionsCount: ExternalYahooQuoteSummaryEnterpriseValue?
)

data class ExternalYahooQuoteSummaryNetSharePurchaseActivity (
    val maxAge: Long?,
    val period: String?,
    val buyInfoCount: ExternalYahooQuoteSummaryEnterpriseValue?,
    val buyInfoShares: ExternalYahooQuoteSummaryEnterpriseValue?,
    val buyPercentInsiderShares: ExternalYahooQuoteSummaryTheWeekChange?,
    val sellInfoCount: ExternalYahooQuoteSummaryEnterpriseValue?,
    val sellInfoShares: ExternalYahooQuoteSummaryEnterpriseValue?,
    val sellPercentInsiderShares: ExternalYahooQuoteSummaryTheWeekChange?,
    val netInfoCount: ExternalYahooQuoteSummaryEnterpriseValue?,
    val netInfoShares: ExternalYahooQuoteSummaryEnterpriseValue?,
    val netPercentInsiderShares: ExternalYahooQuoteSummaryTheWeekChange?,
    val totalInsiderShares: ExternalYahooQuoteSummaryEnterpriseValue?
)

data class ExternalYahooQuoteSummaryRecommendationTrend (
    val trend: List<ExternalYahooQuoteSummaryRecommendationTrendTrend>?,
    val maxAge: Long?
)

data class ExternalYahooQuoteSummaryRecommendationTrendTrend (
    val period: String?,
    val strongBuy: Long?,
    val buy: Long?,
    val hold: Long?,
    val sell: Long?,
    val strongSell: Long?
)

data class ExternalYahooQuoteSummaryUpgradeDowngradeHistory (
    val history: List<ExternalYahooQuoteSummaryUpgradeDowngradeHistoryHistory>?,
    val maxAge: Long?
)

data class ExternalYahooQuoteSummaryUpgradeDowngradeHistoryHistory (
    val epochGradeDate: Long?,
    val firm: String?,
    val toGrade: String?,
    val fromGrade: String?,
    val action: String?
)