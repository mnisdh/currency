package com.mnisdh.currency.enum

enum class CurrencyType {
    USD {
        override fun getName(institutionType: InstitutionType): String {
            return when(institutionType) {
                InstitutionType.YAHOO -> "USD"
                InstitutionType.KB -> "USD"
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
                InstitutionType.KB -> "KRW"
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
                InstitutionType.KB -> "JPY"
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
                InstitutionType.YAHOO -> "%s%s=X".format(from.getName(institutionType), from.getName(institutionType))
                else -> "%s%s".format(from.getName(institutionType), from.getName(institutionType))
            }
        }
    }

}