package com.example.myapp6969

import android.icu.text.ListFormatter.Width
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.example.myapp6969.ui.theme.Purple80
import com.example.myapp6969.ui.theme.heroGradient1
import com.example.myapp6969.ui.theme.heroGradient2
import com.example.myapp6969.ui.theme.heroGradient3
import com.example.myapp6969.ui.theme.heroGradient4
import com.example.myapp6969.ui.theme.mulishFontFamily
import com.example.myapp6969.ui.theme.myBlack
import com.example.myapp6969.ui.theme.myBlue
import com.example.myapp6969.ui.theme.myGrey
import com.example.myapp6969.ui.theme.myPurple
import com.example.myapp6969.ui.theme.myWhite
import kotlinx.coroutines.delay

@Composable
fun HomeScreen(){
    Column {
            SearchSection()
            HeroSection()
            CategorySection()
            ExclusiveSection()
    }
}



// -------SEARCH SECTION--------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchSection(){
    var themeBtnId by remember { mutableStateOf(R.drawable.moon_icon) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 30.dp)
            .padding(20.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        var txt by remember { mutableStateOf("") }

        OutlinedTextField(
            modifier = Modifier.width(250.dp),
            value = txt,
            onValueChange = { txt = it },
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.search), contentDescription = "Search", tint = myBlack)
            },
            shape = RoundedCornerShape(20.dp),
            singleLine = true,
            placeholder = {
                Text(text = "Search products ...",
                    color = myGrey,
                    fontFamily = mulishFontFamily,
                    fontWeight = FontWeight.Medium)
            },
            colors = TextFieldDefaults.colors(
            cursorColor = Purple80,
                focusedIndicatorColor = Color.LightGray,
                unfocusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.White,
                unfocusedContainerColor = myWhite
            )
        )

        CustomBtns(imgId = R.drawable.shopping_cart_icon)
        IconButton(onClick = {
            if (themeBtnId == R.drawable.moon_icon) {
                themeBtnId = R.drawable.sun_icon
            } else {
                themeBtnId = R.drawable.moon_icon
            }
        }
        ){
            Icon(painter = painterResource(id = themeBtnId), contentDescription ="",
                modifier = Modifier.then(Modifier.size(30.dp)), tint = myBlack)
        }
    }
}

@Composable
fun CustomBtns(imgId: Int){
    IconButton(onClick = { /*TODO*/ }) {
        Icon(painter = painterResource(id = imgId), contentDescription ="",
            modifier = Modifier.then(Modifier.size(30.dp)), tint = myBlack)
    }
}


//---------HERO SECTION---------
@Composable
fun HeroSection(){
    LazyRow {
        item {
            HeroCard(heroHeader = "Explore Electronics", heroSub = "Exchange for what you want", heroBtn = "Exchange Now", heroImg = R.drawable.gaming_cpu, bgColor = heroGradient1)
            HeroCard(heroHeader = "Get upto 60% off", heroSub = "on your first order", heroBtn = "Shop Now", heroImg = R.drawable.gmonitor, bgColor = heroGradient2)
            HeroCard(heroHeader = "The beast RTX40", heroSub = "the power of ray tracing", heroBtn = "Goto GPU", heroImg = R.drawable.gpu, bgColor = heroGradient3)
            HeroCard(heroHeader = "Grab all peripherals", heroSub = "grab a combo offer now", heroBtn = "Check Out", heroImg = R.drawable.peripheral, bgColor = heroGradient4)
        }
    }
}

@Composable
fun HeroCard(heroHeader: String, heroSub:String, heroBtn:String, heroImg:Int, bgColor: List<Color>){
        Box(modifier = Modifier
            .width(410.dp)
            .height(200.dp),
            contentAlignment = Alignment.Center
        ){
            Box(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp)
                .background(
                    brush = Brush.linearGradient(
                        bgColor
                    ), RoundedCornerShape(20.dp)
                )
                .fillMaxHeight(0.8f)){
                Column(
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxHeight(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.Start
                ){
                    Text(
                        text = heroHeader,
                        fontFamily = mulishFontFamily,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.White

                    )
                    Text(text = heroSub,
                        fontSize = 14.sp,
                        fontFamily = mulishFontFamily,
                        fontWeight = FontWeight.Medium,
                        color = Color.White

                    )
                    Button(onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(15.dp),
                        colors = ButtonDefaults.buttonColors(Color.White)
                    ) {
                        Text(text = heroBtn,
                            fontSize = 14.sp,
                            fontFamily = mulishFontFamily,
                            fontWeight = FontWeight.Bold,
                            color = myBlack)
                    }
                }
            }
            Image(painter = painterResource(id = heroImg), contentDescription ="", alignment = Alignment.BottomEnd, modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 10.dp))

        }
}

