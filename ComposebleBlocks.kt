package com.example.mycomposeandroidapp

import android.os.Build
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Calculator(val charList : MutableList<Char>){
    @Composable
    fun MainPage(){
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.DarkGray
        ) {
            Column(modifier = Modifier
                .fillMaxSize()){
                val calculator = Calculator(charList = charList)
                calculator.TopBar(name = "Ron")
                calculator.DisplayField()
                calculator.CalculatorBody()
            }
        }


    }

    @Composable
        fun TopBar(name:String){
            Surface(
                modifier = Modifier.wrapContentSize(align = Alignment.TopStart)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(30.dp)
                        .background(Color.Blue),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(
                        textAlign = TextAlign.Center,
                        text = "Hello $name and welcome",
                        color = Color.White
                    )

                }
            }
        }

        @Composable
        fun DisplayField(){
            Surface(
                modifier = Modifier
                    .height(140.dp)
                    .fillMaxWidth()
                    .padding(top = 20.dp, bottom = 30.dp),
                color = Color.Black
            ) {
                Row(
                    modifier = Modifier.wrapContentSize(
                        align = Alignment.BottomStart
                    )
                ){

                    for(char in charList){
                        Text(text = char.toString(),
                            color = Color.White,
                            textAlign = TextAlign.Left,
                            fontSize = 45.sp)
                    }

                }

            }
        }
        @Composable
        fun CalculatorBody(){
            val firstRow:MutableList<Char> = mutableListOf('(',')','%','/')
            val secondRow:MutableList<Char> = mutableListOf('1','2','3','+')
            val thirdRow:MutableList<Char> = mutableListOf('4','5','6','-')
            val forthRow:MutableList<Char> = mutableListOf('7','8','9','*')
            val fifthRow:MutableList<Char> = mutableListOf('C','0','.','=')
            Surface(
                modifier = Modifier
                    .wrapContentSize(
                        align = Alignment.BottomCenter
                    )
                    .padding(
                        top = 40.dp, start = 10.dp, end = 10.dp, bottom = 10.dp
                    )
                    .fillMaxSize()
            ) {
                Column(
                    modifier = Modifier
                        .height(420.dp)
                        .width(350.dp)
                        .border(width = 5.dp, color = Color.Black)
                        .background(Color.Gray),
                    verticalArrangement = Arrangement.SpaceEvenly


                ) {
                   CalculatorRow(symbols = firstRow )
                   CalculatorRow(symbols = secondRow)
                   CalculatorRow(symbols = thirdRow)
                   CalculatorRow(symbols = forthRow)
                   CalculatorRow(symbols = fifthRow)


                }

            }
        }
        @Composable
        fun CalculatorRow(symbols:MutableList<Char>){
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly,
            ){
                for(symbol in symbols) {
                    CalculatorButton(symbol = symbol)
                }
            }
        }
        @Composable
        fun CalculatorButton(symbol:Char){
            Button(onClick = {if(symbol.isDigit())charList.add(symbol)
            else if (symbol == 'C') charList.clear() else if (symbol == '=') if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                charList.replaceAll { x -> '2' }
            }
            }  ,
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .size(88.dp)

            ) {
                Text(text = symbol.toString(),
                    fontWeight = FontWeight.ExtraBold,
                    fontStyle = FontStyle.Normal,
                    fontSize = 50.sp
                )

            }
        }
        fun calculate(expression: List<Char> ): Char{
            return '3'

        }
}
