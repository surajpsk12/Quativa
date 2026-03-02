package com.surajvanshsv.quativa.sharecard

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surajvanshsv.quativa.model.Quote

// ── Theme Colors ─────────────────────────────────────────────────────────────
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
                // Soft purple glow top-left
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(AccentPurple.copy(alpha = 0.18f), Color.Transparent),
                        center = Offset(size.width * 0.1f, size.height * 0.12f),
                        radius = size.width * 0.55f
                    ),
                    radius = size.width * 0.55f,
                    center = Offset(size.width * 0.1f, size.height * 0.12f)
                )
                // Teal glow bottom-right
                drawCircle(
                    brush = Brush.radialGradient(
                        colors = listOf(AccentTeal.copy(alpha = 0.10f), Color.Transparent),
                        center = Offset(size.width * 0.85f, size.height * 0.82f),
                        radius = size.width * 0.45f
                    ),
                    radius = size.width * 0.45f,
                    center = Offset(size.width * 0.85f, size.height * 0.82f)
                )
                // Top gold streak
                drawLine(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.Transparent, GoldLight.copy(alpha = 0.35f), Color.Transparent)
                    ),
                    start = Offset(size.width * 0.1f, size.height * 0.01f),
                    end = Offset(size.width * 0.9f, size.height * 0.01f),
                    strokeWidth = 1.2f,
                    cap = StrokeCap.Round
                )
                // Bottom gold streak
                drawLine(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.Transparent, GoldLight.copy(alpha = 0.25f), Color.Transparent)
                    ),
                    start = Offset(size.width * 0.1f, size.height * 0.99f),
                    end = Offset(size.width * 0.9f, size.height * 0.99f),
                    strokeWidth = 1.2f,
                    cap = StrokeCap.Round
                )
            }

            // ── Main content ──────────────────────────────────────────────
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 28.dp, vertical = 30.dp)
            ) {

                // ── Header row: dots + top label ──────────────────────────
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(horizontalArrangement = Arrangement.spacedBy(7.dp)) {
                        listOf(
                            Color(0xFFFF5F57),
                            Color(0xFFFFBD2E),
                            Color(0xFF28C840)
                        ).forEach { dotColor ->
                            Box(
                                modifier = Modifier
                                    .size(11.dp)
                                    .clip(CircleShape)
                                    .background(dotColor)
                                    .border(0.5.dp, dotColor.copy(alpha = 0.6f), CircleShape)
                            )
                        }
                    }
                    Text(
                        text = "QUATIVA",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 3.sp,
                        color = GoldLight.copy(alpha = 0.5f)
                    )
                }

                Spacer(modifier = Modifier.height(28.dp))

                // ── Gold accent bar ───────────────────────────────────────
                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(2.dp)
                        .background(
                            brush = Brush.horizontalGradient(listOf(GoldDark, GoldLight)),
                            shape = RoundedCornerShape(50)
                        )
                )

                Spacer(modifier = Modifier.height(20.dp))

                // ── Giant ghost open-quote ────────────────────────────────
                Text(
                    text = "\u201C",
                    fontSize = 100.sp,
                    fontWeight = FontWeight.Black,
                    color = GoldLight.copy(alpha = 0.10f),
                    lineHeight = 60.sp,
                    modifier = Modifier
                        .offset(x = (-8).dp, y = 10.dp)
                        .height(52.dp)
                )

                Spacer(modifier = Modifier.height(8.dp))

                // ── Quote body ────────────────────────────────────────────
                Text(
                    text = quote.body ?: "Loading today\u2019s inspiration\u2026",
                    fontWeight = FontWeight.Medium,
                    fontStyle = FontStyle.Italic,
                    fontSize = 21.sp,
                    lineHeight = 34.sp,
                    color = TextPrimary,
                    maxLines = 7,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 4.dp)
                )

                Spacer(modifier = Modifier.height(20.dp))

                // ── Author ────────────────────────────────────────────────
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .width(20.dp)
                            .height(2.dp)
                            .background(
                                brush = Brush.horizontalGradient(listOf(GoldDark, GoldLight)),
                                shape = RoundedCornerShape(50)
                            )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = quote.author ?: "Unknown",
                        fontWeight = FontWeight.SemiBold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 14.sp,
                        color = GoldLight.copy(alpha = 0.9f),
                        letterSpacing = 0.5.sp
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                // ── Divider ───────────────────────────────────────────────
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(0.5.dp)
                        .background(
                            brush = Brush.horizontalGradient(
                                colors = listOf(Color.Transparent, DividerColor, DividerColor, Color.Transparent)
                            )
                        )
                )

                Spacer(modifier = Modifier.height(16.dp))

                // ── Footer ────────────────────────────────────────────────
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(text = "\u25C6", fontSize = 7.sp, color = GoldLight.copy(alpha = 0.6f))
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = "SHARED VIA QUATIVA",
                        fontSize = 9.sp,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 2.5.sp,
                        color = TextSecondary.copy(alpha = 0.55f)
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = "\u25C6", fontSize = 7.sp, color = GoldLight.copy(alpha = 0.6f))
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