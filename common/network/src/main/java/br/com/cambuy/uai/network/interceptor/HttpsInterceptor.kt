package br.com.cambuy.uai.network.interceptor

import br.com.cambuy.uai.network.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

class HttpsInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val currentTimestamp = System.currentTimeMillis()
        val newUrl = chain.request().url.newBuilder().apply {
            addQueryParameter(TS, currentTimestamp.toString())
            addQueryParameter(APIKEY, BuildConfig.PUBLIC_API_KEY)
            addQueryParameter(
                HASH,
                provideToMd5Hash(currentTimestamp.toString() + BuildConfig.PRIVATE_API_KEY + BuildConfig.PUBLIC_API_KEY)
            )
        }.build()

        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()
        chain.proceed(newRequest)

        try {
            val response = chain.proceed(newRequest)

            if (response.code in 400..599) {
                Unit //Realizar tratativas futuras
            }

            return response
        } catch (e: Exception) {
            throw e
        }
    }

    private fun provideToMd5Hash(encrypted: String): String {
        var pass = encrypted
        var encryptedString: String? = null
        val md5: MessageDigest
        try {
            md5 = MessageDigest.getInstance(ALGORITHM)
            md5.update(pass.toByteArray(), 0, pass.length)
            pass = BigInteger(1, md5.digest()).toString(16)
            while (pass.length < 32) {
                pass = "0$pass"
            }
            encryptedString = pass
        } catch (e1: NoSuchAlgorithmException) {
            e1.printStackTrace()
        }
        return encryptedString.orEmpty()
    }

    private companion object {
        const val ALGORITHM = "MD5"
        const val APIKEY = "apikey"
        const val HASH = "hash"
        const val TS = "ts"
    }
}