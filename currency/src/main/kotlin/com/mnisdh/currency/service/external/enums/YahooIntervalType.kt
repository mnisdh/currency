package com.mnisdh.currency.service.external.enums

import com.mnisdh.common.enums.BaseEnum

enum class YahooIntervalType(
    private val code: String,
    private val label: String,
    private val description: String = label
): BaseEnum {

    M1("1m", "1분"),
    M2("2m", "2분"),
    M5("5m", "5분"),
    M15("15m", "15분"),
    M30("30m", "30분"),
    M60("60m", "60분"),
    M90("90m", "90분"),
    H1("1h", "1시간"),
    D1("1d", "1일"),
    D5("5d", "5일"),
    WEEK1("1wk", "1주일"),
    MONTH1("1mo", "1개월"),
    MONTH3("3mo", "3개월");

    override fun getLabel() = this.label
    override fun getDescription() = this.description
    fun getCode() = this.code

}