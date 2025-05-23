/*
 * Copyright (c) 2024 ModCore Inc. All rights reserved.
 *
 * This code is part of ModCore Inc.'s Essential Mod repository and is protected
 * under copyright registration # TX0009138511. For the full license, see:
 * https://github.com/EssentialGG/Essential/blob/main/LICENSE
 *
 * You may not use, copy, reproduce, modify, sell, license, distribute,
 * commercialize, or otherwise exploit, or create derivative works based
 * upon, this file or any other in this repository, all of which is reserved by Essential.
 */
import gg.essential.gradle.util.KotlinVersion

plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization")
}

repositories {
    mavenCentral()
}

kotlin {
    jvm()

    sourceSets["commonMain"].dependencies {
        val kotlin = KotlinVersion.minimal
        implementation(kotlin("stdlib", kotlin.stdlib))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:${kotlin.coroutines}")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-core:${kotlin.serialization}")
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${kotlin.serialization}")
        api("dev.folomeev.kotgl:kotgl-matrix:0.0.1-beta")
    }

    sourceSets.jvmMain.dependencies {
        api(libs.slf4j.api)
    }

    kotlin.jvmToolchain(8)
}
