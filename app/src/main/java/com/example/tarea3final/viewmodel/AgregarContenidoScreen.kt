package com.example.tarea3final.viewmodel

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.tarea3final.viewmodel.AppViewModelProvider
import com.example.tarea3final.viewmodel.ContenidoViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AgregarContenidoScreen(
    navController: NavController,
    categoriaId: Int,
    viewModel: ContenidoViewModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val uiState = viewModel.contenidoUiState
    val scope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Agregar Contenido") })
        },
        snackbarHost = { SnackbarHost(snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = uiState.contenidoData.titulo,
                onValueChange = {
                    viewModel.updateUiState(uiState.contenidoData.copy(titulo = it, categoriaId = categoriaId))
                },
                label = { Text("Título") },
                isError = uiState.contenidoData.titulo.isBlank(),
                modifier = Modifier.fillMaxWidth()
            )
            if (uiState.contenidoData.titulo.isBlank()) {
                Text("El título es obligatorio", color = MaterialTheme.colorScheme.error)
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = uiState.contenidoData.tipo,
                onValueChange = {
                    viewModel.updateUiState(uiState.contenidoData.copy(tipo = it, categoriaId = categoriaId))
                },
                label = { Text("Tipo (película, serie, anime)") },
                isError = uiState.contenidoData.tipo.isBlank(),
                modifier = Modifier.fillMaxWidth()
            )
            if (uiState.contenidoData.tipo.isBlank()) {
                Text("El tipo es obligatorio", color = MaterialTheme.colorScheme.error)
            }

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = uiState.contenidoData.descripcion,
                onValueChange = {
                    viewModel.updateUiState(uiState.contenidoData.copy(descripcion = it, categoriaId = categoriaId))
                },
                label = { Text("Descripción") },
                isError = uiState.contenidoData.descripcion.isBlank(),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp),
                maxLines = 4
            )
            if (uiState.contenidoData.descripcion.isBlank()) {
                Text("La descripción es obligatoria", color = MaterialTheme.colorScheme.error)
            }

            Spacer(modifier = Modifier.height(8.dp))



            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (uiState.isEntryValid) {
                        viewModel.saveContenido(categoriaId)

                        scope.launch {
                            snackbarHostState.showSnackbar("Contenido guardado")
                        }
                        navController.popBackStack()
                    } else {
                        scope.launch {
                            snackbarHostState.showSnackbar("Completa todos los campos correctamente")
                        }
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Guardar")
            }
        }
    }
}