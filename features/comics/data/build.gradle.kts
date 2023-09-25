apply(from = rootProject.file("base-library.build.gradle"))

dependencies {
    "implementation"(project(Modules.comicsDomain))
    "implementation"(project(Modules.network))
    "implementation"(project(Modules.core))

    "implementation"(Retrofit.gsonConverter)
    "implementation"(Retrofit.retrofit)

    "testImplementation"(Testing.mockServer)
    "testImplementation"(Retrofit.okHttp)
    "testImplementation"(Retrofit.gsonConverter)
    "testImplementation"(Retrofit.okHttpLoggingInterceptor)
}