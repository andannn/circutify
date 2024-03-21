import com.andanana.circutify.configureKotlinAndroid
import com.andanana.circutify.libs
import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 34

                dependencies {
                    val bom = libs.findLibrary("koin-bom").get()
                    add("implementation", platform(bom))
                    "implementation"(libs.findLibrary("koin.core").get())
                }
            }
        }
    }
}
