package com.example.fizzbuzzapp.di

import com.example.fizzbuzzapp.data.repository.FizzBuzzRepository
import com.example.fizzbuzzapp.data.repository.FizzBuzzRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DispatcherModule {
    @Provides
    @ViewModelScoped
    fun provideFizzBuzzRepositoryImpl(): FizzBuzzRepository {
        return FizzBuzzRepositoryImpl()
    }
}