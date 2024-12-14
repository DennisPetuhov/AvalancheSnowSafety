package com.ass.bulletin.ui

import android.graphics.Color.*
import android.graphics.Paint
import android.graphics.Paint.Align
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.DrawScope
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.ass.core.designsystem.components.icons.AssIcons
import com.ass.core.designsystem.theme.AssBorder
import com.ass.core.designsystem.theme.AssPaddings
import com.ass.core.designsystem.theme.AssShadow
import com.ass.core.designsystem.theme.AssSize
import com.ass.core.designsystem.theme.AssTheme
import com.ass.core.designsystem.R
import kotlin.math.tan

class TriangleShape() : Shape {
    private val angle = 60.0
    private val radians = Math.toRadians(angle / 2)
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            val width = size.width
            val height = size.height
            val centerX = width / 2
            val centerY = 0f
            val aX = centerX
            val aY = centerY
            val bX = centerX - (height / 2.1f * tan(radians)).toFloat()
            val bY = height / 2.1f
            val cX = centerX + (height / 2.1f * tan(radians)).toFloat()
            val cY = bY
            val dX = centerX - (height / 2 * tan(radians)).toFloat()
            val dY = height / 2
            val eX = centerX - (height / 1.35f * tan(radians)).toFloat()
            val eY = height / 1.35f
            val gX = centerX + (height / 1.35f * tan(radians)).toFloat()
            val gY = eY
            val kX = centerX + (height / 2 * tan(radians)).toFloat()
            val kY = height / 2
            val lX = centerX - (height / 1.3f * tan(radians)).toFloat()
            val lY = height / 1.3f
            val oX = centerX + (height / 1.3f * tan(radians)).toFloat()
            val oY = lY
            val mX = centerX - (height * tan(radians)).toFloat()
            val mY = centerY + height
            val nX = centerX + (height * tan(radians)).toFloat()
            val nY = mY

            //upper shape
            moveTo(aX, aY)
            lineTo(bX, bY)
            lineTo(cX, cY)
            close()
            //medium shape
            moveTo(dX, dY)
            lineTo(eX, eY)
            lineTo(gX, gY)
            lineTo(kX, kY)
            close()
            //lower shape
            moveTo(lX, lY)
            lineTo(mX, mY)
            lineTo(nX, nY)
            lineTo(oX, oY)
            close()
        }
        return Outline.Generic(path)
    }

    fun createUpperPiece(size: Size): Path {
        val path = Path().apply {
            val width = size.width
            val height = size.height

            val centerX = width / 2
            val centerY = 0f
            val aX = centerX
            val aY = centerY
            val bX = centerX - (height / 2.1f * tan(radians)).toFloat()
            val bY = height / 2.1f
            val cX = centerX + (height / 2.1f * tan(radians)).toFloat()
            val cY = bY

            moveTo(aX, aY)
            lineTo(bX, bY)
            lineTo(cX, cY)
            close()
        }
        return path
    }

    fun createLowerPiece(size: Size): Path {
        val path = Path().apply {
            val width = size.width
            val height = size.height
            val centerX = width / 2
            val centerY = 0f
            val lX = centerX - (height / 1.3 * tan(radians)).toFloat()
            val lY = height / 1.3f
            val oX = centerX + (height / 1.3f * tan(radians)).toFloat()
            val oY = lY
            val mX = centerX - (height * tan(radians)).toFloat()
            val mY = centerY + height
            val nX = centerX + (height * tan(radians)).toFloat()
            val nY = mY

            moveTo(lX, lY)
            lineTo(mX, mY)
            lineTo(nX, nY)
            lineTo(oX, oY)
            close()
        }
        return path
    }

    fun createMediumPiece(size: Size): Path {
        val path = Path().apply {
            val width = size.width
            val height = size.height

            val centerX = width / 2
            val dX = centerX - (height / 2 * tan(radians)).toFloat()
            val dY = height / 2


            val eX = centerX - (height / 1.35f * tan(radians)).toFloat()
            val eY = height / 1.35f


            val gX = centerX + (height / 1.35f * tan(radians)).toFloat()
            val gY = eY


            val kX = centerX + (height / 2 * tan(radians)).toFloat()
            val kY = height / 2

            moveTo(dX, dY)
            lineTo(eX, eY)
            lineTo(gX, gY)
            lineTo(kX, kY)
            close()
        }
        return path
    }
}

@Composable
fun TriangleOfElevation(
    onIconClick: () -> Unit = {},
    triangleUpperText: String,
    triangleMediumText: String,
    triangleBottomText: String,
    modifier: Modifier = Modifier,

    ) {
    val upperColor = AssTheme.colorScheme.avalancheDangerLevel4
    val mediumColor = AssTheme.colorScheme.avalancheDangerLevel3
    val lowerColor = AssTheme.colorScheme.avalancheDangerLevel2
    Box(
        modifier = modifier.size(AssSize.size150dp),
        contentAlignment = Alignment.Center
    ) {
        val pathColor = AssTheme.colorScheme.primary
        Canvas(modifier = Modifier.size(150.dp)) {
            val shape = TriangleShape()
            val mainPath = shape.createOutline(size, LayoutDirection.Ltr, Density(density))

            drawPath(path = shape.createUpperPiece(size), color = upperColor)
            drawPath(path = shape.createMediumPiece(size), color = mediumColor)
            drawPath(path = shape.createLowerPiece(size), color = lowerColor)
            if (mainPath is Outline.Generic) {
                drawPath(
                    path = mainPath.path,
                    color = pathColor,
                    style = Stroke(width = AssBorder.width1dp.toPx())
                )
            }
            this.printLevelOfDanger(
                upperText = triangleUpperText,
                mediumText = triangleMediumText,
                bottomText = triangleBottomText
            )
        }
        Box(
            modifier = modifier
                .size(AssSize.size150dp)
                .padding(start = AssPaddings.padding120dp, bottom = AssPaddings.padding120dp)
        ) {
            Box(
                modifier = Modifier
                    .size(AssSize.size48dp)
                    .shadow(AssShadow.shadow4dp, shape = CircleShape)
                    .background(color = AssTheme.colorScheme.background, shape = CircleShape)
                    .clickable(onClick = { onIconClick() })
                    .padding(4.dp)
            ) {
                Icon(
                    AssIcons.MoreAboutAvalanche,
                    contentDescription = stringResource(R.string.tree_dots_more_about_avalanche_icon),
                    tint = AssTheme.colorScheme.primary,
                    modifier = Modifier.size(AssSize.size24dp)
                )
            }
        }
    }
}

private fun DrawScope.printLevelOfDanger(
    upperText: String,
    mediumText: String,
    bottomText: String
) {
    drawContext.canvas.nativeCanvas.apply {
        val textPaint = Paint().apply {
            color = BLACK
            textSize = 40f
            textAlign = Align.CENTER
            style = Paint.Style.FILL
            typeface =
                android.graphics.Typeface.create("Roboto Flex", android.graphics.Typeface.BOLD)
        }
        val upperTextX = size.width / 2
        val upperTextY = size.height / 2.6f
        val mediumTextX = size.width / 2
        val mediumTextY = size.height / 1.52f
        val bottomTextX = size.width / 2
        val bottomTextY = size.height / 1.09f
        drawText(upperText, upperTextX, upperTextY, textPaint)
        drawText(mediumText, mediumTextX, mediumTextY, textPaint)
        drawText(bottomText, bottomTextX, bottomTextY, textPaint)
    }
}