pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "AvalancheSnowSafety"
include(":app")
include(":data")
include(":feature")
include(":core")
include(":feature:observation")
include(":core:foundation")
include(":feature:bulletin")
include(":core:network")
include(":data:bulletin")
include(":data:bulletin")
include(":core:storage")
include(":feature:authorization")
include(":core:designsystem")
include(":feature:app_bar")
include(":feature:weather")
