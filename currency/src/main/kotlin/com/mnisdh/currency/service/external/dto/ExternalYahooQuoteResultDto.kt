package com.mnisdh.currency.service.external.dto

import com.fasterxml.jackson.annotation.JsonProperty

data class ExternalYahooQuoteResultDto(

    @JsonProperty("result")
    val items: List<ExternalYahooQuoteItemDto>?

)
