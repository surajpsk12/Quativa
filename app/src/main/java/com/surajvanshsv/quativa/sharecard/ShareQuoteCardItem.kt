package com.surajvanshsv.quativa.sharecard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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

private val BgDeep        = Color(0xFF0A0A0F)
private val BgMid         = Color(0xFF12111A)
private val BgCard        = Color(0xFF1A1826)
private val GoldLight     = Color(0xFFE8C96D)
private val GoldDark      = Color(0xFFA8862A)
private val AccentPurple  = Color(0xFF7B5EA7)
private val AccentTeal    = Color(0xFF2DD4BF)
private val TextPrimary   = Color(0xFFF5F0E8)
private val TextSecondary = Color(0xFFB8AFA0)
private val DividerColor  = Color(0xFF2E2A3A)

@Composable
fun ShareQuoteCardItem(
    quote: Quote,
    modifier: Modifier = Modifier,
) {
    val goldBorderGradient = Brush.linearGradient(
        colors = listOf(GoldDark, GoldLight, GoldDark, GoldLight, GoldDark)
    )

    val cardBgGradient = Brush.verticalGradient(
        colors = listOf(BgCard, BgMid, BgDeep)
    )

    Card(
        modifier = modifier
            .fillMaxSize()
            .border(width = 1.dp, brush = goldBorderGradient, shape = RoundedCornerShape(24.dp)),
        shape = RoundedCornerShape(24.dp),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.elevatedCardElevation(32.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(brush = cardBgGradient)
        ) {
            // ── Background decorative canvas ─────────────────────────────
            Canvas(modifier = Modifier.fillMaxSize()) {
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(AccentPurple.copy(alpha = 0.15f), Color.Transparent),
                        center = Offset(size.width * 0.5f, size.height * 0.4f), // Centered glow
                        radius = size.width * 0.8f
                    ),
                    radius = size.width * 0.8f,
                    center = Offset(size.width * 0.5f, size.height * 0.4f)
                )
                // Teal glow bottom
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(AccentTeal.copy(alpha = 0.08f), Color.Transparent),
                        center = Offset(size.width * 0.5f, size.height * 0.9f),
                        radius = size.width * 0.6f
                    ),
                    radius = size.width * 0.6f,
                    center = Offset(size.width * 0.5f, size.height * 0.9f)
                )
            }

            // ── Layout Structure ──────────────────────────────────────────
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 32.dp, vertical = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                // 1. TOP SECTION: Header
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        listOf(Color(0xFFFF5F57), Color(0xFFFFBD2E), Color(0xFF28C840)).forEach {
                            Box(modifier = Modifier
                                .size(12.dp)
                                .clip(CircleShape)
                                .background(it))
                        }
                    }
                    Text(
                        text = "QUATIVA",
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 4.sp,
                        color = GoldLight.copy(alpha = 0.6f)
                    )
                }

                // 2. MIDDLE SECTION: Pushes content to the center
                Spacer(modifier = Modifier.weight(1f))

                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Giant Quote Mark
                    Text(
                        text = "\u201C",
                        fontSize = 120.sp,
                        color = GoldLight.copy(alpha = 0.15f),
                        lineHeight = 0.sp // Pulls text closer
                    )

                    Text(
                        text = quote.body ?: "Inspiration loading...",
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 26.sp,
                        lineHeight = 38.sp,
                        color = TextPrimary,
                        textAlign = TextAlign.Center, // Centered text for 9:16
                        modifier = Modifier.padding(bottom = 24.dp)
                    )

                    // Accent bar under quote
                    Box(
                        modifier = Modifier
                            .width(60.dp)
                            .height(2.dp)
                            .background(
                                Brush.horizontalGradient(listOf(GoldDark, GoldLight)),
                                CircleShape
                            )
                    )

                    Spacer(modifier = Modifier.height(24.dp))

                    Text(
                        text = "— ${quote.author ?: "Unknown"}",
                        fontWeight = FontWeight.Medium,
                        fontSize = 18.sp,
                        color = GoldLight.copy(alpha = 0.8f),
                        letterSpacing = 1.sp
                    )
                }

                // 3. BOTTOM SECTION: Pushes everything up
                Spacer(modifier = Modifier.weight(1.2f))

                // Footer
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .height(0.5.dp)
                            .background(DividerColor)
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = "DAILY DOSE OF WISDOM",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 3.sp,
                        color = TextSecondary.copy(alpha = 0.4f)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0xFF060608)
@Composable
fun ShareQuoteCardItemPreview() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF060608))
            .padding(24.dp),
        contentAlignment = Alignment.Center
    ) {
        ShareQuoteCardItem(
            quote = Quote(
                author = "Marcus Aurelius",
                body = "You have power over your mind, not outside events. Realize this, and you will find strength.",
                id = 1
            ),
            modifier = Modifier.aspectRatio(0.75f)
        )
    }
}