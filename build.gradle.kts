plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "com.vavrajosef"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/com.github.librepdf/openpdf
    implementation("com.github.librepdf:openpdf:1.3.30")

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}