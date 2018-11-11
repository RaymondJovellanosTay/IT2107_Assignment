package com.nyp.sit.dit.it2107.moviereview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_movie_details.*



class MovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        var movie = createMovie("Venom", "When Eddie Brock acquires the powers of a symbiote, he will have to release his alter-ego Venom to save his life.", "English", "03-10-2018", "Yes")

        titleMovie.text = movie.movieTitle
        overviewMovie.text = movie.movieDesc
        releasedateMovie.text = movie.movieDate
        languageMovie.text = movie.movieLang
        suitableMovie.text = movie.movieSuitable


    }
}
