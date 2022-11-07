package com.mnisdh.currency.service.external

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.service.external.dto.ExternalShinhanCurrencyRequest
import com.mnisdh.currency.service.external.dto.ExternalShinhanCurrencyResponse
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.LocalDate

@Service
class ExternalShinhanFinanceService(
    private val restTemplate: RestTemplate
) {
    private val currencyUrl: String = "https://bank.shinhan.com/comjsp/dataProcess.jsp"

    fun getCurrency(targetDate: LocalDate, currencyType: CurrencyType): ExternalShinhanCurrencyResponse? {
        val url = "%s?svr_type=GU&svr_code=F3720".format(currencyUrl)
        val request = ExternalShinhanCurrencyRequest.of(targetDate, currencyType)

        val result = restTemplate.postForEntity(url, request, ExternalShinhanCurrencyResponse::class.java)

        return result.body
    }

}