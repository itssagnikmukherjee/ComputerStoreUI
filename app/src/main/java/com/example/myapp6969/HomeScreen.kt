package com.example.myapp6969

import android.graphics.drawable.shapes.Shape
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myapp6969.ui.theme.Purple40
import com.example.myapp6969.ui.theme.Purple80
import com.example.myapp6969.ui.theme.heroGradient1
import com.example.myapp6969.ui.theme.heroGradient2
import com.example.myapp6969.ui.theme.heroGradient3
import com.example.myapp6969.ui.theme.heroGradient4
import com.example.myapp6969.ui.theme.mulishFontFamily
import com.example.myapp6969.ui.theme.myBlack
import com.example.myapp6969.ui.theme.myGrey
import com.example.myapp6969.ui.theme.myPurple
import com.example.myapp6969.ui.theme.myWhite

@Composable
fun HomeScreen(){
    LazyColumn {
        item {
            SearchSection()
            HeroSection()
            CategorySection()
        }
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
            CategoryCard(txt = "GPU", img = R.drawable.game_controller_icon)
            CategoryCard(txt = "GEARS", img = R.drawable.game_controller_icon)
            CategoryCard(txt = "PSU", img = R.drawable.game_controller_icon)
            CategoryCard(txt = "OTH", img = R.drawable.game_controller_icon)
        }
        if (expandedState) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp, 0.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CategoryCard(txt = "GPU", img = R.drawable.game_controller_icon)
                CategoryCard(txt = "GEARS", img = R.drawable.game_controller_icon)
                CategoryCard(txt = "PSU", img = R.drawable.game_controller_icon)
                CategoryCard(txt = "OTH", img = R.drawable.game_controller_icon)
            }
        }
    }
}

@Composable
fun CategoryCard(txt: String, img: Int) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .padding(10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .size(70.dp).fillMaxSize()
                .background(color = myWhite, shape = RoundedCornerShape(20.dp)),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = img),
                contentDescription = "",
                modifier = Modifier.scale(.5f),
                tint = myBlack
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
