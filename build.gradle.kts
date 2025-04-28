plugins {
    kotlin("jvm") version "1.9.24"
    application
}

group = "camp.nextstep.edu"
version = "1.0-SNAPSHOT"

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("lotto.ApplicationKt")
    
    // 添加以下配置以启用交互式输入
    applicationDefaultJvmArgs = listOf("-Dorg.gradle.console=plain")
}

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

dependencies {
    implementation("com.github.woowacourse-projects:mission-utils:1.2.0")
}

// 添加这个jar任务配置
tasks.jar {
    manifest {
        attributes["Main-Class"] = "lotto.ApplicationKt"
    }
    // 包含所有依赖项
    from(configurations.runtimeClasspath.get().map { if (it.isDirectory) it else zipTree(it) })
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

tasks {
    test {
        useJUnitPlatform()
    }
    
    // 添加以下任务配置
    named<JavaExec>("run") {
        standardInput = System.`in`
    }
}
