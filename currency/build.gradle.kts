plugins {
    id("org.springframework.boot") version "2.7.5"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
    kotlin("jvm") version "1.6.21"
    kotlin("plugin.spring") version "1.6.21"
    kotlin("plugin.jpa") version "1.6.21"
    kotlin("kapt") version "1.7.21"
}

dependencies {
    implementation(project(":common"))

    implementation("org.springframework.boot:spring-boot-starter-security:2.7.5")

    // https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt
    implementation("io.jsonwebtoken:jjwt:0.9.1")

    implementation("org.jsoup:jsoup:1.15.3")

    kapt("com.querydsl:querydsl-apt:5.0.0:jpa")
    kapt("org.springframework.boot:spring-boot-configuration-processor")

    runtimeOnly("com.h2database:h2:2.1.214")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.4")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    testImplementation("org.springframework.boot:spring-boot-starter-test:2.7.5")
    testImplementation("org.springframework.security:spring-security-test:5.7.3")
}

allOpen {
    annotation("com.mnisdh.common.jpa.AllOpen")
}

configurations.forEach {
    it.exclude(group = "org.springframework.boot", module = "spring-boot-starter-logging")
    it.exclude(group = "org.apache.logging.log4j", module = "log4j-to-slf4j")
}