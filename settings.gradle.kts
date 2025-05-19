plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}
rootProject.name = "kotlin-mysteries"
include ("carparts-manager")
include ("carparts-null-play")
include("carparts-inline")
include("carparts-tailrec")
include("carparts-data-structures")
include("carparts-use-site-targets")
