package com.mnisdh.currency.entity

import com.mnisdh.common.jpa.BaseEntity
import javax.persistence.*

@Entity
@Table
open class Member(
    name: String,
    password: String,
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null

    @Column(nullable = false)
    var username: String = name
        protected set

    @Column(nullable = false)
    var password: String = password
        protected set

    @OneToMany(mappedBy = "member")
    val socials: MutableList<MemberSocial> = ArrayList()

    fun addSocial(social: MemberSocial) {
        this.socials.add(social)
        social.updateMember(this)
    }

    fun removeSocial(social: MemberSocial) {
        this.socials.remove(social);
        social.updateMember(null)
    }

}