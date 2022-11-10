package com.mnisdh.currency.service.external.dto

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.enum.InstitutionType
import com.mnisdh.common.util.DateUtil
import java.time.LocalDate

data class ExternalWooriCurrencyRequest(
    val BAS_DT: String?,
    val NTC_DIS: String = ExternalWooriCurrencyRequest.NTC_DIS,
    val INQ_DIS: String?,
    val SELECT_DATE: String?,
    val SELECT_DATEY: String?,
    val SELECT_DATEM: String?,
    val SELECT_DATED: String?
) {

    companion object {
        private const val NTC_DIS: String = "A"

        fun of(targetDate: LocalDate, targetCurrencyType: CurrencyType): ExternalWooriCurrencyRequest {
            val basDt = DateUtil.format(targetDate, "yyyyMMdd")
            val ntcDis = NTC_DIS
            val inqDis = targetCurrencyType.getName(InstitutionType.WOORI)
            val selectDate = DateUtil.format(targetDate, "yyyy.MM.dd")
            val selectDatey = DateUtil.format(targetDate, "yyyy")
            val selectDatem = DateUtil.format(targetDate, "MM")
            val selectDated = DateUtil.format(targetDate, "dd")

            return ExternalWooriCurrencyRequest(basDt, ntcDis, inqDis, selectDate, selectDatey, selectDatem, selectDated)
        }
    }

    override fun toString(): String {
        return "BAS_DT=%s&NTC_DIS=%s&INQ_DIS=%s&SELECT_DATE=%s&SELECT_DATEY=%s&SELECT_DATEM=%s&SELECT_DATED=%s"
            .format(this.BAS_DT, this.NTC_DIS, this.INQ_DIS, this.SELECT_DATE, this.SELECT_DATEY, this.SELECT_DATEM, this.SELECT_DATED)
    }

}
