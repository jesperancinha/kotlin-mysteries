plugins {
    id("java")
    application
}

group = "org.jesperancinha.vtcc"
version = "unspecified"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.13.3"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add("--enable-preview")
}

tasks.withType<Test>().configureEach {
    jvmArgs = listOf("--enable-preview")
}

tasks.withType<JavaExec>().configureEach {
    jvmArgs = listOf("--enable-preview")
}

tasks.jar {
    manifest {
        attributes(
            "Main-Class" to "Main"
        )
    }
}

application {
    mainClass.set("")
}
