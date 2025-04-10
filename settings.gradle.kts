plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.10.0"
}
rootProject.name = "kotlin-mysteries"
include ("carparts-manager")
include ("carparts-null-play")
include("carparts-inline")
include("carparts-tailrec")
include("carparts-data-structures")
include("carparts-use-site-targets")
