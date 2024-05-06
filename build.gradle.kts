plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation (platform("org.junit:junit-bom:5.9.1"))
    testImplementation ("org.junit.jupiter:junit-jupiter")
    implementation ("com.fasterxml.jackson.core:jackson-core:2.16.1")
    implementation ("com.fasterxml.jackson.core:jackson-annotations:2.16.1")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.16.1")
    implementation ("org.slf4j:slf4j-api:2.0.12")
    implementation ("org.apache.logging.log4j:log4j-core:2.23.1")
    implementation ("org.mongodb:mongodb-driver-sync:5.0.1")
    implementation ("org.slf4j:slf4j-api:1.7.32")
    implementation ("ch.qos.logback:logback-classic:1.4.12")


}

tasks.test {
    useJUnitPlatform()
}