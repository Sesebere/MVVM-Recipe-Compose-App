package com.example.mvvmrecipecomposeapp.repository

import com.example.mvvmrecipecomposeapp.domain.model.Recipe
import com.example.mvvmrecipecomposeapp.network.RecipeService
import com.example.mvvmrecipecomposeapp.network.model.RecipeDtoMapper


class RecipeRepository_Impl (
    private val recipeService: RecipeService,
    private val mapper: RecipeDtoMapper,
): RecipeRepository {

    override suspend fun search(token: String, page: Int, query: String): List<Recipe> {
        return mapper.toDomainList(recipeService.search(token = token, page = page, query = query).recipes)
    }

    override suspend fun get(token: String, id: Int): Recipe {
        return mapper.mapToDomain(recipeService.get(token = token, id))
    }

}