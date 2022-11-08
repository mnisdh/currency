package com.mnisdh.currency.service.external

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.service.external.dto.ExternalKbstarCurrencyRequest
import com.mnisdh.currency.service.external.dto.ExternalWooriCurrencyResponse
import com.mnisdh.utils.data.StringUtil
import org.jsoup.Jsoup
import org.jsoup.nodes.TextNode
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ExternalKbstarFinanceService {

    private val currencyUrl: String = "https://obank.kbstar.com/quics"

    fun getCurrency(targetDate: LocalDate, currencyType: CurrencyType): Any? {
        val request = ExternalKbstarCurrencyRequest.of(targetDate, currencyType)

        val doc = Jsoup.connect(currencyUrl)
            .data("chgCompId", "b103362", "baseCompId", "b103362", "page", "C101422", "cc", "b103362:b103362")
            .requestBody(request.toString())
            .header("Content-Type", "application/x-www-form-urlencoded")
            .post()

        val items = doc.select("tbody").select("tr")

        return items

//        val currencyName: String? = (items.get(1).childNode(0) as TextNode).text()
//        val remittance: Float? = StringUtil.getFloat((items.get(2).childNode(0) as TextNode).text())
//        val cash: Float? = StringUtil.getFloat((items.get(3).childNode(0) as TextNode).text())
//        val salesStandardRate: Float? = StringUtil.getFloat((items.get(4).childNode(0) as TextNode).text())
//        val baseExchangeRate: Float? = StringUtil.getFloat((items.get(5).childNode(0) as TextNode).text())
//        val usConversionRate: Float? = StringUtil.getFloat((items.get(6).childNode(0) as TextNode).text())
//        val send: Float? = StringUtil.getFloat((items.get(7).childNode(0) as TextNode).text())
//        val receive: Float? = StringUtil.getFloat((items.get(8).childNode(0) as TextNode).text())
//        val buyingSpreadRate: Float? = StringUtil.getFloat((items.get(9).childNode(0) as TextNode).text())
//        val sellingSpreadRate: Float? = StringUtil.getFloat((items.get(10).childNode(0) as TextNode).text())
//
//        return ExternalWooriCurrencyResponse(
//            currencyType = currencyType,
//            currencyName = currencyName,
//            remittance = remittance,
//            cash = cash,
//            salesStandardRate = salesStandardRate,
//            baseExchangeRate = baseExchangeRate,
//            usConversionRate = usConversionRate,
//            send = send,
//            receive = receive,
//            buyingSpreadRate = buyingSpreadRate,
//            sellingSpreadRate = sellingSpreadRate
//        )
    }

}