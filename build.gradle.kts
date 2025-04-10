plugins {
    java
    id("org.springframework.boot") version "3.4.4"
    id("io.spring.dependency-management") version "1.1.7"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-validation")

    runtimeOnly("com.h2database:h2")

    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
    //Mapping
    implementation ("org.mapstruct:mapstruct:1.5.5.Final")
    annotationProcessor ("org.mapstruct:mapstruct-processor:1.5.5.Final")
    annotationProcessor("org.projectlombok:lombok-mapstruct-binding:0.2.0")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    jvmArgs(
        "-javaagent:${configurations.testRuntimeClasspath.get().files.find { it.name.contains("mockito-core") }?.absolutePath}"
    )
    useJUnitPlatform()

    testLogging {
        events("PASSED", "FAILED", "SKIPPED") // show these test events
        showStandardStreams = true            // show output from println and logs
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
    }

    afterSuite(KotlinClosure2<TestDescriptor, TestResult, Unit>({ desc, result ->
        // Only print summary at the top level suite
        if (desc.parent == null) {
            println("────────────────────────────────────────────")
            println("Test result: ${result.resultType}")
            println("Total: ${result.testCount}, Passed: ${result.successfulTestCount}, Failed: ${result.failedTestCount}, Skipped: ${result.skippedTestCount}")
            println("────────────────────────────────────────────")
        }
    }))
}
