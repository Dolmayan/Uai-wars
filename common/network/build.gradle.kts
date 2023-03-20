apply(from = rootProject.file("base-library.build.gradle"))

dependencies {
    "implementation"(Retrofit.retrofit)
    "implementation"(Retrofit.okHttp)
    "implementation"(Retrofit.gsonConverter)
    "implementation"(Retrofit.okHttpLoggingInterceptor)
}