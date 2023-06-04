package com.example.mvvmrecipecomposeapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.mvvmrecipecomposeapp.domain.model.Recipe

const val IMAGE_HEIGHT = 260
@Composable
fun RecipeView(
    recipe: Recipe
){
    Column(
        modifier = Modifier.verticalScroll(rememberScrollState())
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
            recipe.featuredImage?.let{ url ->
                val painter = rememberImagePainter(
                    data = url
                )
                Image(
                    painter = painter,
                    contentDescription = "Food Image",
                    modifier = Modifier.fillMaxWidth(0.9f).height(IMAGE_HEIGHT.dp).align(Alignment.CenterHorizontally),
                    contentScale = ContentScale.Crop
                )
            }
        Column(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(8.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            recipe.title?.let { title ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                ){
                    Text(
                        text = title,
                        modifier = Modifier
                            .fillMaxWidth(0.85f)
                            .wrapContentWidth(Alignment.Start)
                        ,
                        style = MaterialTheme.typography.h3
                    )
                    val rank = recipe.rating.toString()
                    Text(
                        text = rank,
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentWidth(Alignment.End)
                            .align(Alignment.CenterVertically)
                        ,
                        style = MaterialTheme.typography.h5
                    )
                }
            }
            recipe.publisher?.let { publisher ->
                val updated = recipe.dateUpdated
                Text(
                    text = if(updated != null) {
                        "Updated ${updated} by ${publisher}"
                    }
                    else {
                        "By ${publisher}"
                    }
                    ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp)
                    ,
                    style = MaterialTheme.typography.caption
                )
            }
            recipe.description?.let { description ->
                if(description != "N/A"){
                    Text(
                        text = description,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp)
                        ,
                        style = MaterialTheme.typography.body1
                    )
                }
            }
            for(ingredient in recipe.ingredients){
                Text(
                    text = ingredient,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 4.dp)
                    ,
                    style = MaterialTheme.typography.body1
                )
            }
        }
    }

}
