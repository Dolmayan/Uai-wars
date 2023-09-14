apply(from = rootProject.file("base-presentation.build.gradle"))

dependencies {
    "implementation"(project(Modules.charactersDomain))
    "implementation"(project(Modules.designSystem))
    "implementation"(project(Modules.core))
}