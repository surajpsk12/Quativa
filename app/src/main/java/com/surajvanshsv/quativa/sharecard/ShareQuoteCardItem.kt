package com.surajvanshsv.quativa.sharecard

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surajvanshsv.quativa.model.Quote

@Composable
fun ShareQuoteCardItem(
    quote: Quote,
    modifier: Modifier,
) {
    // Subtle shimmer border gradient
    val borderGradient = Brush.verticalGradient(
        0.0f to Color(0xFF80919C),
        1.0f to Color(0xFFCAD2DA)
    )

    // Card background gradient (unchanged colors)
    val cardGradient = Brush.verticalGradient(
        colors = listOf(
            Color(0xFF000000),
            Color(0xFF1A3A56),
            Color(0xFF305478)
        )
    )

    // Accent dot colors
    val dotColors = listOf(Color.Red, Color.Yellow, Color.Green)

    Card(
        modifier = modifier
            .fillMaxSize()
            .border(
                width = 1.dp,
                brush = borderGradient,
                shape = RoundedCornerShape(20.dp)
            ),
        shape = RoundedCornerShape(20.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.elevatedCardElevation(24.dp)
    ) {
        Box(
            modifier = Modifier.fillMaxSize()
                .background(brush = cardGradient)
                .padding(horizontal = 32.dp, vertical = 36.dp),
            contentAlignment = Alignment.Center
        ) {

            // Subtle radial glow at center-top for depth
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .align(Alignment.TopCenter)
                    .background(
                        brush = Brush.radialGradient(
                            colors = listOf(
                                Color(0xFF305478).copy(alpha = 0.45f),
                                Color.Transparent
                            ),
                            radius = 400f
                        )
                    )
            )

            Column(
                modifier = Modifier.fillMaxWidth()
            ) {

                // ── Decorative dots ──────────────────────────────────────
                Row(
                    modifier = Modifier.padding(start = 4.dp, bottom = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    dotColors.forEach { color ->
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .background(color, shape = RoundedCornerShape(50))
                                .drawBehind {
                                    drawCircle(
                                        color = color.copy(alpha = 0.35f),
                                        radius = 14f,
                                        center = Offset(size.width / 2, size.height / 2)
                                    )
                                }
                        )
                        Spacer(modifier = Modifier.width(6.dp))
                    }
                }

                Spacer(modifier = Modifier.height(12.dp))

                // ── Opening decorative quotation mark ────────────────────
                Text(
                    text = "\u201C",
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF305478).copy(alpha = 0.7f),
                    lineHeight = 56.sp,
                    modifier = Modifier
                        .padding(start = 8.dp)
                        .offset(y = 8.dp)
                )

                // ── Quote body ───────────────────────────────────────────
                Text(
                    text = quote.body ?: "Loading today\u2019s inspiration\u2026",
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 22.sp,
                    lineHeight = 34.sp,
                    color = Color.White,
                    maxLines = 6,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                )

                // ── Closing quotation mark ───────────────────────────────
                Text(
                    text = "\u201D",
                    fontSize = 80.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFF305478).copy(alpha = 0.7f),
                    lineHeight = 56.sp,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                        .offset(y = (-8).dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                // ── Thin divider ─────────────────────────────────────────
                Box(
                    modifier = Modifier
                        .fillMaxWidth(0.55f)
                        .height(1.dp)
                        .align(Alignment.End)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(
                                    Color.Transparent,
                                    Color(0xFFE6EA67).copy(alpha = 0.5f)
                                )
                            )
                        )
                )

                Spacer(modifier = Modifier.height(10.dp))

                // ── Author ───────────────────────────────────────────────
                Text(
                    text = "\u2014 ${quote.author}",
                    fontWeight = FontWeight.SemiBold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 15.sp,
                    color = Color(0xFFE6EA67).copy(alpha = 0.85f),
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 8.dp)
                )

                Spacer(modifier = Modifier.height(32.dp))

                // ── Footer ───────────────────────────────────────────────
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    // Small accent line
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(0.5.dp)
                            .background(Color.White.copy(alpha = 0.12f))
                    )
                    Text(
                        text = "  Shared via Quativa  ",
                        fontSize = 11.sp,
                        letterSpacing = 1.8.sp,
                        color = Color.White.copy(alpha = 0.75f),
                    )
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(0.5.dp)
                            .background(Color.White.copy(alpha = 0.12f))
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF101010)
@Composable
fun ShareQuoteCardItemPreview() {
    ShareQuoteCardItem(
        quote = Quote(
            author = "Suraj",
            body = "This is a quote which is very long and it is just so long that it wraps around nicely.",
            id = 1
        ),
        modifier = Modifier
    )
}