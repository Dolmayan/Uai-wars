apply(from = rootProject.file("base-presentation.build.gradle"))

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(AndroidX.composeMaterial3)
    "implementation"(AndroidX.composeUiTools)
}