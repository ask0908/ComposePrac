package com.example.composeprac

import android.os.Bundle
import android.provider.SyncStateContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeprac.ui.theme.ComposePracTheme
import org.intellij.lang.annotations.JdkConstants

// https://github.com/vinaygaba/Learn-Jetpack-Compose-By-Example
class TestActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposePracTheme {
                // A surface container using the 'background' color from the theme
            }
        }
    }
}

@Composable
fun ProductCard(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Image(painter = painterResource(
           id = R.drawable.ic_launcher_foreground),
           contentDescription = null,
           modifier = Modifier
               .size(40.dp)
               .clip(CircleShape)
               .border(1.dp, MaterialTheme.colorScheme.error, CircleShape)
       )
        Text(
            text = "Product Name",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "Product Description",
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 8.sp,
            fontWeight = FontWeight.Medium
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ProductCardPreview() {
    ComposePracTheme {
        HomeScreen()
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(8) {
            ProductCard()
        }
    }
}