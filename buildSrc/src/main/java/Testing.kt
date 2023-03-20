object Testing {
    const val hiltTesting = "com.google.dagger:hilt-android-testing:${DaggerHilt.hiltVersion}"

    private const val truthVersion = "1.1.3"
    const val truth = "com.google.truth:truth:$truthVersion"

    private const val mockkVersion = "1.12.4"
    const val mockk = "io.mockk:mockk:$mockkVersion"
    const val mockkAgent = "io.mockk:mockk-agent-jvm:$mockkVersion"
    const val mockkAndroid = "io.mockk:mockk-android:$mockkVersion"

    const val mockServer = "com.squareup.okhttp3:mockwebserver:${Retrofit.okHttpVersion}"

    private const val junitVersion = "4.13.2"
    const val junit4 = "junit:junit:$junitVersion"

    private const val androidJunitVersion = "1.1.3"
    const val junitAndroidExt = "androidx.test.ext:junit:$androidJunitVersion"

    private const val espressoVersion = "3.4.0"
    const val espressoCore = "androidx.test.espresso:espresso-core:$espressoVersion"

    private const val composeUiJunitVersion = "1.2.0"
    const val composeUiJunit = "androidx.compose.ui:ui-test-junit4:$composeUiJunitVersion"
}
