package com.mnisdh.currency.service.external.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ExternalYahooQuoteResponse(

    @JsonProperty("result")
    val items: List<ExternalYahooQuoteItemResponse>?,
    val error: Any? = null

)
