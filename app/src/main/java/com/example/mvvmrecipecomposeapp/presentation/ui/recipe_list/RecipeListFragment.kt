package com.example.mvvmrecipecomposeapp.presentation.ui.recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.composeandfragments.presentation.ui.recipe_list.RecipeListViewModel
import com.example.mvvmrecipecomposeapp.R
import com.example.mvvmrecipecomposeapp.presentation.components.FoodCategoryChip
import com.example.mvvmrecipecomposeapp.presentation.components.RecipeCard
import com.example.mvvmrecipecomposeapp.util.TAG

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        val view = inflater?.inflate(R.layout.fragment_recipe_list, container, false)
//        return view
        return ComposeView(requireContext()).apply{
            setContent{
                val recipes = viewModel.recipes.value
                val query = viewModel.query.value
                val selectedCategory = viewModel.selectedCategory.value
                Column{
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth(),
                        color = Color.White,
                        elevation = 8.dp
                    ) {
                        Column{
                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TextField(
                                modifier = Modifier
                                    .fillMaxWidth(0.9f)
                                    .padding(8.dp)
                                    .background(MaterialTheme.colors.surface),
                                value = query,
                                onValueChange = { newValue ->
                                    viewModel.onQueryChanged(newValue)
                                    viewModel.newSearch()
                                },
                                label = {
                                    Text(text = "Search")
                                },
                                keyboardOptions = KeyboardOptions(
                                    keyboardType = KeyboardType.Text,
                                    imeAction = ImeAction.Search
                                ),
                                leadingIcon = {
                                    Icon(Icons.Filled.Search, contentDescription = "Search Icon")
                                },
                                textStyle = TextStyle(color = MaterialTheme.colors.onSurface),

//                                onImeActionPerformed = { imeAction, controller ->
//                                    if(imeAction == ImeAction.Search){
//                                        viewModel.newSearch(query)
//                                        controller?.hideSoftwareKeyboard()
//                                    }
//                                }
                            )
                        }
                        LazyRow(
                            modifier = Modifier.fillMaxWidth().padding(start = 8.dp, bottom = 8.dp)
                        )
                        {
                            val foodCategories = getAllFoodCategories()
                            items(foodCategories)
                            {category ->
                                FoodCategoryChip(
                                    category = category.value,
                                    isSelected = selectedCategory == category,
                                    onSelectedCategoryChanged = {viewModel.onSelectedCategoryChanged(it)},
                                    onExecuteSearch = viewModel::newSearch
                                )
                            }
                        }
                    }//random comment
                    }
                    LazyColumn{
                        itemsIndexed(
                            items = recipes
                        ){ index, recipe ->
                            RecipeCard(recipe = recipe, onClick = {})
                        }
                    }
                }

                }
            }
        }
    }
