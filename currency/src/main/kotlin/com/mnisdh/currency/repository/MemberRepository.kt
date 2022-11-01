package com.mnisdh.currency.repository

import com.mnisdh.currency.entity.Member
import org.springframework.data.jpa.repository.JpaRepository

interface MemberRepository : JpaRepository<Member, Long> {

    fun findByUsername(username: String): Member?

}