package com.example.mvvmrecipecomposeapp.presentation.ui.recipe_list

sealed class RecipeListEvent{
    object NewSearchEvent: RecipeListEvent()
    object NextPageEvent: RecipeListEvent()
    //restore process death
    object RestoreStateEvent: RecipeListEvent()
}