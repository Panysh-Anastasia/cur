package com.example.podcasta.repository

import com.example.podcasta.R
import com.example.podcasta.ui.theme.composable.PodcastModel

class PodcastaRepository{
    fun getAllDate(): List<PodcastModel>{
        return listOf(
            PodcastModel(
                id = 0,
                trackIcon = R.drawable.ted_talks,
                name = "Let your garden grow wild",
                author = "Rebecca McMackin",
                releaseDate ="27 march"
            ),
            PodcastModel(
                id = 1,
                trackIcon = R.drawable.ted_talks,
                name = "5 lessons on happiness - from pop fame to poisonous snakes",
                author = "Mike Posner",
                releaseDate ="19 march"
            ),
            PodcastModel(
                id = 2,
                trackIcon = R.drawable.super_soul,
                name = "Kerry Washington",
                author = "OPRAH and Kerry Washington",
                releaseDate ="25 december 2023"
            ),
            PodcastModel(
                id = 3,
                trackIcon = R.drawable.english,
                name = "Как выучить английский самостоятельно",
                author = "Андрей Гуляев",
                releaseDate ="20 october 2022"
            ),
            PodcastModel(
                id = 4,
                trackIcon = R.drawable.lifehak,
                name = "Как работает наш мозг, когда мы читаем книги",
                author = "Подкаст Лайфхакера",
                releaseDate ="10 april "
            ),
            PodcastModel(
                id = 5,
                trackIcon = R.drawable.lifehak,
                name = "9 причин, почему путешественника могут не пустить в самолет",
                author = "Подкаст Лайфхакера",
                releaseDate ="17 april "
            ),
            PodcastModel(
                id = 6,
                trackIcon = R.drawable.book_bazar,
                name = "Глава, в которой в 'Книжном базаре' снова появляется Гарри Поттер - и, кажется, на этот раз проигрывает 'Фантастическим тварям' ",
                author = "Книжный базар",
                releaseDate ="6 october 2021 "
            )
        )
    }
}