package com.mnisdh.currency.service.external.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ExternalYahooQuoteResponse(

    @JsonProperty("quoteResponse")
    val result: ExternalYahooQuoteResultDto?,
    val error: Any? = null

)
