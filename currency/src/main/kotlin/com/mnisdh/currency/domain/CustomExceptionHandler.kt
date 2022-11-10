package com.mnisdh.currency.domain

import com.mnisdh.common.exception.BaseException
import com.mnisdh.common.exception.BaseExceptionResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class CustomExceptionHandler {

    @ExceptionHandler(BaseException::class)
    fun commonExceptionHandler(e: BaseException) =
        ResponseEntity(
            BaseExceptionResponse(
                code = e.code.getCode(),
                message = e.message?: "알 수 없는 오류",
            ),
            e.status,
        )

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun methodArgumentNotValidExceptionHandler(e: MethodArgumentNotValidException) =
        BaseExceptionResponse(
            code = "INVALID_REQUEST",
            message = e.bindingResult.fieldError?.defaultMessage ?: "알 수 없는 에러",
        )

    @ExceptionHandler(HttpMessageNotReadableException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun httpMessageNotReadableExceptionHandler(e: HttpMessageNotReadableException) =
        BaseExceptionResponse(
            code = "INVALID_JSON",
            message = "JSON 형식이 잘못되었습니다.",
        )

}