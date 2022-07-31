package com.example.composeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AlertDialogActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column {
                ClickableText()
            }
        }
    }
}

@Composable
fun ClickableText() {
    // 상태 변경에 반응하는 것은 Compose의 핵심 동작이다
    // mutableStateOf.remember()는 첫 번째 Compose 중에만 전달된 값을 계산하는 헬퍼 Compose 함수다. 그 다음 모든 후속 Compose에 대해 같은 값을 리턴한다
    // 다음으로 mutableStateOf를 이 변수에 대한 업데이트가 해당 변수에 액세스하는 Composable 함수를 다시 그리는 관찰 가능한 값으로 생각할 수 있다. 명시적으로 구독할 필요가 전혀 없다
    // 값을 읽는 모든 Composable은 값이 바뀔 때마다 재구성된다. 이렇게 하면 이에 의존하는 Composable만 다시 그려지고 나머지는 바뀌지 않는다
    // 이는 효율성을 보장하고 성능을 최적화한다. 리액트 같은 프레임워크에서 영감을 받았다
    var showPopup by remember { mutableStateOf(false) }
    // clickable 수정자가 있는 Column은 하위 구성 가능 요소를 래핑하고 안드로이드에서 익숙한 onClick 리스너와 유사한 onClick 콜백을 통해 클릭에 반응할 수 있게 한다
    // "다이얼로그를 띄우려면 클릭" 텍스트를 누를 때마다 showPopup 값을 true로 바꾼다
    Column(
        Modifier.clickable(
            onClick = { showPopup = true }
        ),
        content = {
            // Modifier는 적용된 컴포저블을 수정하는 데 사용되는 데코레이터 패턴의 구현으로 생각할 수 있다
            // 아래 예에서는 Card 구성 가능에 8dp의 패딩을 추가하고 Text 구성 가능에 16dp의 패딩을 추가한다
            Card(
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.padding(8.dp),
                backgroundColor = Color.LightGray
            ) {
                // Text Composable은 Compose UI 라이브러리에 의해 미리 정의된다. 이 Composable을 써서 화면에 텍스트를 렌더링한다
                Text(
                    text = "다이얼로그를 띄우려면 클릭",
                    modifier = Modifier.padding(16.dp),
                    style = TextStyle(
                        fontSize = 16.sp,
                        fontFamily = FontFamily.Serif
                    )
                )
            }
        })

    // showPopup 값을 해제로 전환하는 람다. AlertDialog의 onDismiss에 해당하는 콜백에 전달
    val onPopupDismissed = { showPopup = false }
    // showPopup 변수가 true로 전환된 경우에만 팝업을 표시하려고 한다
    // Jetpack Compose는 선언적 프로그래밍 방식을 사용하기 때문에 실행 중인 코드 분기에 따라 표시할 항목과 숨김 항목을 쉽게 결정할 수 있다
    // 이 예에서는 showPopup 변수가 true로 설정되거나 이 분기가 전혀 실행되지 않아 경고 대화 상자가 숨겨져 있는 경우에만 AlertDialog를 표시한다
    if (showPopup) {
        AlertDialog(
            onDismissRequest = onPopupDismissed,
            text = {
                Text("축하합니다! 버튼을 클릭해서 다이얼로그가 성공적으로 출력됐어요")
            },
            confirmButton = {
                // 버튼은 미리 정의된 머티리얼 디자인 구현이다 - https://material.io/design/components/buttons.html#contained-button
                Button(
                    onClick = onPopupDismissed
                ) {
                    // Button 컴포저블을 사용하면 이 버튼 기능을 상속하는 자식 컴포저블을 제공할 수 있다
                    // 텍스트 구성 가능은 Compose UI 라이브러리에 의해 미리 정의된다. 이 Composable을 사용하여 화면에 텍스트를 렌더링할 수 있다
                    Text(text = "확인")
                }
            })
    }
}

@Preview(showBackground = true)
@Composable
fun ClickableTextPreview() {
    Column {
        ClickableText()
    }
}