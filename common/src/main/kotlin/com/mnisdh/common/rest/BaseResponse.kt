package com.mnisdh.common.rest

open class BaseResponse(
    var code: ResponseCode,
    var subCode: String? = null,
    var message: String = code.getMessage()
) {
    companion object {
        fun of(code: ResponseCode): BaseResponse {
            return BaseResponse(code = code)
        }
        fun of(code: ResponseCode, subCode: String): BaseResponse {
            return BaseResponse(code = code, subCode = subCode)
        }
        fun of(code: ResponseCode, subCode: String, message: String): BaseResponse {
            return BaseResponse(code = code, subCode = subCode, message = message)
        }
    }
}
