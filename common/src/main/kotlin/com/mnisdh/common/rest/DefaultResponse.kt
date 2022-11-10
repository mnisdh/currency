package com.mnisdh.common.rest

open class DefaultResponse<T>(
    code: ResponseCode,
    subCode: String? = null,
    message: String = code.getMessage(),
    var data: T? = null
): BaseResponse(code, subCode, message) {

    constructor(data: T?): this(code = ResponseCode.OK, data = data)

}