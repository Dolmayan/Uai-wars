apply(from = rootProject.file("base-library.build.gradle"))

dependencies {
    "implementation"(project(Modules.core))
}