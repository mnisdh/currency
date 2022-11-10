package com.mnisdh.currency.service.external

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.service.external.dto.ExternalShinhanCurrencyRequest
import com.mnisdh.currency.service.external.dto.ExternalShinhanCurrencyResponse
import com.mnisdh.currency.service.external.dto.ExternalShinhanCurrencyResultDto
import org.springframework.http.HttpRequest
import org.springframework.http.MediaType
import org.springframework.http.client.ClientHttpRequestExecution
import org.springframework.http.client.ClientHttpRequestInterceptor
import org.springframework.http.client.ClientHttpResponse
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.LocalDate

@Service
class ExternalShinhanFinanceService(
    private val restTemplate: RestTemplate
) {
    private val currencyUrl: String = "https://bank.shinhan.com/comjsp/dataProcess.jsp"

    fun getCurrency(currencyType: CurrencyType, exchangeDate: LocalDate): ExternalShinhanCurrencyResponse? {
        val url = "%s?svr_type=GU&svr_code=F3720".format(currencyUrl)
        val request = ExternalShinhanCurrencyRequest.of(exchangeDate, currencyType)

        restTemplate.interceptors.add(ClientHttpRequestInterceptor { request: HttpRequest?, body: ByteArray?, execution: ClientHttpRequestExecution ->
            val response: ClientHttpResponse = execution.execute(
                request!!, body!!
            )
            response.headers.contentType = MediaType.APPLICATION_JSON
            response
        })

        val result = restTemplate.postForEntity(url, request, ExternalShinhanCurrencyResponse::class.java)

        return result.body
    }

}