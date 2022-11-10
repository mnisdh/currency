package com.mnisdh.common.jpa

import com.querydsl.core.types.Expression
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.core.types.dsl.SimpleExpression
import com.querydsl.jpa.impl.JPAQueryFactory
import java.util.*

open class BaseQueryDslRepository(
    protected val jpaQueryFactory: JPAQueryFactory
) {
    protected open fun <T> eq(path: SimpleExpression<T>, right: Expression<in T>?): BooleanExpression? {
        return if (Objects.nonNull(right)) path.eq(right) else null
    }
}