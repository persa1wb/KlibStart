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
     testImplementation(kotlin("test"))
     implementation("org.jetbrains.kotlin-wrappers:kotlin-react-js:18.2.0-pre.710")
     implementation("org.jetbrains.kotlin-wrappers:kotlin-react-dom-js:8.2.0-pre.710")
     implementation("org.jetbrains.kotlin-wrappers:kotlin-emotion-js:11.11.1-pre.710")
     implementation("org.jetbrains.kotlin-wrappers:kotlin-react-router-dom-js:6.22.1-pre.710")
     implementation("org.jetbrains.kotlin-wrappers:kotlin-redux-js:4.1.2-pre.710")
     implementation("org.jetbrains.kotlin-wrappers:kotlin-react-redux-js:7.2.6-pre.710")
     implementation("org.jetbrains.kotlin-wrappers:kotlin-popper-js:2.11.8-pre.710")
     implementation("org.jetbrains.kotlin-wrappers:kotlin-tanstack-virtual-core-js:3.1.3-pre.710")
 }

