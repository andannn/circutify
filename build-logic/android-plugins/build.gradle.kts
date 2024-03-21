plugins {
    `kotlin-dsl`
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "circutify.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibrary") {
            id = "circutify.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "circutify.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidApplicationCompose") {
            id = "circutify.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "circutify.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }
        register("androidTesting") {
            id = "circutify.android.testing"
            implementationClass = "AndroidTestingConventionPlugin"
        }
        register("androidRoom") {
            id = "circutify.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
    }
}