package com.example.mvvmrecipecomposeapp.di

import com.example.mvvmrecipecomposeapp.network.RecipeService
import com.example.mvvmrecipecomposeapp.network.model.RecipeDtoMapper
import com.example.mvvmrecipecomposeapp.repository.RecipeRepository
import com.example.mvvmrecipecomposeapp.repository.RecipeRepository_Impl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Singleton
    @Provides
    fun provideRecipeRepository(
        recipeService: RecipeService,
        recipeDtoMapper: RecipeDtoMapper
    ): RecipeRepository{
        return RecipeRepository_Impl(recipeService, recipeDtoMapper)
    }

    @Singleton
    @Provides
    @Named("auth_token")
    fun provideAuthToken():String{
        return "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    }
}