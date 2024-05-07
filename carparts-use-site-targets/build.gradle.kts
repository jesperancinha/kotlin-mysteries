plugins {
    alias(libs.plugins.kotlin.jvm)
}

group = "org.jesperancinha.talks.carparts"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}