//-------CATEGORY SECTION---------
@Composable
fun CategorySection(){
    var expandedState by remember { mutableStateOf(false) }
    val rotationState by animateFloatAsState(
        targetValue = if (expandedState) 180f else 0f
    )
    Column(
        modifier = Modifier.animateContentSize(
            animationSpec = tween(
                durationMillis = 300,
                easing = LinearOutSlowInEasing
            )
        )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Categories",
                fontSize = 22.sp,
                color = myBlack,
                fontFamily = mulishFontFamily,
                fontWeight = FontWeight.Bold
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = "See All",
                    fontSize = 14.sp,
                    fontFamily = mulishFontFamily,
                    fontWeight = FontWeight.Medium,
                    color = myPurple
                )
                IconButton(
                    onClick = { expandedState = !expandedState },
                    modifier = Modifier.rotate(rotationState)
                ) {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "",
                        tint = myPurple
                    )
                }
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 0.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            CategoryCard(txt = "STICKS", img = R.drawable.game_controller_icon, bgColor = myBlue, iconColor = myWhite)
            CategoryCard(txt = "GEARS", img = R.drawable.headset_icon)
            CategoryCard(txt = "PSU", img = R.drawable.lightning_icon)
            CategoryCard(txt = "PC", img = R.drawable.desktop_tower_icon)
        }
        if (expandedState) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CategoryCard(txt = "GPU", img = R.drawable.graphic_card)
                CategoryCard(txt = "SCREEN", img = R.drawable.monitor_icon)
                CategoryCard(txt = "MOUSE", img = R.drawable.mouse_icon)
                CategoryCard(txt = "CPU", img = R.drawable.processor_icon)
            }
        }
    }
}

@Composable
fun CategoryCard(txt: String, img: Int, bgColor: Color = myWhite, iconColor: Color = myBlack) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(70.dp)
                .fillMaxSize()
                .background(color = bgColor, shape = RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier.scale(.5f),
                tint = iconColor
            )
        }
        Text(
            text = txt,
            fontFamily = mulishFontFamily,
            modifier = Modifier.padding(10.dp),
            color = myBlack
        )
    }
}

//-------EXCLUSIVE SECTION---------

data class ItemDetails(
    val name: String,
    val price : String,
    val discountPrice: String,
    val image: Int
)

@Composable
fun ExclusiveSection() {
    var remainingSeconds by remember { mutableStateOf(59) }

    LaunchedEffect(Unit) {
        while (remainingSeconds > 0) { // Count down from 59 to 0
            delay(1000)
            remainingSeconds--
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .padding(20.dp, 10.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Exclusive",
                fontSize = 22.sp,
                color = myBlack,
                fontFamily = mulishFontFamily,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = "03:59:${remainingSeconds.toString().padStart(2, '0')}", // Format time string
                modifier = Modifier
                    .padding(start = 20.dp)
                    .background(color = Color(0xFF6200EE), shape = RoundedCornerShape(10.dp))
                    .padding(10.dp),
                color = Color.White,
                fontFamily = mulishFontFamily,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }

        val itemList = listOf(
            ItemDetails("Zebronics Keyboard","800","700",R.drawable.gmonitor),
            ItemDetails("Redgear Mouse","800","700",R.drawable.gpu),
            ItemDetails("Cosmic Byte CB GK 16","800","700",R.drawable.gpu),
            ItemDetails("RGB Monitors","800","700",R.drawable.gpu),
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(16.dp)

        ) {
            items(itemList.size){
                MyCard(item = itemList[it])
            }
        }
    }
}


@Composable
fun MyCard(item: ItemDetails) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .width(150.dp)
            .height(220.dp),
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.BottomCenter
        ) {
            Image(
                painter = painterResource(id = item.image),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 20.dp, bottom = 30.dp)
                    .align(Alignment.TopCenter)
                    .offset(y = (0).dp)
                    .zIndex(1f),
                contentScale = ContentScale.Fit
            )

            // Card content
            Column(
                modifier = Modifier
                    .background(Color.LightGray, RoundedCornerShape(20.dp)).fillMaxHeight(0.8f),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = 40.dp),
                    contentAlignment = Alignment.BottomCenter
                ) {
                    Row(
                        Modifier
                            .height(75.dp)
                            .fillMaxSize()
                            .padding(0.dp, 10.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = item.name,
                            color = myBlack,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.fillMaxWidth(0.5f),
                            fontFamily = mulishFontFamily
                        )
                        Column(
                            horizontalAlignment = Alignment.End
                        ) {
                            Text(
                                text = item.price,
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = myBlack,
                                fontFamily = mulishFontFamily
                            )
                            Text(
                                text = item.discountPrice,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = myBlack,
                                textAlign = TextAlign.Right,
                                textDecoration = TextDecoration.LineThrough,
                                fontFamily = mulishFontFamily
                            )
                        }
                    }
                }
            }
        }
    }
}
