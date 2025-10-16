package app.vrr.inwindow.presentation.ui.customer

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
import app.vrr.inwindow.presentation.viewmodel.CustomerViewModel
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun CustomerScreen(
    viewModel: CustomerViewModel = hiltViewModel(),
    topBar: @Composable () -> Unit = {}
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Customer Screen",
            textAlign = TextAlign.Center
        )
    }
}