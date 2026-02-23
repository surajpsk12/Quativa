package com.surajvanshsv.quativa.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun BottomNavigationBar(
    navController: NavController,
) {

    val items = listOf(
        BottomNavigatationItem(
            title = "Home",
            icon = Icons.Default.Home,
            route = "home"
        ),
        BottomNavigatationItem(
            title = "Saved",
            icon = Icons.Default.Favorite,
            route = "saved"
        ),
        BottomNavigatationItem(
            title = "Profile",
            icon = Icons.Default.Person,
            route = "profile"
        )

    )

    val selectionGradient = Brush.linearGradient(
        0.3567f to Color(0x3B40C3FF),
        0.7270f to Color(0x2E0661A8)
    )

    // navbar
    NavigationBar(
        containerColor = Color.Transparent,
        modifier = Modifier.drawBehind {
            val strokeWidth = 1.dp.toPx()
            val y = strokeWidth / 2
            drawLine(
                color = Color(0xFFCBD5DC),
                start = Offset(0f, y),
                end = Offset(size.width, y),
                strokeWidth = strokeWidth
            )
        }

    ) {

        // converting the current nav back stack entry into a state object
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        // getting the route of the current destination
        val currentRoute = navBackStackEntry?.destination?.route

        items.forEach { item ->
            val isSelected = currentRoute == item.route

            NavigationBarItem(
                icon = {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(
                                if (isSelected) selectionGradient else Brush.linearGradient(
                                    listOf(Color.Transparent, Color.Transparent)
                                )
                            )
                            .padding(12.dp)
                    ) {
                        Icon(
                            imageVector = item.icon,
                            contentDescription = item.title,
                            modifier = Modifier.size(42.dp),
                            tint = if (isSelected) Color(0xFF40C3FF) else Color(0xFFF3F3F3)
                        )
                    }
                },
                label = {
                    Text(
                        text = item.title,
                        style = MaterialTheme.typography.labelSmall.copy(
                            fontWeight = if (isSelected) FontWeight.Bold else FontWeight.Medium,
                            fontSize = 11.sp
                        ),
                        color = Color.Transparent
                    )
                },
                selected = isSelected,
                onClick = {
                    navController.navigate(item.route){
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                alwaysShowLabel = false,
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = Color.Unspecified,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = Color.Transparent,
                    unselectedIconColor = Color(0xFF9E9E9E),
                    unselectedTextColor = Color(0xFF9E9E9E),
                )

            )

        }

    }







}





data class BottomNavigatationItem(
    val title: String,
    val icon: ImageVector,
    val route: String,
)


@Preview(showBackground = true)
@Composable
fun BottomNavigationBarPreview(){
    val dummyNavController = NavController(LocalContext.current)
    BottomNavigationBar(navController = dummyNavController)

}