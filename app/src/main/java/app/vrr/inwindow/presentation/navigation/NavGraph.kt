package app.vrr.inwindow.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import app.vrr.inwindow.presentation.navigation.NavDestinations.*
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavDestination
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import app.vrr.inwindow.presentation.ui.customer.CustomerScreen
import app.vrr.inwindow.presentation.ui.dashboard.DashboardScreen
import app.vrr.inwindow.presentation.ui.settings.SettingsScreen

@Composable
fun NavGraph(navController: NavHostController = rememberNavController()) {

    val navItems = listOf(
        DashboardTabItem,
        CustomerTabItem,
        SettingsTabItem
    )

    Scaffold(
        topBar = {
            TopAppBar(navController)
        },
        bottomBar = {
            BottomNavBar(navController, navItems)
        },
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)
            .fillMaxSize()
        ) {
            AppNavGraph(navController)
        }
    }
}

@Composable
fun currentRoute(navController: NavHostController): String? {
    val entry by navController.currentBackStackEntryAsState()
    return entry?.destination?.route
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(navController: NavHostController) {
    val currentRoute = currentRoute(navController)
    TopAppBar(
        title = {
            Text(
                text = when (currentRoute) {
                    DashboardTabItem.route -> "Home"
                    CustomerTabItem.route -> "Profile"
                    SettingsTabItem.route -> "Settings"
                    else -> ""
                }
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
        )
    )
}

@Composable
fun BottomNavBar(
    navController: NavHostController,
    navItems: List<NavDestinations>
) {
    val currentRoute = currentRoute(navController)
    NavigationBar {
        navItems.forEach { destination ->
            NavigationBarItem(
                selected = currentRoute == destination.route,
                onClick = {
                    navController.navigate(destination.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(destination.iconRes),
                        contentDescription = destination.title
                    )
                },
                label = { Text(destination.title) }
            )
        }
    }
}

@Composable
fun AppNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = DashboardTabItem.route) {
        composable(DashboardTabItem.route) { DashboardScreen() }
        composable(CustomerTabItem.route) { CustomerScreen() }
        composable(SettingsTabItem.route) { SettingsScreen() }
    }
}