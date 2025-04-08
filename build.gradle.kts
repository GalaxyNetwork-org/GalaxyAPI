plugins {
    kotlin("jvm") version "2.1.20"
    id("com.github.johnrengelman.shadow") version "8.1.1"
    id("xyz.jpenilla.run-paper") version "2.3.1"
    `maven-publish`
}

group = "xyz.lncvrt"
version = "1.0.1-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/") {
        name = "papermc-repo"
    }
    maven("https://oss.sonatype.org/content/groups/public/") {
        name = "sonatype"
    }
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.1-R0.1-SNAPSHOT")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
}

val targetJavaVersion = 17
kotlin {
    jvmToolchain(targetJavaVersion)
}

tasks {
    shadowJar {
        archiveBaseName.set(rootProject.name)
        archiveClassifier.set("")
    }

    build {
        dependsOn("shadowJar")
    }

    processResources {
        val props = mapOf("version" to version)
        inputs.properties(props)
        filteringCharset = "UTF-8"
        filesMatching("plugin.yml") {
            expand(props)
        }
    }

    runServer {
        minecraftVersion("1.20.1")
    }
}

publishing {
    repositories {
        maven {
            name = "lncvrtRepositoryReleases"
            url = uri("https://repo.lncvrt.xyz/releases")
            credentials {
                username = System.getenv("LNCVRT_REPO_USERNAME")
                password = System.getenv("LNCVRT_REPO_PASSWORD")
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
        maven {
            name = "lncvrtRepositorySnapshots"
            url = uri("https://repo.lncvrt.xyz/snapshots")
            credentials {
                username = System.getenv("LNCVRT_REPO_USERNAME")
                password = System.getenv("LNCVRT_REPO_PASSWORD")
            }
            authentication {
                create<BasicAuthentication>("basic")
            }
        }
    }
    publications {
        create<MavenPublication>("maven") {
            groupId = "xyz.lncvrt"
            artifactId = rootProject.name.lowercase()
            version = rootProject.version as String?
            artifact(tasks.shadowJar)
        }
    }
}
