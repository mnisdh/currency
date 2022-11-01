package com.mnisdh.currency.service

import com.mnisdh.currency.domain.member.ReqSignin
import com.mnisdh.currency.jwt.JwtUtils
import com.mnisdh.currency.repository.MemberRepository
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MemberService(
    private val repository: MemberRepository,
    private val passwordEncoder: PasswordEncoder,
    private val authenticationManager: AuthenticationManager,
    private val jwtUtils: JwtUtils,
) {

    @Transactional(readOnly = true)
    fun signin(reqSignin: ReqSignin): String {
        try {
            // 인증시도
            authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(reqSignin.username, reqSignin.password, null)
            )
        } catch (e: BadCredentialsException) {
            throw BadCredentialsException("로그인 실패")
        }
        // 예외가 발생하지 않았다면 인증에 성공한 것.
        // 토큰 생성
        val token = jwtUtils.createToken(reqSignin.username)

        return token
    }

}