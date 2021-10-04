pluginManagement {
    val kotlinPluginVersion: String by settings
    val springBootVersion: String by settings

    plugins {
        kotlin("jvm") version kotlinPluginVersion
        kotlin("plugin.allopen") version kotlinPluginVersion
        kotlin("plugin.noarg") version kotlinPluginVersion
        kotlin("kapt") version kotlinPluginVersion

        kotlin("plugin.jpa") version kotlinPluginVersion
        kotlin("plugin.spring") version kotlinPluginVersion
        id("org.springframework.boot") version springBootVersion
        id("io.spring.dependency-management") version "1.0.11.RELEASE"
    }
}

rootProject.name = "rzesa-agent"
include("app", "service", "external-services")