    package lj.controledepesoepressojetpackcompose.Peso

    import android.widget.NumberPicker
    import android.widget.Toast
    import androidx.compose.foundation.background
    import androidx.compose.foundation.border
    import androidx.compose.foundation.clickable
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.lazy.LazyColumn
    import androidx.compose.foundation.lazy.itemsIndexed
    import androidx.compose.foundation.lazy.rememberLazyListState
    import androidx.compose.material.Button
    import androidx.compose.material.Slider
    import androidx.compose.material.Text
    import androidx.compose.material.TextField
    import androidx.compose.runtime.*
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.res.stringResource
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.unit.sp
    import lj.controledepesoepressojetpackcompose.R

    @Composable
    fun PesoTela (listaPeso:MutableList<PesoModel>) {

     var pesoSlider by remember {
         mutableStateOf(100F)
     }
        val pesoTela = String.format("%.1f kg",pesoSlider)
        val context = LocalContext.current
    val pesoAtualizado by remember {
        mutableStateOf(listaPeso)
    }

            Column(horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .wrapContentSize()
                    .background(color = Color.Yellow)
                    .border(1.dp, color = Color.Black)
            )
            {
                Text(text = stringResource(R.string.Peso), fontSize = 36.sp, fontWeight = FontWeight.ExtraBold,
                    modifier = Modifier.padding(top = 16.dp))
                Spacer(modifier = Modifier.height(16.dp))
                Text(text = pesoTela, fontSize = 48.sp)
                Slider(
                    value = pesoSlider ,
                    onValueChange = {pesoSlider=it},
                    valueRange = 0F..200F,
                )
                Button(onClick = { listaPeso.add(PesoModel(pesoSlider)) },
                    modifier = Modifier.padding(bottom = 16.dp,top =32.dp)) {
                        Text(text = stringResource(android.R.string.ok),fontSize = 16.sp)}
            }
        //Lista com os Pesos salvos
        PesoLista(pesoAtualizado)

            }


    @Composable
    fun PesoLista(pesosListados: MutableList<PesoModel>) {

        val context = LocalContext.current


        Column(modifier = Modifier
            .fillMaxSize()
            .background(Color.Green)
            .padding(4.dp)
            .background(Color.Green)
        ) {

            Row(horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp)
            ) {
                Text(
                    text = stringResource(R.string.Peso),
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                )
            }
            Row {
                LazyColumn(modifier = Modifier.fillMaxSize(),

                    ) {

                    itemsIndexed(pesosListados){
                            index,item->
                        Text(text = "${index+1} - ${String.format(("%.1f kg"), item.peso)}",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .border(1.dp, color = Color.Black)
                                .padding(top = 4.dp, bottom = 4.dp)
                                .clickable {
                                    Toast
                                        .makeText(
                                            context,
                                            "Peso: ${item.peso}", Toast.LENGTH_LONG
                                        )
                                        .show()
                                }
                        )
                    }
                }
            }

        }
    }










    @Preview(showBackground = true)
    @Composable
    fun PesoTelaPreview(){
        val peso1 = PesoModel(100F)
        val peso2 = PesoModel(150F)
        val peso3 = PesoModel(200F)
        val peso4 = PesoModel(400F)

        val listaTeste = mutableListOf( peso1,peso2,peso3,peso4)
        Column() {
            PesoTela(listaTeste)

        }


    }