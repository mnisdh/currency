package com.mnisdh.common.rest

import com.mnisdh.common.enums.BaseEnum
import org.springframework.http.HttpStatus

enum class ResponseCode(
    private val label: String? = null,
    private val message: String? = null,
    private val status: HttpStatus
): BaseEnum {

    UNKNOWN("알수없음", null, HttpStatus.CONFLICT),
    OK("성공", null, HttpStatus.OK),
    NOT_FOUND(null, null, HttpStatus.NOT_FOUND),
    ALREADY_EXISTS(null, null, HttpStatus.CONFLICT),
    DUPLICATED(null, null, HttpStatus.CONFLICT),
    INVALID(null, null, HttpStatus.CONFLICT);

    override fun getLabel() = this.label ?: this.status.reasonPhrase
    override fun getDescription() = this.message ?: ""
    fun getCode() = this.name
    fun getMessage() = this.message ?: ""
    fun getStatus() = this.status

}