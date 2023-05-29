package com.example.mvvmrecipecomposeapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.example.mvvmrecipecomposeapp.presentation.ui.recipe_list.FoodCategory
import com.example.mvvmrecipecomposeapp.presentation.ui.recipe_list.getAllFoodCategories

@Composable
fun SearchAppBar(
    query: String,
    onQueryChanged: (String) -> Unit,
    onExecuteSearch: () -> Unit,
    selectedCategory: FoodCategory?,
    onSelectedCategoryChanged:(String) -> Unit,
    onToggleTheme: () -> Unit
){
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colors.surface,
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
                        onQueryChanged(newValue)
                        onExecuteSearch()
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
                ConstraintLayout(
                    modifier = Modifier.align(Alignment.CenterVertically)
                ) {
                    val (iconButton) = createRefs()
                    IconButton(
                        onClick = onToggleTheme,
                        modifier = Modifier.constrainAs(iconButton){
                            end.linkTo(parent.end)
                            top.linkTo(parent.top)
                            bottom.linkTo(parent.bottom)
                        }
                    ){
                        Icon(Icons.Filled.MoreVert, contentDescription = null)
                    }
                }
            }
            val scrollState = rememberScrollState()
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, bottom = 8.dp),
            )
            {
                val foodCategories = getAllFoodCategories()
                items(foodCategories)
                {category ->
                    FoodCategoryChip(
                        category = category.value,
                        isSelected = selectedCategory == category,
                        onSelectedCategoryChanged = {onSelectedCategoryChanged(it)},
                        onExecuteSearch = {
                            onExecuteSearch()
                        }
                    )
                }
            }
        }//random comment
    }
}