package org.dboj.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.dboj.jetpackcomposetutorial.model.Message
import org.dboj.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainScreen() }
    }
}

/* Conceptos básicos y primeros pasos? Composables, Modifiers, Previews, etc. */
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
                .background(MaterialTheme.colorScheme.secondary)
                .fillMaxWidth()
                .padding(vertical = 10.dp)
            ) {
                TitleSection()
                Spacer(modifier = Modifier.height(15.dp))
                GetMessages(messages = MESSAGES)
            }
        }
    }
}

@Composable
fun TitleSection() {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)
    ) {
        /* Llamamos a la función composable que hemos creado para mostrar la imagen por pantalla */
        MainScreenImage()
        /* Llamamos a la función composable que hemos creado para mostrar el texto por pantalla */
        Saludo("¡Bienvenidos al tutorial de Jetpack Compose!",
            "¿Preparados para aprender a implementar UI?"
        )
    }
}

@Composable
fun Saludo(title: String = "",
           text: String = "",
           color: Color = MaterialTheme.colorScheme.onBackground,
           style: TextStyle = MaterialTheme.typography.headlineLarge
) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 8.dp)
    ) {
        Text(text = title, color = color, style = style)
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = text, color = color, style = style)
    }
}

@Composable
fun MainScreenImage() {
    Image(painterResource(id = R.drawable.ic_launcher_foreground),
        "Imagen de prueba accediendo al icono de Android por defecto.",
        modifier = Modifier
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

/* Trabajo con scrollables */
@Composable
fun GetMessages(messages: List<Message>) {
    Box {
        LazyColumn(
            modifier = Modifier
                .background(Color.LightGray)
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            if (messages.isNotEmpty()) {
                items(messages) { message ->
                    ShowMessage(message)
                }
            }
        }
    }
}

@Composable
fun ShowMessage(
    message: Message
) {
    BoxWithConstraints {
        Column(
            modifier = Modifier
                .width(maxWidth - 20.dp)
                .padding(8.dp)
        ) {
            Text(text = message.title, style = MaterialTheme.typography.headlineMedium)
            Text(text = message.subject, style = MaterialTheme.typography.headlineSmall)
            if (message.body != null) Text(text = message.body, style = MaterialTheme.typography.bodyMedium)
        }
    }
}

@Preview(name = "Preview Light", showSystemUi = true, showBackground = true)
@Preview(
    name = "Preview Dark",
    showSystemUi = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true)
@Composable
fun DefaultPreview() {
    MainScreen()
}