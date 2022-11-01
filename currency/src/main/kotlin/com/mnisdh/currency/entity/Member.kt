package com.mnisdh.currency.entity

import com.mnisdh.utils.entity.BaseEntity
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
    open val id: Long? = null

    @Column(nullable = false)
    open var username: String = name
        protected set

    @Column(nullable = false)
    open var password: String = password
        protected set

    @OneToMany(mappedBy = "member")
    open val socials: MutableList<MemberSocial> = ArrayList()

    fun addSocial(social: MemberSocial) {
        this.socials.add(social)
        social.updateMember(this)
    }

    fun removeSocial(social: MemberSocial) {
        this.socials.remove(social);
        social.updateMember(null)
    }

}