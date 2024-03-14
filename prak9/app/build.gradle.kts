repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

application {
    // Define the main class for the application.
    mainClass.set("prak9.App")
}

tasks.named<Test>("test") {
    // Use JUnit Platform for unit tests.
    useJUnitPlatform()
}

plugins {
    id 'java'
    id 'application'
}

repositories {
    jcenter()
}

dependencies {
    // Use JUnit Jupiter for testing.
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.1")

    // This dependency is used by the application.
    implementation("com.google.guava:guava:31.1-jre")
}

task buildDocker(type: Exec) {
    workingDir 'docker'
    commandLine 'docker', 'build', '-t', 'your-docker-image-name', '.'
}

task runDocker(type: Exec, dependsOn: buildDocker) {
    commandLine 'docker', 'run', '--rm', 'your-docker-image-name'
}

task buildJar(type: Jar) {
    archiveFileName = 'your-app.jar'
    from sourceSets.main.output
}

task copyJar(type: Copy, dependsOn: buildJar) {
    from 'build/libs/'
    into 'docker/'
}

build.finalizedBy(copyJar)

