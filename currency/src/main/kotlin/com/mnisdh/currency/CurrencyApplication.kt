package com.mnisdh.currency

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@EnableJpaAuditing
@SpringBootApplication(scanBasePackages = ["com.mnisdh.utils"])
class CurrencyApplication

fun main(args: Array<String>) {
    runApplication<CurrencyApplication>(*args)
}
