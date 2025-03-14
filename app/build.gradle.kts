plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
//    id("jacoco")
    id("org.sonarqube") version "6.0.1.5171"
}

android {
    namespace = "net.jamnig.testapp"
    compileSdk = 35

    defaultConfig {
        applicationId = "net.jamnig.testapp"
        minSdk = 30
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
/*    testOptions {
        unitTests {
            all {
                it.useJUnitPlatform()
                it.finalizedBy(tasks.named("jacocoTestReport"))
            }
        }
    }*/
}

//tasks.register<JacocoReport>("jacocoTestReport") {
//    dependsOn("testDebugUnitTest")
//
//    reports {
//        xml.required.set(true)
//        xml.outputLocation.set(file("${project.projectDir}/build/reports/jacoco/jacocoTestReport/jacocoTestReport.xml"))
//    }
//
//    val fileFilter = listOf(
//        "**/R.class",
//        "**/R$*.class",
//        "**/BuildConfig.*",
//        "**/Manifest*.*",
//        "**/*Test*.*",
//        "android/**/*.*"
//    )
//    val debugTree = fileTree(
//        mapOf(
//            "dir" to layout.buildDirectory.dir("intermediates/javac/debug").get().asFile,
//            "excludes" to fileFilter
//        )
//    )
//    val mainSrc = "${project.projectDir}/src/main/java"
//
//    sourceDirectories.setFrom(files(mainSrc))
//    classDirectories.setFrom(files(debugTree))
//    executionData.setFrom(files("${layout.buildDirectory.get().asFile}/jacoco/testDebugUnitTest.exec"))
//}

sonar {
    properties {
        property("sonar.projectKey", "SE-II-group_github-ci")
        property("sonar.organization", "se-ii-group")
        property("sonar.host.url", "https://sonarcloud.io")
//        property("sonar.java.coveragePlugin", "jacoco")
//        property(
//            "sonar.coverage.jacoco.xmlReportPaths",
//            "${project.projectDir}/build/reports/jacoco/jacocoTestReport/jacocoTestReport.xml"
//        )
    }
}

dependencies {
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    testImplementation(libs.junit.jupiter.api)
    testRuntimeOnly(libs.junit.jupiter.engine)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}