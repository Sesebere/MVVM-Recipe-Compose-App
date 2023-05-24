package com.example.mvvmrecipecomposeapp.presentation.ui.recipe_list

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.composeandfragments.presentation.ui.recipe_list.RecipeListViewModel
import com.example.mvvmrecipecomposeapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        Log.i("RecipeListFragment", "$viewModel")
//        val view = inflater?.inflate(R.layout.fragment_recipe_list, container, false)
//        return view
        return ComposeView(requireContext()).apply{
            setContent{
                Column(modifier = Modifier.padding(16.dp)){
                    Text(
                        text = "Recipe List",
                        style = TextStyle(
                            fontSize = 21.sp,
                            color = Color.Green
                        )
                    )
                    Spacer(modifier = Modifier.padding(10.dp))
                    Button(
                        onClick = {
                            findNavController().navigate(R.id.view_recipe)
                        }
                    ){
                        Text(text = "TO RECIPE FRAGMENT")
                    }

                }
            }
        }
    }
}