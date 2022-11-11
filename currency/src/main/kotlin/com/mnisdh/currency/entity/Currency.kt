package com.mnisdh.currency.entity

import com.mnisdh.common.jpa.BaseEntity
import com.mnisdh.currency.enums.CurrencyType
import com.mnisdh.currency.enums.InstitutionType
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table
class Currency(
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val institutionType: InstitutionType = InstitutionType.NONE,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val baseCurrencyType: CurrencyType = CurrencyType.NONE,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val exchangeCurrencyType: CurrencyType = CurrencyType.NONE,

    @Column(nullable = false)
    val exchangeDate: LocalDate = LocalDate.MIN,

    @Column(nullable = false)
    val exchangeRate: Float = Float.MIN_VALUE,

    @Column
    var buyingSpreadRate: Float? = null,

    @Column
    var sellingSpreadRate: Float? = null
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
            institutionType = institutionType,
            baseCurrencyType = baseCurrencyType,
            exchangeCurrencyType = exchangeCurrencyType,
            exchangeDate = exchangeDate,
            exchangeRate = exchangeRate,
            buyingSpreadRate = buyingSpreadRate,
            sellingSpreadRate = sellingSpreadRate
        )
    }

}