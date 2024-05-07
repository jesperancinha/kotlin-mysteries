plugins {
    alias(libs.plugins.kotlin.jvm)
    java
}

group = "org.jesperancinha.talks.carparts"
version = "0.0.0"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(17)
}
