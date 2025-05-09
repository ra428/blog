plugins {
	// JVM target environment
    kotlin("jvm") version "2.1.20"

	// opens classes and methods annotated with Spring annotations
    kotlin("plugin.spring") version "2.1.20"

	id("org.springframework.boot") version "3.4.5"
    id("io.spring.dependency-management") version "1.1.7"

    // use Kotlin non-nullable properties with JPA.
    // Generates no-arg constructors for @Entity, @MappedSuperclass and @Embeddable.
    kotlin("plugin.jpa") version "2.1.20"
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
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-mustache")
    implementation("org.springframework.boot:spring-boot-starter-web")

    // Support for SerDe of Kotlin classes and data classes
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")

    implementation("org.jetbrains.kotlin:kotlin-reflect")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
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
