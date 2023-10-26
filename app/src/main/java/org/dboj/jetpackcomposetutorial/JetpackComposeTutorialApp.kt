package org.dboj.jetpackcomposetutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import org.dboj.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class JetpackComposeTutorialApp : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
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
                    Column {
                        /* Llamamos a la función composable que hemos creado para mostrar el texto por pantalla */
                        Saludo(text = "¡Bienvenidos al tutorial de Jetpack Compose!")
                        /* Llamamos a la función composable que hemos creado para mostrar la imagen por pantalla */
                        MainScreenImage()
                    }
                }
            }
        }
    }
}

@Composable
fun Saludo(text: String = "") {
    Text(text = text)
}

@Composable
fun MainScreenImage() {
    Image(painterResource(id = R.drawable.ic_launcher_foreground),"Imagen de prueba accediendo al icono de Android por defecto.")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JetpackComposeTutorialTheme {
        /* Indicamos que vamos a usar un Surface */
        Surface(
            /* Indicamos que el Surface va a ocupar todo el espacio disponible */
            modifier = Modifier.fillMaxSize(),
            /* Indicamos que el Surface va a usar el color de fondo del Material Theme */
            color = MaterialTheme.colorScheme.background
        ) {
            /* Usamos un Column para que los elementos se muestren uno debajo de otro */
            Column {
                /* Llamamos a la función composable que hemos creado para mostrar el texto por pantalla */
                Saludo(text = "¡Bienvenidos al tutorial de Jetpack Compose!")
                /* Llamamos a la función composable que hemos creado para mostrar la imagen por pantalla */
                MainScreenImage()
            }
        }
    }
}