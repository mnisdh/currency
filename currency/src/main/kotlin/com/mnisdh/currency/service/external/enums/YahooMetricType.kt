package com.mnisdh.currency.service.external.enums

import com.mnisdh.common.enums.BaseEnum

enum class YahooMetricType(
    private val code: String,
    private val label: String,
    private val description: String
): BaseEnum {

    DATE("Date", "날짜", "날짜 메트릭은 주가 날짜를 반환합니다. 이것은 DataFrame을 인덱싱하는 데 사용됩니다"),
    HIGH("High", "높음", "높은 메트릭은 해당 날짜의 가장 높은 주식 가격을 반환합니다. 이것은 백분율 변화를 계산하는 데 사용됩니다"),
    LOW("Low", "낮음", "낮은 메트릭은 해당 날짜의 가장 낮은 주식 가격을 반환합니다. 이것은 백분율 변화를 계산하는 데 사용됩니다"),
    OPEN("Open", "시가", "시가 메트릭은 해당 날짜의 주식 시가를 반환합니다. 이것은 백분율 변화를 계산하는 데 사용됩니다"),
    CLOSE("Close", "종가", "종가 메트릭은 해당 날짜의 주식 종가를 반환합니다. 이것은 백분율 변화를 계산하는 데 사용됩니다"),
    VOLUME("Volume", "거래량", "거래량 메트릭은 그날 거래된 주식 수를 반환합니다. 이는 일일 평균 거래량을 계산하는 데 사용됩니다"),
    ADJ_CLOSE("Adj Close", "종가 조정", "조정된 종가 메트릭은 분할 및 배당금에 대해 조정된 그날의 주식 종가를 반환합니다. 이것은 백분율 변화를 계산하는 데 사용됩니다"),
    CURRENCY("Currency", "통화", "통화 메트릭은 주가를 미국 달러로 반환합니다. 이것은 백분율 변화를 계산하는 데 사용됩니다"),
    INSTRUMENT_TYPE("InstrumentType", "InstrumentType", "instrumentType은 주식이 주식인지, 지수인지, 통화인지, 상품인지를 보여줍니다. 이것은 데이터를 필터링하는 데 사용됩니다");

    companion object {
        fun toString(metricTypes: Set<YahooMetricType>): String {
            return metricTypes.joinToString(",") { it.code }
        }
    }

    override fun getLabel() = this.label
    override fun getDescription() = this.description
    fun getCode() = this.code

}