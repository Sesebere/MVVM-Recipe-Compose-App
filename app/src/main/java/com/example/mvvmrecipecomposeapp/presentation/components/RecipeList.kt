package com.example.mvvmrecipecomposeapp.presentation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.itemsIndexed
import com.example.composeandfragments.presentation.ui.recipe_list.PAGE_SIZE


import android.os.Bundle
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.mvvmrecipecomposeapp.R
import com.example.mvvmrecipecomposeapp.domain.model.Recipe
import com.example.mvvmrecipecomposeapp.presentation.components.util.SnackbarController


@Composable
fun RecipeList(
    loading: Boolean,
    recipes: List<Recipe>,
    onChangeScrollPosition: (Int) -> Unit,
    page: Int,
    onTriggerNextPage: () -> Unit,
    navController: NavController,
    scaffoldState: ScaffoldState,
    snackbarController: SnackbarController,
){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = MaterialTheme.colors.surface)
    )
    {
        LazyColumn {
            itemsIndexed(
                items = recipes
            ) { index, recipe ->
                onChangeScrollPosition(index)
                if((index+1) >= (page * PAGE_SIZE) && !loading){
                    onTriggerNextPage
                }
                RecipeCard(
                    recipe = recipe,
                    onClick = {
                        val bundle = Bundle()
                        bundle.putInt("recipeId", recipe.id!!)
                        navController.navigate(R.id.view_recipe, bundle)
                    })
            }
        }
        CircularIndeterminateProgressBar(isDisplayed = loading)
        DefaultSnackbar(
            snackbarHostState = scaffoldState.snackbarHostState,
            onDismiss = {
                scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
            },
            modifier = Modifier.align(
                Alignment.BottomCenter
            ))
    }
}