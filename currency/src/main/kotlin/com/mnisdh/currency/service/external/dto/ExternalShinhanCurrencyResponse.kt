package com.mnisdh.currency.service.external.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ExternalShinhanCurrencyResponse(
    @JsonProperty(value = "R_RIBF3720_1")
    val result: List<ExternalShinhanCurrencyResultDto> = ArrayList()
)

data class ExternalShinhanCurrencyResultDto(
    @JsonProperty(value = "지폐매도환율")
    val moneySellingRate: Float?,
    @JsonProperty(value = "고시시각_display")
    val noticeTimeDisplay: String,
    @JsonProperty(value = "대미환산환율_display")
    val a1: Float?,
    @JsonProperty(value = "매매기준환율_display")
    val a2: Float?,
    @JsonProperty(value = "전신환매입환율")
    val ttBuyingRate: Float?,
    @JsonProperty(value = "대미환산환율")
    val a3: Float?,
    @JsonProperty(value = "지폐매입환율")
    val moneyBuyingRate: Float?,
    @JsonProperty(value = "전신환매도환율_display")
    val ttSellingRateDisplay: Float?,
    @JsonProperty(value = "전신환매입환율_display")
    val ttBuyingRateDisplay: Float?,
    @JsonProperty(value = "매매기준환율")
    val a4: Float?,
    @JsonProperty(value = "지폐매도환율_display")
    val moneySellingRateDisplay: Float?,
    @JsonProperty(value = "고시시각")
    val noticeTime: String?,
    @JsonProperty(value = "전신환매도환율")
    val ttSellingRate: Float?,
    @JsonProperty(value = "고시회차")
    val noticeSequence: Int?,
    @JsonProperty(value = "지폐매입환율_display")
    val moneyBuyingRateDisplay: Float?
)