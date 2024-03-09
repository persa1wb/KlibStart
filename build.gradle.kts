plugins {
    kotlin("js") version "1.9.23"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    js(IR) {
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions.freeCompilerArgs.add("-Xir-minimized-member-names=false")
            }
        }

        browser {
            testTask {
                useKarma {
                    useIe()
                    useSafari()
                    useFirefox()
                    useChrome()
                    useChromeCanary()
                    useChromeHeadless()
                    usePhantomJS()
                    useOpera()
                }
            }
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
            }
        }
        binaries.executable()
        generateTypeScriptDefinitions()


    }
}


dependencies {
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react:18.2.0-pre.385")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom:18.2.0-pre.385")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion:11.10.4-pre.385")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom:6.3.0-pre.385")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-redux:4.1.2-pre.385")
    implementation("org.jetbrains.kotlin-wrappers:kotlin-react-redux:7.2.6-pre.385")

//     implementation("org.jetbrains.kotlin-wrappers:kotlin-tanstack-virtual-core-js:3.1.3-pre.710")
}

