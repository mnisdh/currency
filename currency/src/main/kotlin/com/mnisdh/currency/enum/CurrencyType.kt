package com.mnisdh.currency.enum

import com.mnisdh.common.enums.BaseEnum

enum class CurrencyType(
    private val label: String,
    private val description: String = label
): BaseEnum {
    NONE("없음"),
    USD("달러"),
    KRW("원화"),
    JPY("엔화");

    override fun getLabel() = this.label
    override fun getDescription() = this.description

    companion object {
        fun allows(): List<CurrencyType> {
            return values().filter { it != NONE }.toList()
        }
        fun allowsByExcept(excepts: Set<CurrencyType>): List<CurrencyType> {
            return values().filter { it != NONE && !excepts.contains(it) }.toList()
        }
    }

    fun getName(institutionType: InstitutionType): String {
        return this.name
    }

}