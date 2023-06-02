package com.example.mvvmrecipecomposeapp.presentation.components

import android.view.RoundedCorner
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.example.mvvmrecipecomposeapp.R
import com.example.mvvmrecipecomposeapp.domain.model.Recipe
import androidx.compose.material.Text as Text


@Composable
fun RecipeCard(
    recipe: Recipe,
    onClick: () -> Unit
){
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(
                    bottom = 6.dp,
                    top = 6.dp
                )
                .fillMaxWidth(0.9f)
                .clickable(onClick = onClick)
                .align(Alignment.CenterHorizontally),
            elevation = 8.dp
        )
        {
            Column {
                recipe.featuredImage?.let { url ->
                    val painter = rememberImagePainter(
                        data = url,
                        builder = {
                            placeholder(R.drawable.empty_plate)
                        }
                    )
                    Image(
                        painter = painter,
                        contentDescription = "empty plate",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(225.dp),
                        contentScale = ContentScale.Crop

                    )
                }
                recipe.title?.let { title ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 12.dp, bottom = 12.dp, start = 8.dp, end = 8.dp)
                    ) {
                        Text(
                            text = title,
                            modifier = Modifier
                                .fillMaxWidth(0.85f)
                                .wrapContentWidth(Alignment.Start),
                            style = MaterialTheme.typography.h3
                        )
                        Text(
                            text = recipe.rating.toString(),
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentWidth(Alignment.End)
                                .align(Alignment.CenterVertically),
                            style = MaterialTheme.typography.h5
                        )
                    }
                }
            }
        }
    }
}