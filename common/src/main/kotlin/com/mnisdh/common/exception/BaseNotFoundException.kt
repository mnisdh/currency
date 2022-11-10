package com.mnisdh.common.exception

import com.mnisdh.common.rest.ResponseCode
import org.springframework.http.HttpStatus

class BaseNotFoundException(
    code: ResponseCode,
    message: String,
    status: HttpStatus = code.getStatus()
): BaseException(code, message, status) {

    companion object {
        val CODE: ResponseCode = ResponseCode.NOT_FOUND
    }

    constructor() : this(CODE, "")
    constructor(message: String) : this(CODE, message)

}