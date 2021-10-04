plugins {
    id("org.hidetake.ssh") version ("2.9.0")
    id("war")
}

apply(plugin = "org.springframework.boot")

dependencies {
    api(project(":service"))
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-actuator")

    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor")

    providedRuntime("org.springframework.boot:spring-boot-starter-tomcat")
}


tasks.getByName<War>("war") {
    enabled = true
}

tasks.getByName<org.springframework.boot.gradle.tasks.bundling.BootWar>("bootWar") {
    archiveBaseName.set(rootProject.name)
    mainClassName = "pl.doz.rzesa.RzesaApplication"
    archiveVersion.set("")
}

configure<org.springframework.boot.gradle.dsl.SpringBootExtension> {
    buildInfo()
}