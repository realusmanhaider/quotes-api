package com.example.quotesapi.di

import com.example.quotesapi.repository.Repository
import com.example.quotesapi.network.api.ApiService
import com.example.quotesapi.ui.viewmodels.QuotesViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://famous-quotes4.p.rapidapi.com")
            .addConverterFactory(GsonConverterFactory.create()) // Use appropriate converter based on your API response format
            .client(
                OkHttpClient.Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BASIC))
                .build())
            .build()
    }

    @Provides
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideRepository(apiService: ApiService): Repository {
        return Repository(apiService)
    }
}


@Module
@InstallIn(ActivityRetainedComponent::class)
object ViewModelModule {

    @Provides
    @ActivityRetainedScoped
    fun provideViewModel(repository: Repository): QuotesViewModel{

        return QuotesViewModel(repository)
    }
}
