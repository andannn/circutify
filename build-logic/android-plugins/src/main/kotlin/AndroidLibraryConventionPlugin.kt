import com.andanana.circutify.configureKoinAndroid
import com.andanana.circutify.configureKotlinAndroid
import com.andanana.circutify.configureTimberAndroid
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<LibraryExtension> {
                defaultConfig.targetSdk = 34
                configureKotlinAndroid(this)
                configureKoinAndroid(this)
                configureTimberAndroid(this)
            }
        }
    }
}
