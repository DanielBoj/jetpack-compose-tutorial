package org.dboj.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.dboj.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class JetpackComposeTutorialApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent { MainScreen() }
    }
}

@Composable
fun MainScreen() {
    /* Indicamos que vamos a usar nuestra implementación del Material Theme */
    JetpackComposeTutorialTheme {
        /* Indicamos que vamos a usar un Surface */
        Surface(
            /* Indicamos que el Surface va a ocupar todo el espacio disponible */
            modifier = Modifier.fillMaxSize(),
            /* Indicamos que el Surface va a usar el color de fondo del Material Theme */
            color = MaterialTheme.colorScheme.background
        ) {
            /* Usamos un Column para que los elementos se muestren uno debajo de otro */
            Column(modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 10.dp)
            ) {
                TitleSection()
            }
        }
    }
}

@Composable
fun TitleSection() {
    Row(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)
    ) {
        /* Llamamos a la función composable que hemos creado para mostrar la imagen por pantalla */
        MainScreenImage()
        /* Llamamos a la función composable que hemos creado para mostrar el texto por pantalla */
        Saludo("¡Bienvenidos al tutorial de Jetpack Compose!",
            "¿Preparados para aprender a implementar UI?")
    }
}

@Composable
fun Saludo(title: String = "",
           text: String = "",
) {
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(start = 8.dp)
    ) {
        Text(text = title)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = text)
    }
}

@Composable
fun MainScreenImage() {
    Image(painterResource(id = R.drawable.ic_launcher_foreground),
        "Imagen de prueba accediendo al icono de Android por defecto.",
        modifier = Modifier
            .height(100.dp)
            .width(100.dp)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}