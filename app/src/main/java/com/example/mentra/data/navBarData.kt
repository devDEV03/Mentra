package com.example.mentra.data

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mentra.R

data class ModalIconData(
    val title : String,
    val selectedIconModal : ImageVector,
    val unselectedIconModal : ImageVector,
    val navRoute : String
)

data class BookCardData(
    @DrawableRes val photo : Int = 0,
    val name : String,
    val almaMater : String,
    val Designation : String,
)
enum class Screens {
    Home,
    Mentor,
    Booking,
    AboutUs,
    FAQs,
    Contact,
    LoginMentee,
    LoginMentor,
    Details
}

val bookList = listOf(
    BookCardData(
        photo = R.drawable.unique,
        name = "Dev Singhal",
        almaMater = "Galgotias University",
        Designation = "Android Developer at Google"
    ),
    BookCardData(
        photo = R.drawable.unique,
        name = "Dev Singhal",
        almaMater = "Galgotias University",
        Designation = "Android Developer at Google"
    ),
    BookCardData(
        photo = R.drawable.unique,
        name = "Dev Singhal",
        almaMater = "Galgotias University",
        Designation = "Android Developer at Google"
    ),
    BookCardData(
        photo = R.drawable.unique,
        name = "Dev Singhal",
        almaMater = "Galgotias University",
        Designation = "Android Developer at Google"
    ),
    BookCardData(
        photo = R.drawable.unique,
        name = "Dev Singhal",
        almaMater = "Galgotias University",
        Designation = "Android Developer at Google"
    ),
    BookCardData(
        photo = R.drawable.unique,
        name = "Dev Singhal",
        almaMater = "Galgotias University",
        Designation = "Android Developer at Google"
    ),
)

val modalList = listOf(
    ModalIconData(
        title = "Home",
        unselectedIconModal = Icons.Outlined.Home,
        selectedIconModal = Icons.Filled.Home,
        navRoute = Screens.Home.name
    ),
    ModalIconData(
        title = "About Us",
        unselectedIconModal = Icons.Outlined.Face,
        selectedIconModal = Icons.Filled.Face,
        navRoute = Screens.AboutUs.name
    ),
    ModalIconData(
        title = "FAQs",
        unselectedIconModal = Icons.Outlined.Info,
        selectedIconModal = Icons.Filled.Info,
        navRoute = Screens.FAQs.name
    ),
    ModalIconData(
        title = "Contact",
        unselectedIconModal = Icons.Outlined.Call,
        selectedIconModal = Icons.Filled.Call,
        navRoute = Screens.FAQs.name
    ),
    ModalIconData(
        title = "Mentor Login",
        unselectedIconModal = Icons.Outlined.AccountCircle,
        selectedIconModal = Icons.Filled.AccountCircle,
        navRoute = Screens.LoginMentor.name
    )
)