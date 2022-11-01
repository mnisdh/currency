package com.mnisdh.currency.jwt

import com.mnisdh.currency.entity.Member
import com.mnisdh.currency.repository.MemberRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(
    private val memberRepository: MemberRepository,
): UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val member: Member = memberRepository.findByUsername(username)?: throw UsernameNotFoundException("찾을 수 없습니다.")

        return UserDetailsImpl(member)
    }

}