package com.example.tarea3final.viewmodel

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tarea3final.data.Contenido

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ContenidoScreen(
    categoriaId: Int,
    navController: NavController,
    viewModel: ContenidoViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    LaunchedEffect(Unit) {
        viewModel.cargarContenidosIniciales()
    }
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
                    ContenidoItem(
                        contenido = contenido,
                        onClick = {
                            navController.navigate("detalleContenido/${contenido.id}")
                        },
                        onDelete = {
                            viewModel.deleteContenido(contenido)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun ContenidoItem(
    contenido: Contenido,
    onClick: () -> Unit,
    onDelete: () -> Unit
) {
    val context = LocalContext.current
    val imageResId = remember(contenido.imagen) {
        context.resources.getIdentifier(contenido.imagen, "drawable", context.packageName)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable { onClick() }
    ) {
        Row(modifier = Modifier.padding(16.dp)) {
            if (imageResId != 0) {
                Image(
                    painter = painterResource(id = imageResId),
                    contentDescription = contenido.titulo,
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
            Column(modifier = Modifier.weight(1f)) {
                Text(contenido.titulo, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(contenido.descripcion, style = MaterialTheme.typography.bodySmall)
            }
            IconButton(onClick = onDelete) {
                Icon(Icons.Default.Delete, contentDescription = "Eliminar contenido")
            }
        }
    }
}

