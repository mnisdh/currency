package com.mnisdh.currency.enum

enum class CurrencyType {
    USD {
        override fun getName(institutionType: InstitutionType): String {
            return when(institutionType) {
                InstitutionType.YAHOO -> "USD"
                InstitutionType.KBSTAR -> "USD"
                InstitutionType.WOORI -> "USD"
                InstitutionType.SHINHAN -> "USD"
                else -> "USD"
            }
        }
    },
    KRW{
        override fun getName(institutionType: InstitutionType): String {
            return when(institutionType) {
                InstitutionType.YAHOO -> "KRW"
                InstitutionType.KBSTAR -> "KRW"
                InstitutionType.WOORI -> "KRW"
                InstitutionType.SHINHAN -> "KRW"
                else -> "KRW"
            }
        }
    },
    JPY{
        override fun getName(institutionType: InstitutionType): String {
            return when(institutionType) {
                InstitutionType.YAHOO -> "JPY"
                InstitutionType.KBSTAR -> "JPY"
                InstitutionType.WOORI -> "JPY"
                InstitutionType.SHINHAN -> "JPY"
                else -> "JPY"
            }
        }
    };

    abstract fun getName(institutionType: InstitutionType): String

    companion object {
        fun symbol(from: CurrencyType, to: CurrencyType, institutionType: InstitutionType): String {
            return when(institutionType) {
                InstitutionType.YAHOO -> "%s%s=X".format(from.getName(institutionType), to.getName(institutionType))
                else -> "%s%s".format(from.getName(institutionType), to.getName(institutionType))
            }
        }
    }

}