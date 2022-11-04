tasks.bootJar {enabled = false}
tasks.jar {enabled = true}

plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
}

dependencies {
    api("org.springframework.boot:spring-boot-starter-web:2.7.5")
    api("org.springframework.boot:spring-boot-starter-data-jpa:2.7.5")
    api("org.jsoup:jsoup:1.15.3")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    implementation("net.sourceforge.tess4j:tess4j:5.4.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.5")
    testImplementation("org.springframework.security:spring-security-test:5.7.3")
}