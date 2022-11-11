package com.mnisdh.currency.service.external.dto

import com.fasterxml.jackson.annotation.JsonProperty
import com.mnisdh.currency.enums.CurrencyType
import com.mnisdh.currency.enums.InstitutionType
import com.mnisdh.common.util.DateUtil
import java.time.LocalDate

data class ExternalShinhanCurrencyRequest(
    val root_info: ExternalShinhanCurrencyRootInfoDto? = null,
    val S_RIBF3720: ExternalShinhanCurrencySRIBF3720Dto? = null,
) {
    companion object {
        fun of(targetDate: LocalDate, currencyType: CurrencyType): ExternalShinhanCurrencyRequest {
            return ExternalShinhanCurrencyRequest(
                ExternalShinhanCurrencyRootInfoDto(),
                ExternalShinhanCurrencySRIBF3720Dto(
                    searchDate = DateUtil.format(targetDate, "yyyyMMdd"),
                    currencyName = currencyType.getName(InstitutionType.SHINHAN),
                    searchDateDisplay = DateUtil.format(targetDate, "yyyy-MM-dd")
                ))
        }
    }
}

data class ExternalShinhanCurrencyRootInfoDto(
    val serviceType: String = "GU",
    val serviceCode: String = "F3720",
    val nextServiceCode: String = "",
    val pkcs7Data: String = "",
    val signCode: String = "",
    val signData: String = "",
    val useSign: String = "",
    val useCert: String = "",
    val permitMultiTransaction: String = "",
    val keepTransactionSession: String = "",
    val skipErrorMsg: String = "",
    val mode: String = "",
    val language: String = "ko",
    val exe2e: String = "",
    val hideProcess: String = "",
    val clearTarget: String = "data:json,[{\\id\\:\\dm_R_RIBF3720\\,\\key\\:\\R_RIBF3720\\},{\\id\\:\\dl_R_RIBF3720_1\\,\\key\\:\\R_RIBF3720_1\\}]",
    val callBack: String = "shbObj.fncF3720Callback",
    val exceptionCallback: String = "",
    val requestMessage: String = "",
    val responseMessage: String = "",
    val serviceOption: String = "",
    val pcLog: String = "",
    val preInqForMulti: String = "",
    val makesum: String = "",
    val removeIndex: String = "",
    val redirectUrl: String = "",
    val preInqKey: String = "",
    val _multi_transfer_: String = "",
    val _multi_transfer_count_: String = "",
    val _multi_transfer_amt_: String = "",
    val userCallback: String = "",
    val menuCode: String = "",
    val certtype: String = ""
)

data class ExternalShinhanCurrencySRIBF3720Dto(
    @JsonProperty(value = "조회구분")
    val searchGubun: String = "",
    @JsonProperty(value = "조회일자")
    val searchDate: String = "20221028",
    @JsonProperty(value = "통화코드")
    val currencyName: String = "JPY",
    @JsonProperty(value = "고시구분")
    val gubun: String = "",
    @JsonProperty(value = "조회일자_display")
    val searchDateDisplay: String = "2022-10-28"
)