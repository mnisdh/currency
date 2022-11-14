package com.mnisdh.currency.service.external.enums

import com.mnisdh.common.enums.BaseEnum

enum class YahooIncludeType(
    private val code:String,
    private val label:String,
    private val description:String = label
): BaseEnum {

    REVENUE("revenue", "revenue"),
    GROSS_MARGIN("grossMargin", "grossMargin"),
    DEBT_TO_EQUITY("debtToEquity", "debtToEquity"),
    CURRENT_RATIO("currentRatio", "currentRatio");

    companion object {
        fun toString(includeTypes: Set<YahooIncludeType>): String {
            return includeTypes.joinToString(",") { it.code }
        }
    }

    override fun getLabel() = this.label
    override fun getDescription() = this.description
    fun getCode() = this.code

}