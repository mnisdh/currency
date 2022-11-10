package com.mnisdh.currency.service.external.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.service.dto.CurrencyDto
import java.time.LocalDate

data class ExternalShinhanCurrencyResponse(
    @JsonProperty(value = "R_RIBF3720_1")
    val result: List<ExternalShinhanCurrencyResultDto> = ArrayList()
): BaseExternalCurrency {

    override fun to(exchangeDate: LocalDate, baseCurrencyType: CurrencyType, exchangeCurrencyType: CurrencyType): CurrencyDto {
        return CurrencyDto.of(this.getLatest(), exchangeDate, baseCurrencyType, exchangeCurrencyType)
    }

    fun getLatest(): ExternalShinhanCurrencyResultDto {
        return result.last()
    }

}

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
    val exchangeRate: Float?,
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