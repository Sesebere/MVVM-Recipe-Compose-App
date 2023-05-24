package com.example.mvvmrecipecomposeapp.network.model


import com.example.mvvmrecipe.domain.util.DomainMapper
import com.example.mvvmrecipecomposeapp.domain.model.Recipe


class RecipeDtoMapper: DomainMapper<RecipeNetworkDto, Recipe> {
    override fun mapToDomain(entity: RecipeNetworkDto): Recipe {
        return Recipe(
            id = entity.pk,
            title = entity.title,
            featuredImage = entity.featuredImage,
            rating = entity.rating,
            publisher = entity.publisher,
            sourceUrl = entity.sourceUrl,
            description = entity.description,
            cookingInstructions = entity.cookingInstructions,
            ingredients = entity.ingredients?: listOf(),
            dateAdded = entity.dateAdded,
            dateUpdated = entity.dateUpdated,
        )
    }

    override fun mapFromDomain(domainModel: Recipe): RecipeNetworkDto {
        return RecipeNetworkDto(
            pk = domainModel.id,
            title = domainModel.title,
            featuredImage = domainModel.featuredImage,
            rating = domainModel.rating,
            publisher = domainModel.publisher,
            sourceUrl = domainModel.sourceUrl,
            description = domainModel.description,
            cookingInstructions = domainModel.cookingInstructions,
            ingredients = domainModel.ingredients,
            dateAdded = domainModel.dateAdded,
            dateUpdated = domainModel.dateUpdated,
        )
    }

    fun toDomainList(initial: List<RecipeNetworkDto>): List<Recipe>{
        return initial.map { mapToDomain(it) }
    }

    fun fromDomainList(initial: List<Recipe>): List<RecipeNetworkDto>{
        return initial.map { mapFromDomain(it) }
    }
}