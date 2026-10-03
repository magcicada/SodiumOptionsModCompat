import dev.kikugie.stonecutter.StonecutterSettings

pluginManagement {
    // Blahaj 1.0.55 source checkout. This replaces the dead maven.txni.dev plugin artifact.
    includeBuild("Blahaj")

    repositories {
        mavenCentral()
        gradlePluginPortal()
        maven("https://maven.fabricmc.net/")
        maven("https://maven.architectury.dev")
        maven("https://maven.minecraftforge.net")
        maven("https://maven.neoforged.net/releases/")
        maven("https://maven.kikugie.dev/snapshots")
        maven("https://maven.kikugie.dev/releases")
    }
}

plugins {
    // Blahaj 1.0.55 itself is compiled against Stonecutter 0.6-alpha.5.
    id("dev.kikugie.stonecutter") version "0.6-alpha.5"
}

extensions.configure<StonecutterSettings> {
    kotlinController = true
    centralScript = "build.gradle.kts"
    shared {
        fun mc(version: String, vararg loaders: String) {
            for (it in loaders) vers("$version-$it", version)
        }

        mc("1.20.1", "fabric", "forge")
        mc("1.21.1", "fabric", "neoforge")
        mc("1.21.4", "fabric", "neoforge")
    }
    create(rootProject)
}

rootProject.name = "SodiumOptionsModCompat"
