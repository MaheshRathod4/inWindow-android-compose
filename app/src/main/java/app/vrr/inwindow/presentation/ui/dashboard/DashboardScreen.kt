package app.vrr.inwindow.presentation.ui.dashboard

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import app.vrr.inwindow.presentation.viewmodel.CustomerViewModel
import app.vrr.inwindow.presentation.viewmodel.DashboardViewModel


@Composable
fun DashboardScreen(
    viewModel: DashboardViewModel = hiltViewModel(),
    topBar: @Composable () -> Unit = {}
) {
    Scaffold(
        modifier = Modifier.systemBarsPadding(),
        topBar = topBar,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Dashboard Screen",
                textAlign = TextAlign.Center
            )
        }
    }
}
