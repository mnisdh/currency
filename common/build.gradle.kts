tasks.bootJar {enabled = false}
tasks.jar {enabled = true}

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("kapt") version "1.7.21"
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-web:2.7.5")
    api("org.springframework.boot:spring-boot-starter-data-jpa:2.7.5")
    api("org.jsoup:jsoup:1.15.3")

    api("org.springframework.boot:spring-boot-starter-log4j2:2.7.5")

    api("com.querydsl:querydsl-jpa:5.0.0")
    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")

    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("org.apache.httpcomponents:httpclient:4.5.13")

    implementation("net.sourceforge.tess4j:tess4j:5.4.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.5")
    testImplementation("org.springframework.security:spring-security-test:5.7.3")
}

configurations.forEach {
    it.exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    it.exclude(group = "org.apache.logging.log4j", module = "log4j-to-slf4j")
}