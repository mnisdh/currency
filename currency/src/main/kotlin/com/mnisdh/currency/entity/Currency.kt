package com.mnisdh.currency.entity

import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.enum.InstitutionType
import com.mnisdh.utils.entity.BaseIdEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table
open class Currency: BaseIdEntity() {

    @Column(nullable = false)
    open var currencyType: CurrencyType = CurrencyType.USD
        protected set

    @Column(nullable = false)
    open var institutionType: InstitutionType = InstitutionType.YAHOO
        protected set



}