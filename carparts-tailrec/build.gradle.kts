plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "org.jesperancinha.talks.carparts"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation(libs.kostest.assertions)
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}