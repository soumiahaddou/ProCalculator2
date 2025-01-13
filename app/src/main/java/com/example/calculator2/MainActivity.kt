package com.example.calculator2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator2.ui.theme.Calculator2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Calculator2Theme {
                val viewModell = viewModel<CalculatorViewModel>()
                val state = viewModell.state
                val buttonSpacing = 8.dp
                Calculator(
                    state = state,
                    onAction = viewModell::onClick,
                    buttonSpacing = buttonSpacing,
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.White)
                        .padding(16.dp)
                )


            }
        }
    }
}

@Composable
fun Calculator(
    state: CalculatorState,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.Symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 32.dp),
                fontSize = 50.sp,
                color = Color.Black,
                maxLines = 1
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    textSize = 36.sp,
                    text = "AC",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    onAction(CalculatorAction.Clear)
                }
                CalculatorButton(
                    textSize = 25.sp,
                    text = "Del",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Delete)
                }
                CalculatorButton(
                    textSize = 36.sp,
                    text = "÷",
                    modifier = Modifier
                        .background(Color(0xFF800080))
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Divide))
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    textSize = 25.sp,
                    text = "7",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(7))
                }
                CalculatorButton(
                    textSize = 25.sp,
                    text = "8",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(8))
                }
                CalculatorButton(
                    textSize = 25.sp,
                    text = "9",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(9))
                }
                CalculatorButton(
                    textSize = 36.sp,
                    text = "×",
                    modifier = Modifier
                        .background(Color(0xFF800080))
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    textSize = 25.sp,
                    text = "4",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(4))
                }
                CalculatorButton(
                    textSize = 25.sp,
                    text = "5",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(5))
                }
                CalculatorButton(
                    textSize = 25.sp,
                    text = "6",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(6))
                }
                CalculatorButton(
                    textSize = 36.sp,
                    text = "-",
                    modifier = Modifier
                        .background(Color(0xFF800080))
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    textSize = 25.sp,
                    text = "1",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(1))
                }
                CalculatorButton(
                    textSize = 25.sp,
                    text = "2",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(2))
                }
                CalculatorButton(
                    textSize = 25.sp,
                    text = "3",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Number(3))
                }
                CalculatorButton(
                    textSize = 36.sp,
                    text = "+",
                    modifier = Modifier
                        .background(Color(0xFF800080))
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                }

            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    textSize = 25.sp,
                    text = "0",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(2f)
                        .weight(2f)
                ) {
                    onAction(CalculatorAction.Number(0))
                }
                CalculatorButton(
                    textSize = 36.sp,
                    text = ".",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Decimal)
                }
                CalculatorButton(
                    textSize = 36.sp,
                    text = "=",
                    modifier = Modifier
                        .background(Color(0xFF800080))
                        .aspectRatio(1f)
                        .weight(1f)
                ) {
                    onAction(CalculatorAction.Calculate)
                }

            }

        }
    }


}

@Composable
fun CalculatorButton(
    textSize: TextUnit,
    text: String,
    modifier: Modifier,
    onClick: () -> Unit
) {

    Box(contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .shadow(30.dp)
            .clickable { onClick() }
            .then(modifier)
    ) {
        Text(
            text = text,
            fontSize = textSize,
            color = Color.White
        )
    }
}


