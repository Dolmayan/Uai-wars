object AndroidX {

    private const val coreKtxVersion = "1.8.0"
    const val coreKtx = "androidx.core:core-ktx:$coreKtxVersion"

    private const val webKitVersion = "1.5.0"
    const val androidWebKit = "androidx.webkit:webkit:$webKitVersion"

    private const val dataStoreVersion = "1.0.0"
    const val dataStore = "androidx.datastore:datastore:$dataStoreVersion"

    private const val navigationVersion = "2.5.0"
    private const val hiltNavigationComposeVersion = "1.0.0"

    // Jetpack Compose Integration
    const val navigationCompose = "androidx.navigation:navigation-compose:$navigationVersion"
    const val hiltNavigationCompose = "androidx.hilt:hilt-navigation-compose:$hiltNavigationComposeVersion"

    private const val lifecycleVersion = "2.5.0"
    const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycleVersion"
    const val lifecycleCompiler = "androidx.lifecycle:lifecycle-compiler:$lifecycleVersion"

    private const val composeActivityVersion = "1.5.1"
    private const val composeAppCompatThemeVersion = "0.16.0"
    private const val composeVersion = "1.2.1"
    private const val composeMaterial3Version = "1.1.0"
    const val compilerComposeVersion = "1.4.7"

    // Integration with activities
    const val activityCompose = "androidx.activity:activity-compose:$composeActivityVersion"

    // Compose Material Design
    const val composeMaterial = "androidx.compose.material:material:$composeVersion"
    const val composeMaterial3 = "androidx.compose.material3:material3:$composeMaterial3Version"

    // Animations
    const val composeAnimation = "androidx.compose.animation:animation:$composeVersion"

    // Tooling support (Previews, etc.)
    const val composeUiTools = "androidx.compose.ui:ui-tooling:$composeVersion"

    // Integration with ViewModels
    const val composeViewModel = "androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycleVersion"

    // When using a AppCompat theme
    const val composeAppCompatTheme =
        "com.google.accompanist:accompanist-appcompat-theme:$composeAppCompatThemeVersion"

    // ConstraintLayout for compose
    private const val composeConstraintVersion = "1.0.1"
    const val composeConstraintLayout = "androidx.constraintlayout:constraintlayout-compose:$composeConstraintVersion"

    private const val poolingContainerVersion = "1.0.0"
    const val poolingContainer = "androidx.customview:customview-poolingcontainer:$poolingContainerVersion"
}
