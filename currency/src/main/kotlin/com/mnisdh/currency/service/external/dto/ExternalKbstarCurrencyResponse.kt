package com.mnisdh.currency.service.external.dto

data class ExternalKbstarCurrencyResponse(
    val minOfDay: Float? = null, //일최저
    val maxOfDay: Float? = null, //일최고
    val minMaxGapOfDay: Float? = null, //일최고-일최저
    val averageOfDay: Float? = null, //일평균
    val firstRate: Float? = null, //최초회차
    val latestRate: Float? = null, //최종회차
    val buyingSpreadRate: Float? = null, //사실때(스프레드율)
    val sellingSpreadRate: Float? = null //파실때(스프레드율)
)