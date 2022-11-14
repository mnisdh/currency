package com.mnisdh.currency.service.external.enums

import com.mnisdh.common.enums.BaseEnum

enum class YahooModuleType(
    private val label: String,
    private val code: String,
    private val description: String
): BaseEnum {

    ASSET_PROFILE("ASSET_PROFILE", "assetProfile", "assetProfile 객체는 산업, fullTimeEmployees 및 웹사이트와 같은 회사에 대한 일반 정보를 포함하며 회사 자산의 개요를 얻는 데 유용합니다."),
    DEFAULT_KEY_STATISTICS("DEFAULT_KEY_STATISTICS", "defaultKeyStatistics", "defaultKeyStatistics 개체는 회사의 주식에 대한 정보를 포함합니다. 이것은 회사의 주식에 대한 아이디어를 얻는 데 유용합니다."),
    RECOMMENDATION_TREND("RECOMMENDATION_TREND", "recommendationTrend", "RecommendationTrend 개체는 분석가 권장 사항에 대한 정보를 포함합니다. 이는 분석가가 주식을 사고파는지 여부를 파악하는 데 유용합니다."),
    FINANCIAL_DATA("FINANCIAL_DATA", "financialData", "FinancialData 객체는 회사의 재무 상황에 대한 정보를 포함합니다. 이것은 회사의 재정 상황에 대한 아이디어를 얻는 데 유용합니다."),
    MAJOR_HOLDERS_BREAKDOWN("MAJOR_HOLDERS_BREAKDOWN", "majorHoldersBreakdown", "majorHoldersBreakdown 개체는 주식의 최고 보유자에 대한 정보를 포함합니다. 이것은 누가 주식을 사거나 파는지 파악하는 데 유용합니다."),
    EARNINGS("EARNINGS", "earnings", "수익 개체는 회사의 수익에 대한 정보를 포함합니다. 이것은 회사의 수익성에 대한 아이디어를 얻는 데 유용합니다."),
    EARNINGS_HISTORY("EARNINGS_HISTORY", "earningsHistory", "incomeHistory 개체는 회사의 수입 내역에 대한 정보를 포함합니다. 이것은 회사의 과거 수익성에 대한 아이디어를 얻는 데 유용합니다."),
    EARNINGS_TREND("EARNINGS_TREND", "earningsTrend", "incomeTrend 개체는 회사의 수익 추세에 대한 정보를 포함합니다. 이것은 회사의 현재 및 미래 수익성에 대한 아이디어를 얻는 데 유용합니다."),
    INDEX_TREND("INDEX_TREND", "indexTrend", "indexTrend 개체는 주식 시장 지수의 방향에 대한 정보를 포함합니다. 이는 시장의 전반적인 방향에 대한 아이디어를 얻는 데 유용합니다."),
    INDUSTRY_TREND("INDUSTRY_TREND", "industryTrend", "industryTrend 개체는 산업의 방향에 대한 정보를 포함합니다. 이것은 산업의 전반적인 방향에 대한 아이디어를 얻는 데 유용합니다."),
    NET_SHARE_PURCHASE_ACTIVITY("NET_SHARE_PURCHASE_ACTIVITY", "netSharePurchaseActivity", "netSharePurchaseActivity 개체는 회사의 순 주식 구매 활동에 대한 정보를 포함합니다. 이것은 회사 주식의 전반적인 방향에 대한 아이디어를 얻는 데 유용합니다."),
    SECTOR_TREND("SECTOR_TREND", "sectorTrend", "ectorTrend 객체는 주식 시장 섹터의 방향에 대한 정보를 포함합니다. 이것은 특정 주식 시장 부문의 전반적인 방향에 대한 아이디어를 얻는 데 유용합니다."),
    INSIDER_HOLDERS("INSIDER_HOLDERS", "insiderHolders", "insiderHolders 개체는 회사 주식의 내부 보유자에 대한 정보를 포함합니다. 이것은 누가 회사의 주식을 소유하고 있는지에 대한 아이디어를 얻는 데 유용합니다."),
    UPGRADE_DOWNGRADE_HISTORY("UPGRADE_DOWNGRADE_HISTORY", "upgradeDowngradeHistory", "upgradeDowngradeHistory 개체는 분석가가 회사 주식에 제공한 업그레이드 및 다운그레이드에 대한 정보를 포함합니다. 이것은 회사의 주식에 대한 분석가의 의견에 대한 아이디어를 얻는 데 유용합니다.");

    companion object {
        fun toString(moduletypes: Set<YahooModuleType>): String {
            return moduletypes.joinToString(",") { it.code }
        }
    }

    override fun getLabel() = this.label
    override fun getDescription() = this.description
    fun getCode() = this.code

}