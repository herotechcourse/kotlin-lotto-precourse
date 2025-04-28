plugins {
    application
    kotlin("jvm") version "1.9.24"
}
application {
    mainClass.set("lotto.ApplicationKt")
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
}
group = "camp.nextstep.edu"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(21)
}

repositories {
    mavenCentral()
    maven { url = uri("https://jitpack.io") }
    
}

dependencies {
    
    implementation("com.github.woowacourse-projects:mission-utils:1.2.0")
}

tasks {
    test {
        useJUnitPlatform()
    }
}
