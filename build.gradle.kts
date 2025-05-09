plugins {
    alias(libs.plugins.jvm)
    alias(libs.plugins.spring)
    alias(libs.plugins.jpa)
    alias(libs.plugins.allopen)
    alias(libs.plugins.springBoot)
    id("io.spring.dependency-management") version "1.1.7"
}

group = "training.spring"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_23
    targetCompatibility = JavaVersion.VERSION_23
    toolchain {
        languageVersion = JavaLanguageVersion.of(23)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(libs.bundles.springBootStarterWebApp)
    // Support for SerDe of Kotlin classes and data classes
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.jetbrains.kotlin:kotlin-reflect")

    developmentOnly(libs.springBootDevtools)
    runtimeOnly("com.h2database:h2")
    testImplementation(libs.springBootStarterTest)
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

kotlin {
    jvmToolchain(23)
    compilerOptions {

        // By default, types from Java APIs used in Kotlin are recognized
        // as platform types for which null-checks are relaxed

        // Compile time null-safety using JSR 305, the @Nonnull annotation
        // https://kotlinlang.org/docs/java-interop.html#jsr-305-support
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
