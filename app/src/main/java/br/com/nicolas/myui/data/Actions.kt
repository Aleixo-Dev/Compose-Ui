package br.com.nicolas.myui.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import br.com.nicolas.myui.Suggestions

data class Actions(
    val name: String,
    val icon: ImageVector
)

data class Suggestions(
    val title : String
)

fun provideIconActions() = listOf(
    Actions("Pix", Icons.Filled.MailOutline),
    Actions("Pagar", Icons.Filled.Email),
    Actions("Transferir", Icons.Filled.Send),
    Actions("Depositar", Icons.Filled.Refresh),
    Actions("Cobrar", Icons.Filled.FavoriteBorder),
    Actions("Doação", Icons.Filled.Clear),
    Actions("Investir", Icons.Filled.ThumbUp),
)

fun provideSuggestions() = listOf(
    Suggestions("Ensina: aprenda novas formas de lidar com sua grana."),
    Suggestions("Ensina: aprenda novas formas de lidar com sua grana."),
    Suggestions("Ensina: aprenda novas formas de lidar com sua grana."),
    Suggestions("Ensina: aprenda novas formas de lidar com sua grana."),
    Suggestions("Ensina: aprenda novas formas de lidar com sua grana."),
    Suggestions("Ensina: aprenda novas formas de lidar com sua grana."),
)