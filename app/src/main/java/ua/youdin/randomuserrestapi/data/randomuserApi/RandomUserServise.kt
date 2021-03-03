package ua.youdin.randomuserrestapi.data.randomuserApi

import android.os.Build
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import ua.youdin.randomuserrestapi.data.RepoLoadResult
import ua.youdin.randomuserrestapi.data.randomuserApi.model.Data
import ua.youdin.randomuserrestapi.data.randomuserApi.model.RandomUserResponse

interface RandomUserServise {
    @GET("api/?")
    suspend fun searchPerRage(
        @Query("seed") query: String,
        @Query("page") page: Int,
        @Query("results") itemsPerPage: Int,
    ): RandomUserResponse

    companion object {
        private val BASE_URL =
            if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) "https://randomuser.me/" else "http://randomuser.me/"

        fun create(): RandomUserServise {
            val logger = HttpLoggingInterceptor()
            logger.level = Level.BODY

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(RandomUserServise::class.java)
        }
    }
}