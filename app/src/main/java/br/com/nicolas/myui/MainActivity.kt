package br.com.nicolas.myui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.rounded.ShoppingCart
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterStart
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import br.com.nicolas.myui.data.Actions
import br.com.nicolas.myui.data.Suggestions
import br.com.nicolas.myui.data.provideIconActions
import br.com.nicolas.myui.data.provideSuggestions
import br.com.nicolas.myui.ui.theme.MyUiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            this.window.statusBarColor = ContextCompat.getColor(this, R.color.nu)
            MyUiTheme {
                Column(modifier = Modifier.fillMaxSize()) {
                    TopName()
                    Money()
                    MenuIcons(provideIconActions())
                    Spacer(modifier = Modifier.height(20.dp))
                    MyCreditCard()
                    Spacer(modifier = Modifier.height(20.dp))
                    Suggestions(provideSuggestions())
                }
            }
        }
    }
}

@Composable
fun TopName(modifier: Modifier = Modifier) {
    Column(
        modifier
            .fillMaxWidth()
            .height(150.dp)
            .background(Color(0xFF8A05BE))
            .padding(horizontal = 20.dp, vertical = 15.dp)
    ) {
        Row {
            Box(
                modifier
                    .size(50.dp)
                    .clip(RoundedCornerShape(40.dp))
                    .background(Color(0x41FFFFFF))
                    .clickable { }
            ) {
                Icon(
                    imageVector = Icons.Rounded.Person,
                    contentDescription = "",
                    tint = Color.White,
                    modifier = modifier
                        .align(Center)
                        .size(35.dp)
                )
            }
            Spacer(
                modifier
                    .weight(2f)
                    .width(10.dp)
            )
            Icon(
                imageVector = Icons.Rounded.Email,
                contentDescription = "",
                tint = Color.White, modifier = modifier.clickable { }
            )
            Spacer(modifier.width(10.dp))
            Icon(
                imageVector = Icons.Rounded.Settings,
                contentDescription = "",
                tint = Color.White, modifier = modifier.clickable { }
            )
            Spacer(modifier.width(10.dp))
            Icon(
                imageVector = Icons.Rounded.ShoppingCart,
                contentDescription = "",
                tint = Color.White, modifier = modifier.clickable { }
            )
        }
        Spacer(modifier.height(40.dp))
        Text(
            text = "Olá, Nome",
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp
        )
    }
}

@Composable
fun Money(modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(true) }

    Column(
        modifier
            .clickable {
                state = !state
            }
            .padding(horizontal = 20.dp, vertical = 20.dp)) {
        Row(
            modifier
                .fillMaxWidth()
        ) {
            Text(text = "Conta", fontWeight = FontWeight.Bold, fontSize = 20.sp)
            Spacer(modifier = modifier.weight(1f))
            Icon(
                imageVector = Icons.Filled.KeyboardArrowRight,
                contentDescription = "",
                tint = Color.Gray
            )
        }
        Spacer(modifier.height(10.dp))
        Text(
            text = if (state) "R$ 1.334,88" else "*******",
            fontWeight = FontWeight.Bold,
            fontSize = 26.sp
        )
    }
}


@Composable
fun MenuIcons(iconsActions: List<Actions>) {
    LazyRow(contentPadding = PaddingValues(horizontal = 5.dp, vertical = 15.dp)) {
        items(items = iconsActions) { iconsActions ->
            Spacer(modifier = Modifier.size(10.dp))
            IconService(iconsActions = iconsActions)
        }
    }
}

@Composable
fun IconService(
    iconsActions: Actions,
    modifier: Modifier = Modifier
) {
    Column {
        Box(
            modifier
                .size(70.dp)
                .clip(RoundedCornerShape(40.dp))
                .background(Color(0x12000000))
                .clickable { }
        ) {
            Icon(
                imageVector = iconsActions.icon,
                contentDescription = "",
                modifier = modifier
                    .align(
                        Center
                    )
                    .size(25.dp)
            )
        }
        Spacer(modifier = modifier.height(10.dp))
        Text(
            text = iconsActions.name,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 15.sp,
            modifier = modifier.align(CenterHorizontally)
        )
    }
}

@Composable
fun MyCreditCard(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = CenterStart,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp)
            .clip(RoundedCornerShape(10.dp))
            .height(50.dp)
            .background(Color(0x41B4B4B4))
            .clickable { }
    ) {
        Row {
            Spacer(modifier = modifier.padding(horizontal = 5.dp))
            Icon(imageVector = Icons.Rounded.Settings, contentDescription = "")
            Spacer(modifier = modifier.padding(horizontal = 5.dp))
            Text(text = "Meus cartões", fontWeight = FontWeight.Medium)
        }
    }
}

@Composable
fun Suggestions(
    suggestions: List<Suggestions>
) {
    LazyRow(contentPadding = PaddingValues(horizontal = 10.dp)) {
        items(items = suggestions) { suggestions ->
            Spacer(modifier = Modifier.width(10.dp))
            SuggestionsTip(suggestions = suggestions)
        }
    }
}

@Composable
fun SuggestionsTip(
    suggestions: Suggestions
) {
    Box(
        contentAlignment = CenterStart,
        modifier = Modifier
            .width(250.dp)
            .clip(RoundedCornerShape(16.dp))
            .height(100.dp)
            .background(Color(0x41B4B4B4))
            .clickable { }
    ) {
        Text(
            text = suggestions.title,
            Modifier.padding(15.dp),
            maxLines = 2,
        )
    }
}


