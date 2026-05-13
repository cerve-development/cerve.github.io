package site.cerve

import androidx.compose.foundation.Canvas
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
import androidx.compose.ui.geometry.Offset
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
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundDark)
        ) {
//            IsoDotsBackground(modifier = Modifier.fillMaxSize())
            
            Column(
                modifier = Modifier.fillMaxSize(),
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
}
//
//@Composable
//fun IsoDotsBackground(modifier: Modifier = Modifier) {
//    Canvas(modifier = modifier) {
//        val canvasWidth = size.width
//        val canvasHeight = size.height
//
//        // Prevent crashes during initial layout when size might be NaN or 0
//        if (canvasWidth <= 0f || canvasHeight <= 0f || canvasWidth.isNaN() || canvasHeight.isNaN()) {
//            return@Canvas
//        }
//
//        val spacing = 48.dp.toPx()
//        if (spacing <= 0f) return@Canvas
//
//        val dotRadius = 1.5.dp.toPx()
//        val rowHeight = spacing * 0.866f // sqrt(3)/2
//
//        if (rowHeight <= 0f) return@Canvas
//
//        val rawRows = canvasHeight / rowHeight
//        val rawCols = canvasWidth / spacing
//
//        if (rawRows.isNaN() || rawCols.isNaN() || rawRows.isInfinite() || rawCols.isInfinite()) {
//            return@Canvas
//        }
//
//        val rows = rawRows.toInt().coerceIn(0, 500) + 2
//        val cols = rawCols.toInt().coerceIn(0, 500) + 2
//
//        val dotColor = TextSecondary.copy(alpha = 0.2f)
//
//        for (row in 0 until rows) {
//            for (col in 0 until cols) {
//                // Stagger every other row
//                val offsetX = if (row % 2 == 1) spacing / 2f else 0f
//                val x = col * spacing + offsetX
//                val y = row * rowHeight
//
//                drawCircle(
//                    color = dotColor,
//                    radius = dotRadius,
//                    center = Offset(x, y)
//                )
//            }
//        }
//    }
//}

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
