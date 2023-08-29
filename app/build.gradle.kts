@Suppress("DSL_SCOPE_VIOLATION") // TODO: Remove once KTIJ-19369 is fixed
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("kotlin-kapt")
}

android {
    namespace = "com.wuyson.guidedemos"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.wuyson.guidedemos"
        minSdk = 24
        targetSdk = 34
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }

    buildFeatures {
        viewBinding = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.constraintlayout)

    implementation(libs.constraintlayout)

    //ktx
    implementation(libs.activity.ktx)
    implementation(libs.fragment.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.window.testing)

    //work manager
    implementation(libs.workmanager.work.runtime)
    implementation(libs.workmanager.work.runtime.ktx)

    //window manager
    implementation(libs.window)

    //lifecycle
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.lifecycle.viewmodel.ktx)
    implementation(libs.lifecycle.livedata.ktx)
    implementation(libs.lifecycle.service)
    implementation(libs.lifecycle.process)
//    kapt(libs.lifecycle.compiler)
    implementation( libs.brv)

    implementation  (libs.smart.refresh.layout.kernel)     //核心必须依赖
    implementation  (libs.smart.refresh.header.classics)   //经典刷新头
//    implementation  'io.github.scwang90:refresh-header-radar:2.0.6'       //雷达刷新头
//    implementation  'io.github.scwang90:refresh-header-falsify:2.0.6'     //虚拟刷新头
//    implementation  'io.github.scwang90:refresh-header-material:2.0.6'    //谷歌刷新头
//    implementation  'io.github.scwang90:refresh-header-two-level:2.0.6'   //二级刷新头
//    implementation  'io.github.scwang90:refresh-footer-ball:2.0.6'        //球脉冲加载
    implementation  (libs.smart.refresh.footer.classics)  //经典加载

    debugImplementation(libs.leakcanary.android)
//    implementation ("com.jakewharton:butterknife:10.2.3")
//    annotationProcessor("com.jakewharton:butterknife-compiler:10.2.3")
//    implementation("com.google.android:android:4.2.2")

}