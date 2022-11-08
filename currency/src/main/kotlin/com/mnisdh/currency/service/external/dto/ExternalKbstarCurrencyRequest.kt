package com.mnisdh.currency.service.external.dto

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.enum.InstitutionType
import com.mnisdh.utils.data.DateUtil
import java.time.LocalDate

data class ExternalKbstarCurrencyRequest(
    val docType: Int = 1,
    val monyCd: String = "JPY",
    val selDate: String = "20221028"
) {

    companion object {
        fun of(targetDate: LocalDate, targetCurrencyType: CurrencyType): ExternalKbstarCurrencyRequest {
            val monyCd = targetCurrencyType.getName(InstitutionType.KBSTAR)
            val selDate = DateUtil.format(targetDate, "yyyyMMdd")

            return ExternalKbstarCurrencyRequest(monyCd = monyCd, selDate = selDate)
        }
    }

    override fun toString(): String {
        return "DocType=%s&monyCd=%s&selDate=%s"
            .format(this.docType, this.monyCd, this.selDate)
    }

}
