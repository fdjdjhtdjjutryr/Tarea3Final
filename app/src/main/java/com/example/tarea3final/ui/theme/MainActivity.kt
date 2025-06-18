package com.example.tarea3final.ui.theme

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
//import com.example.tarea3final.Tarea3
import com.example.tarea3final.ui.theme.MainScreen
import com.example.tarea3final.viewmodel.AgregarCategoriaScreen
import com.example.tarea3final.viewmodel.AgregarContenidoScreen
//import com.example.tarea3final.viewmodel.AppViewModelProvider
import com.example.tarea3final.viewmodel.CategoriaScreen
import com.example.tarea3final.viewmodel.ContenidoScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MaterialTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "main") {
                        composable("main") {
                            MainScreen(navController)
                        }

                        composable("categorias") {
                            CategoriaScreen(
                                navController = navController,
                                viewModel = viewModel(),
                                onAdd = { navController.navigate("agregarCategoria") }
                            )
                        }

                        composable("agregarCategoria") {
                            AgregarCategoriaScreen(navController = navController)
                        }

                        composable("agregarContenido") {
                            AgregarContenidoScreen(navController = navController, categoriaId = 0)
                        }

                        composable("contenidos") {
                            ContenidoScreen(navController = navController)
                        }

                        composable("agregarContenido/{categoriaId}") { backStackEntry ->
                            val categoriaId = backStackEntry.arguments?.getString("categoriaId")?.toIntOrNull() ?: 0
                            AgregarContenidoScreen(navController = navController, categoriaId = categoriaId)
                        }

                        composable("contenidos/{categoriaId}") { backStackEntry ->
                            val categoriaId = backStackEntry.arguments?.getString("categoriaId")?.toIntOrNull() ?: 0
                            ContenidoScreen(navController = navController)
                        }
                    }
                }
            }
        }
    }
}








//import android.os.Bundle
//import androidx.activity.ComponentActivity
//import androidx.activity.compose.setContent
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Surface
//import androidx.navigation.compose.NavHost
//import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
//import com.example.tarea3final.Tarea3
//import com.example.tarea3final.ui.theme.MainScreen
//import com.example.tarea3final.viewmodel.AgregarCategoriaScreen
//import com.example.tarea3final.viewmodel.AgregarContenidoScreen
//import com.example.tarea3final.viewmodel.AppViewModelProvider
//import com.example.tarea3final.viewmodel.CategoriaScreen
//import com.example.tarea3final.viewmodel.ContenidoScreen
//
//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        // Asignar appContainer para el ViewModelProvider
//        AppViewModelProvider.appContainer = (application as Tarea3).container
//
//        setContent {
//            MaterialTheme {
//                Surface {
//                    val navController = rememberNavController()
//                    NavHost(navController = navController, startDestination = "main") {
//                        composable("main") { MainScreen(navController) }
//                        composable("categoria/{categoriaId}") { backStackEntry ->
//                            val categoriaId = backStackEntry.arguments?.getString("categoriaId")?.toIntOrNull() ?: 0
//                            CategoriaScreen(navController)
//                        }
//                        composable("contenido/{categoriaId}") { backStackEntry ->
//                            val categoriaId = backStackEntry.arguments?.getString("categoriaId")?.toIntOrNull() ?: 0
//                            ContenidoScreen(categoriaId, navController)
//                        }
//                        composable("agregarCategoria") { AgregarCategoriaScreen(navController) }
//
//                        composable("agregar_contenido/{categoriaId}") { backStackEntry ->
//                            val categoriaId = backStackEntry.arguments?.getString("categoriaId")?.toIntOrNull() ?: 0
//                            AgregarContenidoScreen(navController, categoriaId)
//                        }
//
//                        // Por ahora estas dos rutas no implementadas, las agregarás luego:
//                        // composable("agregarContenido/{categoriaId}") { ... }
//                        // composable("detalleContenido/{contenidoId}") { ... }
//                    }
//
//                }
//            }
//        }
//    }
//}