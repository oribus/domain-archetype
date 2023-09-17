plugins {
    java
    //checkstyle

    // NOTE: external plugin version is specified in implementation dependency artifact of the project's build file
    id("com.github.spotbugs")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    spotbugsPlugins("com.h3xstream.findsecbugs:findsecbugs-plugin:1.12.0")
    compileOnly("org.projectlombok:lombok:1.18.28")
    compileOnly("org.mapstruct:mapstruct:1.5.5.Final")
    annotationProcessor("org.projectlombok:lombok:1.18.28")
    annotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
    testCompileOnly("org.projectlombok:lombok:1.18.28")
    testCompileOnly("org.mapstruct:mapstruct:1.5.5.Final")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.28")
    testAnnotationProcessor("org.mapstruct:mapstruct-processor:1.5.5.Final")
}