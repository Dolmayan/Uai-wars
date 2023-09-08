object Build {
    private const val hiltAndroidGradlePluginVersion = "2.42"
    const val hiltAndroidGradlePlugin =
        "com.google.dagger:hilt-android-gradle-plugin:$hiltAndroidGradlePluginVersion"

    const val jacocoVersion = "0.8.7"
    const val jacocoGradlePlugin = "org.jacoco:org.jacoco.core:$jacocoVersion"

    private const val googleServicesVersion = "4.3.13"
    const val googleServices = "com.google.gms:google-services:$googleServicesVersion"

    private const val serializationVersion = "1.8.10"
    const val serialization = "org.jetbrains.kotlin:kotlin-serialization:$serializationVersion"
}