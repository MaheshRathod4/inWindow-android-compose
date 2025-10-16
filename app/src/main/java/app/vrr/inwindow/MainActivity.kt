package app.vrr.inwindow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import app.vrr.inwindow.presentation.navigation.NavGraph
import app.vrr.inwindow.presentation.ui.theme.InWindowTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            InWindowTheme {
                NavGraph()
            }
        }
    }
}

