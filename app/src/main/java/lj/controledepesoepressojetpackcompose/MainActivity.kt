package lj.controledepesoepressojetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import lj.controledepesoepressojetpackcompose.Peso.PesoModel
import lj.controledepesoepressojetpackcompose.Peso.PesoTela
import lj.controledepesoepressojetpackcompose.ui.theme.ControleDePesoEPressãoJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ControleDePesoEPressãoJetpackComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val peso1 = PesoModel(100F)
                    val peso2 = PesoModel(150F)
                    val peso3 = PesoModel(200F)
                    val peso4 = PesoModel(400F)

                    val listaTeste:MutableList<PesoModel> = mutableListOf(peso1, peso2, peso3, peso4)

                    Column() {
                        PesoTela(listaPeso = listaTeste)
                    }

                }
            }
        }

    }
}



