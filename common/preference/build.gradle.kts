apply(from = rootProject.file("base-library.build.gradle"))

dependencies {
    "implementation"(project(Modules.core))
    "implementation"(JetBrains.kotlinStdJdk7)
    "implementation"(JetBrains.serializationJson)
    "implementation"(JetBrains.immutableCollections)
    "implementation"(AndroidX.dataStore)
}