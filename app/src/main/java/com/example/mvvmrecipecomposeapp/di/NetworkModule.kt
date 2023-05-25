package com.example.mvvmrecipecomposeapp.di

import com.example.mvvmrecipecomposeapp.network.RecipeService
import com.example.mvvmrecipecomposeapp.network.model.RecipeDto
import com.example.mvvmrecipecomposeapp.network.model.RecipeDtoMapper
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Singleton
    @Provides
    fun provideRecipeMapper():RecipeDtoMapper{
        return RecipeDtoMapper()
    }

    @Singleton
    @Provides

    fun provideRecipeService():RecipeService{
        return Retrofit.Builder()
            .baseUrl("https://food2fork.ca/api/recipe/")
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(RecipeService::class.java)
    }
}