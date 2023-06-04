package com.example.mvvmrecipecomposeapp.presentation.ui.recipe_list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.*
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.example.composeandfragments.presentation.ui.recipe_list.RecipeListViewModel
import com.example.mvvmrecipecomposeapp.presentation.BaseApplication
import com.example.mvvmrecipecomposeapp.presentation.components.*
import com.example.mvvmrecipecomposeapp.presentation.components.util.SnackbarController
import com.example.mvvmrecipecomposeapp.presentation.theme.AppTheme

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RecipeListFragment : Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private val snackbarController = SnackbarController(lifecycleScope)

    private val viewModel: RecipeListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

//        val view = inflater?.inflate(R.layout.fragment_recipe_list, container, false)
//        return view
        return ComposeView(requireContext()).apply {
            setContent {

                AppTheme(
                    darkTheme = application.isDark.value
                ) {
                    val recipes = viewModel.recipes.value
                    val query = viewModel.query.value
                    val selectedCategory = viewModel.selectedCategory.value
                    val loading = viewModel.loading.value
                    val page = viewModel.page.value
                    val scaffoldState = rememberScaffoldState()

                    Scaffold(
                        topBar = {
                            SearchAppBar(
                                query = query,
                                onQueryChanged = viewModel::onQueryChanged,
                                onExecuteSearch = {
                                    if(viewModel.selectedCategory.value?.value == "Milk"){
                                        snackbarController.getScope().launch{
                                            snackbarController.showSnackbar(
                                                    scaffoldState = scaffoldState,
                                                    message = "Invalid category: MILK!",
                                                    actionLabel = "Hide"
                                                )
                                        }
                                    }
                                    else{
                                        viewModel.onTriggerEvent(RecipeListEvent.NewSearchEvent)
                                    }
                                                  },
                                selectedCategory = selectedCategory,
                                onSelectedCategoryChanged = viewModel::onSelectedCategoryChanged,
                                onToggleTheme = { application.toggleLightTheme() }
                            )
                        },
                        bottomBar = {

                        },
                        drawerContent = {

                        },
                        scaffoldState = scaffoldState,
                        snackbarHost = {
                            scaffoldState.snackbarHostState
                        }
                    ) { contentPadding ->
                        RecipeList(
                            loading = loading,
                            recipes = recipes,
                            onChangeScrollPosition = viewModel::onChangeRecipeScrollPosition,
                            page = page,
                            onTriggerNextPage = {viewModel.onTriggerEvent(RecipeListEvent.NextPageEvent)},
                            navController = findNavController(),
                            scaffoldState = scaffoldState,
                            snackbarController = snackbarController,
                        )
                    }
                }

            }
        }
    }
}

