package com.mnisdh.currency.service.external.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.mnisdh.common.util.StringUtil
import com.mnisdh.currency.enums.CurrencyType
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
    val moneySellingRate: String?,
    @JsonProperty(value = "고시시각_display")
    val noticeTimeDisplay: String,
    @JsonProperty(value = "대미환산환율_display")
    val a1: String?,
    @JsonProperty(value = "매매기준환율_display")
    val a2: String?,
    @JsonProperty(value = "전신환매입환율")
    val ttBuyingRate: String?,
    @JsonProperty(value = "대미환산환율")
    val a3: String?,
    @JsonProperty(value = "지폐매입환율")
    val moneyBuyingRate: String?,
    @JsonProperty(value = "전신환매도환율_display")
    val ttSellingRateDisplay: String?,
    @JsonProperty(value = "전신환매입환율_display")
    val ttBuyingRateDisplay: String?,
    @JsonProperty(value = "매매기준환율")
    val exchangeRate: String?,
    @JsonProperty(value = "지폐매도환율_display")
    val moneySellingRateDisplay: String?,
    @JsonProperty(value = "고시시각")
    val noticeTime: String?,
    @JsonProperty(value = "전신환매도환율")
    val ttSellingRate: String?,
    @JsonProperty(value = "고시회차")
    val noticeSequence: Int?,
    @JsonProperty(value = "지폐매입환율_display")
    val moneyBuyingRateDisplay: String?
) {
    fun getExchangeRate(): Float? {
        return if(this.exchangeRate != null) StringUtil.getFloat(this.exchangeRate)
        else null
    }

    fun getTtSellingRate(): Float? {
        return if(this.ttSellingRate != null) StringUtil.getFloat(this.ttSellingRate)
        else null
    }

    fun getTtBuyingRate(): Float? {
        return if(this.ttBuyingRate != null) StringUtil.getFloat(this.ttBuyingRate)
        else null
    }
}