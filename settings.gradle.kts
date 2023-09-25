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
include(":common:core")
include(":common:design_system")
include(":common:network")
include(":common:preference")
include(":features")
include(":features:characters")
include(":features:characters:data")
include(":features:characters:domain")
include(":features:characters:presentation")
include(":features:comics")
include(":features:comics:data")
include(":features:comics:domain")
include(":features:comics:presentation")
