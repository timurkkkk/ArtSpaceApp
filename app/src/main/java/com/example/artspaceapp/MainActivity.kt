package com.example.artspaceapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.automirrored.rounded.ArrowForward
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.artspaceapp.ui.theme.ArtSpaceAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceAppTheme {

                var currentPhoto by rememberSaveable { mutableStateOf(0) }
                val array = arrayOf(
                    PhotoCardClass(
                        painterResource(R.drawable.photo1),
                        "Скульптура «Ижик»",
                        "Автор фото: InnaVlad"),
                    PhotoCardClass(
                        painterResource(R.drawable.photo2),
                        "Памятник крокодилу",
                        "Автор фото: Yan.gorev"),
                    PhotoCardClass(
                        painterResource(R.drawable.photo3),
                        "Свято-Михайловский собор",
                        "Автор фото: Vyacheslav Bukharov"),
                    PhotoCardClass(
                        painterResource(R.drawable.photo4),
                        "Набережная зодчего Дудина",
                        "Автор фото: Maria P"),
                    PhotoCardClass(
                        painterResource(R.drawable.photo5),
                        "Монумент дружбы народов \"Навеки с Россией\"",
                        "Автор фото: Ramon-apb"),
                    PhotoCardClass(
                        painterResource(R.drawable.photo6),
                        "Музей имени М. Т. Калашникова",
                        "Автор фото: Тара-Амингу"),
                    PhotoCardClass(
                        painterResource(R.drawable.photo7),
                        "Карлутская площадь",
                        "Автор фото: Vyacheslav Bukharov"),
                    PhotoCardClass(
                        painterResource(R.drawable.photo8),
                        "Театр оперы и балета имени П. И. Чайковского",
                        "Автор фото: Vyacheslav Bukharov"),
                    PhotoCardClass(
                        painterResource(R.drawable.photo9),
                        "Царь-пушка",
                        "Автор фото: Vyacheslav Bukharov"),
                    PhotoCardClass(
                        painterResource(R.drawable.photo10),
                        "Памятник Ижевским оружейникам",
                        "Автор фото: Yan.gorev"),
                )

                BoxWithConstraints {
                    if (maxWidth < 400.dp) {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            Column(
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier
                                    .padding(8.dp)
                            ) {
                                PhotoCard(array[currentPhoto])
                                Spacer(modifier = Modifier.height(8.dp))
                            }
                            Row(
                                verticalAlignment = Alignment.Bottom,
                                horizontalArrangement = Arrangement.SpaceAround,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .padding(bottom = 100.dp)
                            )
                            {
                                Button(onClick = {
                                    currentPhoto -= 1
                                    if (currentPhoto == -1) currentPhoto = 9;
                                }) {
                                    Icon(
                                        Icons.AutoMirrored.Rounded.ArrowBack,
                                        contentDescription = null
                                    )
                                }

                                Button(onClick = {
                                    currentPhoto += 1
                                    if (currentPhoto == 10) currentPhoto = 0;
                                }) {
                                    Icon(
                                        Icons.AutoMirrored.Rounded.ArrowForward,
                                        contentDescription = null
                                    )
                                }

                            }

                        }
                    }
                    else
                    {
                        Surface(
                            modifier = Modifier.fillMaxSize(),
                            color = MaterialTheme.colorScheme.background
                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.Absolute.SpaceBetween,
                                modifier = Modifier
                                    .padding(8.dp)
                                    .padding(horizontal = 100.dp)
                            )
                            {
                                Button(onClick = {
                                    currentPhoto -= 1
                                    if (currentPhoto == -1) currentPhoto = 9;
                                }) {
                                    Icon(
                                        Icons.AutoMirrored.Rounded.ArrowBack,
                                        contentDescription = null
                                    )
                                }

                                PhotoCard(array[currentPhoto])

                                Button(onClick = {
                                    currentPhoto += 1
                                    if (currentPhoto == 10) currentPhoto = 0;
                                }) {
                                    Icon(
                                        Icons.AutoMirrored.Rounded.ArrowForward,
                                        contentDescription = null
                                    )
                                }

                            }

                        }
                    }
                }
            }
        }
    }
}

class PhotoCardClass {
    constructor(image: Painter, name : String = "", description : String = "")
    {
        this.image = image
        this.name = name
        this.description = description
    }
    var image : Painter
    var name : String
    var description : String
}

@Composable
fun PhotoCard(photoCard : PhotoCardClass) {

    Card(
        modifier = Modifier
            .padding(16.dp)
            ,
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp
        ),
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(16.dp)

        ) {
            Image(photoCard.image,
                contentDescription = null,
                Modifier.heightIn(max = (LocalConfiguration.current.screenHeightDp * 0.6).dp))
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = photoCard.name,
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = photoCard.description,
                color = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ArtSpaceAppTheme {

    }
}