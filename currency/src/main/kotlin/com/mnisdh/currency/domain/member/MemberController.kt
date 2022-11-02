package com.mnisdh.currency.domain.member

import com.mnisdh.currency.service.MemberService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/members")
class MemberController(
    private val service: MemberService,
) {

    @PostMapping("/signin")
    fun signin(@RequestBody reqSignin: ReqSignin)= ResponseEntity.ok().body(service.signin(reqSignin))

    @GetMapping
    fun test()= ResponseEntity.ok().body("123")

}