plugins {
    kotlin("jvm") version "1.9.23"
    java
}

group = "org.jesperancinha.talks.carparts"
version = "unspecified"

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
