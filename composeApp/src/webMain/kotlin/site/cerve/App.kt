package site.cerve

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cervellc.composeapp.generated.resources.Res
import cervellc.composeapp.generated.resources.CeveNewLogo
import org.jetbrains.compose.resources.painterResource

// Theme Colors
val BrandRed = Color(0xFFFF2A00)
val BrandYellow = Color(0xFFFFB300)
val BackgroundDark = Color(0xFF121212)
val SurfaceDark = Color(0xFF1E1E1E)
val TextPrimary = Color(0xFFFFFFFF)
val TextSecondary = Color(0xFFAAAAAA)

@Composable
fun App() {
    MaterialTheme(
        colorScheme = darkColorScheme(
            background = BackgroundDark,
            surface = SurfaceDark,
            primary = BrandRed,
            onBackground = TextPrimary,
            onSurface = TextPrimary
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundDark),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavBar()
            Spacer(modifier = Modifier.weight(1f))
            HeroSection()
            Spacer(modifier = Modifier.weight(1f))
            Footer()
        }
    }
}

@Composable
fun NavBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 32.dp, vertical = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Logo & Brand Name
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp, ),
        ) {
            Logo(size = 40)
            Text(
                text = "Cerve",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = TextPrimary,
                letterSpacing = 1.sp
            )
        }
    }
}

@Composable
fun NavText(text: String) {
    Text(
        text = text,
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium,
        color = TextSecondary,
        modifier = Modifier.clickable { /* Handle click */ }
    )
}

@Composable
fun Logo(size: Int) {
    Image(
        painter = painterResource(Res.drawable.CeveNewLogo),
        contentDescription = "Cerve Logo",
        modifier = Modifier
            .size(size.dp)
            .clip(CircleShape)
    )
}

@Composable
fun HeroSection() {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(horizontal = 24.dp)
    ) {
        Text(
            text = "Crafting the Future\nof Software",
            fontSize = 64.sp,
            fontWeight = FontWeight.ExtraBold,
            color = TextPrimary,
            textAlign = TextAlign.Center,
            lineHeight = 72.sp
        )

        Text(
            text = "Multiplatform solutions built with speed, elegance, and precision. Experience development without boundaries.",
            fontSize = 20.sp,
            color = TextSecondary,
            textAlign = TextAlign.Center,
            lineHeight = 28.sp,
            modifier = Modifier.widthIn(max = 600.dp)
        )

    }
}

@Composable
fun Footer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(SurfaceDark)
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "© 2026 Cerve LLC. All rights reserved.",
            color = TextSecondary,
            fontSize = 14.sp
        )
    }
}
