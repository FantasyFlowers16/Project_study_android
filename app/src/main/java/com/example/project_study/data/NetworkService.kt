package com.example.project_study.data

import Constants.BASE_URL
import android.provider.SyncStateContract
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkService {
    private val myClient: OkHttpClient = OkHttpClient.Builder()
            .connectTimeout(20, TimeUnit.SECONDS)
            .build()

    private fun provideGson(): Gson = GsonBuilder()
            .setLenient()
            .create()

    private fun retrofit(): Retrofit = Retrofit.Builder()
            .client(myClient)
            .baseUrl("https://test.kode-t.ru/")
            .addConverterFactory(GsonConverterFactory.create(provideGson()))
            .build()

    fun networkService(): Api = retrofit().create(Api::class.java)
}