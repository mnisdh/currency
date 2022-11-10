package com.mnisdh.currency.entity

import com.mnisdh.common.jpa.BaseEntity
import com.mnisdh.currency.enum.CurrencyType
import com.mnisdh.currency.enum.InstitutionType
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table
open class Currency(
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    open val institutionType: InstitutionType = InstitutionType.NONE,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    open val baseCurrencyType: CurrencyType = CurrencyType.NONE,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    open val exchangeCurrencyType: CurrencyType = CurrencyType.NONE,

    @Column(nullable = false)
    open val exchangeDate: LocalDate = LocalDate.MIN,

    @Column(nullable = false)
    open val exchangeRate: Float = Float.MIN_VALUE,

    @Column
    open var buyingSpreadRate: Float? = null,

    @Column
    open var sellingSpreadRate: Float? = null
): BaseEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    val id: Long? = null

    companion object {
        fun create(institutionType: InstitutionType,
        baseCurrencyType: CurrencyType,
        exchangeCurrencyType: CurrencyType,
        exchangeDate: LocalDate,
        exchangeRate: Float,
        buyingSpreadRate: Float? = null,
        sellingSpreadRate: Float? = null): Currency = Currency(
            institutionType, baseCurrencyType, exchangeCurrencyType, exchangeDate, exchangeRate, buyingSpreadRate, sellingSpreadRate
        )
    }

}