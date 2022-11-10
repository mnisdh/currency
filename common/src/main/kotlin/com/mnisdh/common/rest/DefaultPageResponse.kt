package com.mnisdh.common.rest

import org.springframework.data.domain.Page

open class DefaultPageResponse<T>(
    code: ResponseCode,
    subCode: String? = null,
    message: String = code.getMessage(),
    var data: List<T>? = null
): BaseResponse(code, subCode, message) {

    private val totalElements: Long = 0
    // 총 페이지 수
    private val totalPages: Long = 0
    // 현재 페이지 번호
    private val pageNumber: Long = 0
    //현재 페이지 데이터 수
    private val size: Long = 0
    // 첫 페이지 여부
    private val first: Boolean = false
    // 마지막 페이지 여부
    private val last: Boolean = false

    constructor(page: Page<T>, code: ResponseCode) : this(code = code) {
        this.data = page.content
    }

}