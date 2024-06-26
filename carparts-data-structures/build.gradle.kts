plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
    alias(libs.plugins.flyway)
}

group = "org.jesperancinha.talks.carparts"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    api(libs.springdoc.openapi.starter.mvc)
    implementation("org.flywaydb:flyway-core")
    implementation(libs.jackson.datatype.jsr310)
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly(libs.flyway.database.postgresql)
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(libs.kotest.assertions)
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}