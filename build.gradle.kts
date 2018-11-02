import org.jetbrains.dokka.DokkaBootstrap
import org.jetbrains.dokka.DokkaConfiguration
import org.jetbrains.dokka.gradle.DokkaPlugin
import org.jetbrains.dokka.gradle.DokkaTask
import org.jetbrains.dokka.gradle.DokkaVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath("org.jetbrains.dokka:dokka-gradle-plugin:0.9.17")
    }
}

plugins {
    id("org.jetbrains.dokka") version "0.9.17"
    kotlin("jvm") version "1.2.70"
}

group = "ch.joelbieli"
version = "1.0"

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("io.javalin", "javalin", "2.3.0")
    implementation("org.slf4j", "slf4j-simple", "1.7.25")
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin", "2.9.7")
    implementation("org.litote.kmongo", "kmongo", "3.8.3")
    implementation("org.mindrot", "jbcrypt", "0.4")
    implementation("io.github.microutils", "kotlin-logging", "1.6.10")
    implementation("com.kstruct", "gethostname4j", "0.0.2")
    implementation("commons-codec", "commons-codec", "1.11")
    implementation("io.jsonwebtoken", "jjwt-api", "0.10.5")


    runtimeOnly("io.jsonwebtoken", "jjwt-impl", "0.10.5")
    runtimeOnly("io.jsonwebtoken", "jjwt-jackson", "0.10.5")


    testImplementation("org.junit.platform", "junit-platform-runner", "1.3.1")
    testImplementation("org.junit.platform", "junit-platform-launcher", "1.3.1")
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.3.1")
    testImplementation("org.junit.jupiter", "junit-jupiter-engine", "5.3.1")
    testImplementation("org.jetbrains.spek", "spek-api", "1.1.5") {
        exclude("org.jetbrains.kotlin")
    }
    testRuntime("org.jetbrains.spek", "spek-junit-platform-engine", "1.1.5") {
        exclude("org.jetbrains.kotlin")
    }
    testImplementation("org.amshove.kluent", "kluent", "1.42")

    compile(kotlin("stdlib-jdk8"))
}

tasks.withType<Test> {
    useJUnitPlatform {
        includeEngines("spek")
    }
}

tasks.withType<DokkaTask> {
    outputFormat = "gfm"
    outputDirectory = "$rootDir/docs/"
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}