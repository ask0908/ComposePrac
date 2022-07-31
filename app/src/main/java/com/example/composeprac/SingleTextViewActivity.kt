package com.example.composeprac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composeprac.ui.theme.ComposePracTheme

class SingleTextViewActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // 이것은 Activity의 루트 보기로 전달된 @Composable 함수를 설정하는 Activity의 확장 함수다
        // 이는 일반적으로 setContent(R.id.xml_file) 메서드를 사용하여 설정하는 .xml 파일을 대체하기 위한 것이다. setContent 블록은 활동의 레이아웃을 정의한다.
        setContent {
            // Column : 자식을 수직 순서로 배치하는 Composable
            // 수직 리니어 레이아웃과 비슷하고 몇 가지 modifier를 전달한다
            // Modifier는 적용된 컴포저블을 수정하는 데 사용되는 데코레이터 패턴의 구현으로 생각할 수 있다
            // 아래 예에서는 Modifier.fillMaxSize()를 사용하여 사용 가능한 전체 높이 및 너비를 차지하도록 열을 구성한다
            Column(
                modifier = Modifier.fillMaxSize(),  // MATCH_PARENT, WRAP_CONTENT를 의미하는 듯
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                /* @Preview가 아닌 onCreate() 안의 문자열을 수정해야 실시간 반영된다 */
                content = {
                    SimpleText("이것은 Compose 튜토리얼")
                }
            )
        }
    }
}

// @Composable 어노테이션으로 Composable 함수를 나타낸다
// Composable 함수는 다른 Composable 함수의 범위 안에서만 호출 가능하다
@Composable
fun SimpleText(displayText: String) {
    // Composable 함수를 레고 블록과 유사하다고 생각해야 합니다. 각 Composable 함수는 차례로 더 작은 Composable 함수로 구성된다
    // Text() 함수는 Compose UI 라이브러리에 의해 미리 정의된다. 해당 함수를 호출해서 앱에서 텍스트 요소를 선언한다
    Text(text = displayText)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SimpleText(displayText = "이것은 Compose 튜토리얼")
}