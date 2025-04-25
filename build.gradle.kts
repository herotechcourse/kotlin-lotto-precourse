plugins {
    kotlin("jvm") version "1.9.24"
}

group = "camp.nextstep.edu"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation("camp.nextstep.edu.missionutils:missionutils:1.0.0")
}


tasks {
    test {
        useJUnitPlatform()
    }
}
