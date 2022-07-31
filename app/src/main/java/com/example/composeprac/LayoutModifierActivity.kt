package com.example.composeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class LayoutModifierActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(
                modifier = Modifier.height(200.dp)
                    .fillMaxWidth()
                    .background(Color.Blue)
            )
        }
    }
}

@Composable
fun SamePaddingComponent() {
    // Surface는 Material Design 사양의 "Surface" 메타포 요구를 충족하기 위해 제공되는 Composable이다
    // 배경색 변경, 높이 추가, 배경 모양을 자식 컴포넌트에 추가할 때 사용한다
    // Modifier는 적용된 Composable을 수정하는 데 사용되는 데코레이터 패턴의 구현이다
    // 이 예에서 Composable이 사용자가 지정한 양만큼 x, y 방향을 따라 이동할 수 있게 하는 Modifier.offset을 사용한다
    Surface(color = Color.LightGray) {
        Text(
            text = "상하좌우 모두 16 padding인 텍스트뷰",
            modifier = Modifier.padding(16.dp),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
            )
        )
    }
}

@Composable
fun CustomPaddingComponent() {
    Surface(color = Color.Cyan) {
        Text(
            text = "This text has 32dp start padding, 4dp end padding, 32dp top padding & 0dp bottom padding padding in each direction",
            modifier = Modifier.padding(
                start = 32.dp,
                end = 4.dp,
                top = 32.dp,
                bottom = 0.dp
            ),
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
            )
        )
    }
}

@Composable
fun OffsetComponent() {
    Surface(
        color = Color.Green,
        modifier = Modifier.offset(x = 8.dp, y = 8.dp)
    ) {
        Text(
            text = "This text is using an offset of 8 dp instead of padding. Padding also ends up" +
                    " modifying the size of the layout. Using offset instead ensures that the " +
                    "size of the layout retains its size.",
            style = TextStyle(
                fontSize = 20.sp
            )
        )
    }
}

@Composable
fun AspectRatioComponent() {
    Surface(
        color = Color.LightGray,
        modifier = Modifier.aspectRatio(16 / 9f).padding(top = 16.dp)
    ) {
        Text(
            text = "This text is wrapped in a layout that has a fixed aspect ratio of 16/9",
            style = TextStyle(
                fontSize = 20.sp,
                fontFamily = FontFamily.Serif
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}