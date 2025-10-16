package app.vrr.inwindow.presentation.ui.settings

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import app.vrr.inwindow.presentation.viewmodel.SettingsViewModel

@Composable
fun SettingsScreen(
    viewModel: SettingsViewModel = hiltViewModel(),
    topBar: @Composable () -> Unit = {}
) {
    val isDarkThemeEnabled by viewModel.isDarkThemeEnabled
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Settings Screen")
            Switch(
                checked = isDarkThemeEnabled,
                onCheckedChange = { viewModel.toggleDarkTheme(it) },
                modifier = Modifier.padding(16.dp)
            )
            Text(text = if (isDarkThemeEnabled) "Dark Theme On" else "Dark Theme Off")
        }
    }
}