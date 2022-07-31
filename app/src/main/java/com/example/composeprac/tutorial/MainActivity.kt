package com.example.composeprac.tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeprac.tutorial.ui.theme.ComposePracTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier
                    .background(Color.Green)
                    .fillMaxHeight(.5f)
                    .fillMaxWidth()
                    .border(5.dp, Color.Magenta)
                    .padding(5.dp)

                    .border(5.dp, Color.Blue)   // 파란 사각형 선의 두께, 색깔
                    .padding(5.dp)  // 파란 사각형 안의 빨간 사각형, 글자들을 안쪽으로 밀어넣는 패딩

                    .border(10.dp, Color.Red)
                    .padding(10.dp)
//                    .requiredWidth(300.dp)
            ) {
                Text("Hello", modifier = Modifier.border(5.dp, Color.Yellow)
                    .padding(5.dp)
                    .offset(20.dp, 20.dp)
                    .border(10.dp, Color.Black)
                    .padding(10.dp))
                Spacer(modifier = Modifier.height(50.dp))
                Text("World")
            }
        }
    }
}