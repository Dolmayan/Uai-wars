package br.com.cambuy.uai.preference

import android.content.Context
import androidx.datastore.dataStore

val Context.dataStore by dataStore("user-preference-data.json", PreferenceSerialize)