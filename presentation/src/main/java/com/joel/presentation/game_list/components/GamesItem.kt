package com.joel.presentation.game_list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImagePainter
import coil.compose.SubcomposeAsyncImage
import coil.compose.SubcomposeAsyncImageContent
import com.joel.domain.model.Games

@Composable
fun GameItem(
    games: Games,
    onItemClick : (Games) -> Unit
){

    val itemWidth = ((LocalConfiguration.current.screenWidthDp - 30).toDouble() / 2).dp


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(horizontal = 1.dp, vertical = 10.dp)
            .wrapContentHeight(),
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .width(itemWidth)
                .height(220.dp),
            contentAlignment = Alignment.Center
        ) {
            Card(
                modifier = Modifier
                    .clickable {
                        onItemClick(games)
                    }
                    .wrapContentSize(),
                shape = RoundedCornerShape(10.dp),
                elevation = 5.dp)
            {
                SubcomposeAsyncImage(
                    model = games.thumbnail,
                    contentDescription = games.title,
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
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xff000000).copy(alpha = 0.30F), RoundedCornerShape(10.dp))
                    .padding(horizontal = 10.dp, vertical = 10.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.Top
                ) {
                    IconButton(
                        modifier = Modifier
                            .background(Color.Transparent, CircleShape)
                            .size(30.dp)
                            .clip(CircleShape),
                        onClick = {

                        }) {

//                        Icon(
//                            modifier = Modifier.size(20.dp),
//                            imageVector = ImageVector.vectorResource(id = if (!games.boolIsFavourite) R.drawable.ic_favourite_outline else R.drawable.ic_favourite_fill),
//                            contentDescription = "Search Icon",
//                            tint = MaterialTheme.colors.primaryVariant
//                        )
                    }
                }
                Text(
                    text = games.title,
                    style = TextStyle(
                        fontFamily = FontFamily.SansSerif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp,
                        color = Color.White
                    )
                )
            }
        }
    }
}

//@Composable
//fun GameImage(
//    thumbnail : String,
//    modifier: Modifier = Modifier
//){
//    Box(
//        contentAlignment = Alignment.TopCenter,
//    ) {
//        Card(
//            elevation = 5.dp,
//            modifier = modifier
//                .fillMaxSize()
//        ) {
//            SubcomposeAsyncImage(
//                model = thumbnail,
//                contentDescription = thumbnail,
//                modifier = modifier
//                    .height(200.dp)
//                    .fillMaxWidth(),
//                contentScale = ContentScale.FillBounds
//            ) {
//                val state = painter.state
//                if (state is AsyncImagePainter.State.Loading || state is AsyncImagePainter.State.Error) {
//                    CircularProgressIndicator()
//                } else {
//                    SubcomposeAsyncImageContent()
//                }
//            }
//        }
//    }
//}
