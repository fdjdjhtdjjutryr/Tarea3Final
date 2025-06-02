package com.example.tarea3final.viewmodel

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tarea3final.viewmodel.ContenidoViewModel
import com.example.tarea3final.viewmodel.AppViewModelProvider
import com.example.tarea3final.data.Contenido

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContenidoScreen(
    categoriaId: Int,
    navController: NavController,
    viewModel: ContenidoViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    // Observa el Flow y convierte a estado Compose
    val contenidos by viewModel.getContenidosPorCategoria(categoriaId).collectAsState(initial = emptyList())

    Scaffold(
        topBar = { TopAppBar(title = { Text("Contenido Categoría $categoriaId") }) },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("agregarContenido/$categoriaId")
            }) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Agregar Contenido")
            }
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            if (contenidos.isEmpty()) {
                Text("No hay contenidos en esta categoría")
            } else {
                contenidos.forEach { contenido ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                            .clickable {
                                navController.navigate("detalleContenido/${contenido.id}")
                            }
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(contenido.titulo, style = MaterialTheme.typography.titleMedium)
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(contenido.descripcion, style = MaterialTheme.typography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}



