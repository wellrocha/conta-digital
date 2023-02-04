plugins {
    id("com.wellrocha-common-conventions")

    id("org.springframework.boot") version "3.0.2"
    id("io.spring.dependency-management") version "1.1.0"

    kotlin("plugin.spring") version "1.7.22"
}

dependencies {
    implementation(project(":core"))

    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test")

    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
}