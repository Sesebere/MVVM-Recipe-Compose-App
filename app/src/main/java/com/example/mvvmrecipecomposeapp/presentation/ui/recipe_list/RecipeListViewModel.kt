package com.example.composeandfragments.presentation.ui.recipe_list

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmrecipecomposeapp.domain.model.Recipe
import com.example.mvvmrecipecomposeapp.presentation.ui.recipe_list.FoodCategory
import com.example.mvvmrecipecomposeapp.presentation.ui.recipe_list.getFoodCategory
import com.example.mvvmrecipecomposeapp.repository.RecipeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Named

@HiltViewModel
class RecipeListViewModel
@Inject
constructor(
    private val repository: RecipeRepository,
    private @Named("auth_token") val token: String
): ViewModel() {
    val recipes: MutableState<List<Recipe>> = mutableStateOf(listOf())

    val query = mutableStateOf("")

    val selectedCategory: MutableState<FoodCategory?> = mutableStateOf(null)

    var categoryScrollPosition: Float = 0f

    val loading = mutableStateOf(false)

    init {
        newSearch()
    }

    fun newSearch() {
        viewModelScope.launch {
            loading.value = true

            delay(2000)

            val result = repository.search(
                token = token,
                page = 1,
                query = query.value
            )

            recipes.value = result

            loading.value = false

            Log.i("newSearch", "query: $query")
            Log.i("newSearch", "recipe.value: $query")
        }
    }
        fun onQueryChanged(query: String) {
            this.query.value = query
        }
        fun onSelectedCategoryChanged(category: String){
            val newCategory = getFoodCategory(category)
            selectedCategory.value = newCategory
            onQueryChanged(category)
        }
    fun onChangeCategoryScrollPosition(position: Float){
        categoryScrollPosition  = position
    }
    }
