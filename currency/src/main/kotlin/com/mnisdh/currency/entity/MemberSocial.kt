package com.mnisdh.currency.entity

import com.mnisdh.common.jpa.BaseEntity
import javax.persistence.*

@Entity
@Table
open class MemberSocial(
    name: String,
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null

    @Column(nullable = false)
    open var name: String = name
        protected set

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "member_id", foreignKey = ForeignKey(name = "fk_member_social_member"))
    open var member: Member? = null

    fun updateMember(member: Member?) {
        this.member = member
    }

}