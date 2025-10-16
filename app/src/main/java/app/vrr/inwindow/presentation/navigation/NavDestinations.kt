package app.vrr.inwindow.presentation.navigation


import android.graphics.drawable.Icon
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.vector.ImageVector
import app.vrr.inwindow.R

sealed class NavDestinations(val route: String, val title: String,  @DrawableRes val iconRes: Int) {
    data object DashboardTabItem : NavDestinations("dashboard", "Dashboard", R.drawable.ic_house_fill)
    data object CustomerTabItem : NavDestinations("customer", "Customer", R.drawable.ic_teams)
    data object SettingsTabItem : NavDestinations("settings", "Settings", R.drawable.ic_setting)
}