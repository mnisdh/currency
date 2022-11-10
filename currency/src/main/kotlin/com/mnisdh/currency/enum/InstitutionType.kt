package com.mnisdh.currency.enum

import com.mnisdh.common.enums.BaseEnum

enum class InstitutionType(
    private val label: String,
    private val description: String = label
): BaseEnum {

    NONE("없음"),
    YAHOO("야후"),
    KBSTAR("국민은행"),
    WOORI("우리은행"),
    SHINHAN("신한은행");

    override fun getLabel() = this.label
    override fun getDescription() = this.description

    companion object {
        fun allows(): List<InstitutionType> {
            return values().filter { it != NONE }.toList()
        }
        fun allowsByKorea(): List<InstitutionType> {
            return values().filter { it != NONE && it != YAHOO }.toList()
        }
    }

    fun symbol(from: CurrencyType, to: CurrencyType): String {
        return when(this) {
            YAHOO -> "%s%s=X".format(from.getName(this), to.getName(this))
            else -> "%s%s".format(from.getName(this), to.getName(this))
        }
    }

}