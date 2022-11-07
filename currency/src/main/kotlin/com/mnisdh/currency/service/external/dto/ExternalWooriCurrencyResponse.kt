package com.mnisdh.currency.service.external.dto

import com.mnisdh.currency.enum.CurrencyType

data class ExternalWooriCurrencyResponse(
    val currencyType: CurrencyType, //통화표시
    val currencyName: String? = null, //통화명
    val remittance: Float? = null, //송금
    val cash: Float? = null, //현찰
    val salesStandardRate: Float? = null, //매매기준율
    val baseExchangeRate: Float? = null, //기준환율
    val usConversionRate: Float? = null, //대미환산율
    val send: Float? = null, //보내실때
    val receive: Float? = null, //받으실때
    val buyingSpreadRate: Float? = null, //사실때(스프레드율)
    val sellingSpreadRate: Float? = null //파실때(스프레드율)
)