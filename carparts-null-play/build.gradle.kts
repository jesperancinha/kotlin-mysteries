plugins {
    alias(libs.plugins.kotlin.jvm)
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

/**
 * Not necessary in all cases
 */
tasks.register("prepareKotlinBuildScriptModel"){}

kotlin {
    jvmToolchain(21)
}