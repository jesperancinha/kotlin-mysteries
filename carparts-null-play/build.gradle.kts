plugins {
    kotlin("jvm") version "1.9.23"
}

group = "org.jesperancinha.talks.carparts"
version = "1.0-SNAPSHOT"

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