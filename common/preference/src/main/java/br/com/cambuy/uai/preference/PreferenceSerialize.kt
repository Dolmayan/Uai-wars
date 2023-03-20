package br.com.cambuy.uai.preference

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.datastore.core.Serializer
import br.com.cambuy.uai.core.CryptoManager
import java.io.InputStream
import java.io.OutputStream
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json

@RequiresApi(Build.VERSION_CODES.M)
object PreferenceSerialize : Serializer<UserPreferenceModel> {

    private val cryptoManager: CryptoManager = CryptoManager()

    override val defaultValue: UserPreferenceModel = UserPreferenceModel()

    override suspend fun readFrom(input: InputStream): UserPreferenceModel {
        val decryptedBytes = cryptoManager.decrypt(input)
        return runCatching {
            Json.decodeFromString(
                deserializer = UserPreferenceModel.serializer(),
                string = decryptedBytes.decodeToString()
            )
        }.getOrDefault(defaultValue)
    }

    override suspend fun writeTo(t: UserPreferenceModel, output: OutputStream) {
        withContext(Dispatchers.IO) {
            cryptoManager.encrypt(
                bytes = Json.encodeToString(
                    serializer = UserPreferenceModel.serializer(),
                    value = t
                ).encodeToByteArray(),
                outputStream = output
            )
        }
    }
}