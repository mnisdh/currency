package com.mnisdh.common.exception

import com.mnisdh.common.rest.ResponseCode
import org.springframework.http.HttpStatus

open class BaseException(
    val code: ResponseCode,
    message: String,
    val status: HttpStatus = code.getStatus()
): RuntimeException(message)