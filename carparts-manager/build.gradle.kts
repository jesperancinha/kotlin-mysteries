import org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_21

plugins {
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependency.management)
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.kotlin.spring)
    alias(libs.plugins.kotlin.jpa)
    alias(libs.plugins.flyway)
}

group = "org.jesperancinha.talks.carparts"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:3.0.0")
    implementation("org.flywaydb:flyway-core")
    runtimeOnly("org.postgresql:postgresql")
    runtimeOnly("org.flywaydb:flyway-database-postgresql")
    testImplementation(libs.kotest.assertions)
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:postgresql")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.add("-Xjsr305=strict")
        jvmTarget.set(JVM_21)
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

//For Intellij
tasks.register("prepareKotlinBuildScriptModel"){}

