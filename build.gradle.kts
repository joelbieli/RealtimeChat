import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.2.71"
}

group = "ch.joelbieli"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.javalin", "javalin", "2.3.0")
    implementation("org.slf4j", "slf4j-simple", "1.7.25")
    implementation("com.fasterxml.jackson.module", "jackson-module-kotlin", "2.9.7")
    implementation("org.litote.kmongo", "kmongo", "3.8.3")
    implementation("org.mindrot", "jbcrypt", "0.4")

    testImplementation("org.jetbrains.spek", "spek-api", "1.1.5")
    testImplementation("org.jetbrains.spek", "spek-junit-platform-engine", "1.1.5")
    testImplementation("junit", "junit", "4.12")
    testImplementation("org.junit.platform", "junit-platform-runner", "1.3.1")
    testImplementation("org.junit.jupiter", "junit-jupiter-api", "5.3.1")

    compile(kotlin("stdlib-jdk8"))
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}