package com.joel.presentation.games_details.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import coil.compose.rememberImagePainter
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import kotlin.math.max
import kotlin.math.min
import com.joel.presentation.R

val AppBarCollapsedHeight = 50.dp
val AppBarExpendedHeight = 420.dp

@Composable
fun GameImageBanner(
    scrollState : LazyListState,
    onBackPressed : () -> Unit,
    gameName : String,
    gameStatus : String,
    gameUrl : String
){

    val imageHeight = AppBarExpendedHeight - AppBarCollapsedHeight

    val maxOffset = with(LocalDensity.current) {
        imageHeight.roundToPx()
    } - LocalWindowInsets.current.systemBars.layoutInsets.top

    val offset = min(scrollState.firstVisibleItemScrollOffset, maxOffset)

    val offsetProgress = max(0f, offset * 3f - 2f * maxOffset) / maxOffset

    TopAppBar(
        contentPadding = PaddingValues(),
        backgroundColor = MaterialTheme.colors.onPrimary,
        modifier = androidx.compose.ui.Modifier
            .height(
                AppBarExpendedHeight
            )
            .offset { IntOffset(x = 0, y = -offset) },
        elevation = if (offset == maxOffset) 4.dp else 0.dp
    ) {
        Column {
            Box {
                SubcomposeAsyncImage(
                    model = gameUrl,
                    contentDescription = gameName,
                    modifier = Modifier
                        .fillMaxSize(),
                    contentScale = ContentScale.FillBounds
                ) {
                    val state = painter.state
                    if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .scale(0.5f)
                        )
                    } else {
                        SubcomposeAsyncImageContent()
                    }
                }
//                Image(
//                    painter = rememberImagePainter(
//                        data = gameUrl,
//                        builder = {
//                            placeholder(R.drawable.baseline_videogame_asset_24)
//                            crossfade(true)
//                        }
//                    ),
//                    modifier = Modifier
//                        .fillMaxSize()
//                        .height(imageHeight)
//                        .graphicsLayer {
//                            alpha = 1f - offsetProgress
//                        },
//                    contentScale = ContentScale.Crop,
//                    contentDescription = "Movie Banner"
//                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                colorStops = arrayOf(
                                    Pair(0.3f, Transparent),
                                    Pair(1.5f, MaterialTheme.colors.onPrimary)
                                )
                            )
                        )
                )
                GameNameAndStatus(
                    gameName = gameName,
                    gameStatus = gameStatus
                )
            }
        }
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .statusBarsPadding()
            .padding(horizontal = 10.dp)
    ) {
        CircularBackButton( onBackPressed )
    }

}