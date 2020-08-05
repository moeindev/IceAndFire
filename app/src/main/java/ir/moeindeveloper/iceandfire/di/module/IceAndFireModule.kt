package ir.moeindeveloper.iceandfire.di.module

import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import ir.moeindeveloper.iceandfire.IceAndFireApplication
import ir.moeindeveloper.iceandfire.data.network.*
import ir.moeindeveloper.iceandfire.di.annotation.IceAndFire
import ir.moeindeveloper.iceandfire.di.annotation.Quotes
import ir.moeindeveloper.iceandfire.utils.network.NetworkHelper
import okhttp3.Cache
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class IceAndFireModule {

    @IceAndFire
    @Provides
    @Singleton
    fun provideIceAndFireBaseURL(): String = "https://www.anapioficeandfire.com/"

    @Quotes
    @Provides
    @Singleton
    fun provideQuotesBaseURL(): String = "https://got-quotes.herokuapp.com/"

    @Provides
    @Singleton
    fun provideNetworkHelper(@ApplicationContext context: Context): NetworkHelper = NetworkHelper(context)

    @Provides
    @Singleton
    fun provideOkHttpClient(@ApplicationContext context: Context, networkHelper: NetworkHelper): OkHttpClient {

        val cacheSize = (5 * 1024 * 1024).toLong()
        val myCache = Cache(context.cacheDir, cacheSize)

        return OkHttpClient.Builder()
            .cache(myCache)
            .addInterceptor { chain ->
                var request = chain.request()
                request = if (networkHelper.isNetworkConnected())
                    request.newBuilder().header("Cache-Control", "public, max-age=" + 5).build()
                else
                    request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                chain.proceed(request)
            }
            .build()
    }

    @IceAndFire
    @Provides
    @Singleton
    fun provideIceAndFireRetrofit(client: OkHttpClient, @IceAndFire baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()
    }

    @Quotes
    @Provides
    @Singleton
    fun provideQuotesRetrofit(client: OkHttpClient, @Quotes baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .client(client)
            .build()
    }


    @Provides
    @Singleton
    fun provideSharedPreference(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("settings_pref",Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideIceAndFireApiService(@IceAndFire retrofit: Retrofit) = retrofit.create(IceAndFireApiService::class.java)

    @Provides
    @Singleton
    fun provideIceAndFireApiHelper(@Quotes retrofit: Retrofit) = retrofit.create(QuotesApiService::class.java)


    @Provides
    @Singleton
    fun provideQuotesApiService(apiImpl: IceAndFireApiImpl): IceAndFireApiHelper = apiImpl

    @Provides
    @Singleton
    fun provideQuotesApiHelper(apiImpl: QuotesApiImpl): QuotesApiHelper = apiImpl
}