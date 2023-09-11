pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "Uai Wars"
include(":app")
include(":features")
include(":features:characters")
include(":common:network")
include(":common:design_system")
include(":common:preference")
include(":common:core")
include(":features:characters:data")
include(":features:characters:domain")
