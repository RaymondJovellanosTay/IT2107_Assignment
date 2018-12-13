package com.nyp.sit.dit.it2107.moviereview

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_movie_details.*



class MovieDetails : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        ratingBar.setIsIndicator(true)

        var name = intent.getStringExtra("name")
        var desc = intent.getStringExtra("desc")
        var lang = intent.getStringExtra("lang")
        var date = intent.getStringExtra("date")
        var suitable = intent.getStringExtra("suitable")

        var movie = createMovie(name, desc, lang, date, suitable)

        titleMovie.text = movie.movieTitle
        overviewMovie.text = movie.movieDesc
        releasedateMovie.text = movie.movieDate
        languageMovie.text = movie.movieLang
        suitableMovie.text = movie.movieSuitable

        ratingBar.visibility = View.GONE

        registerForContextMenu(reviewMovie)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)

        if(v?.id == R.id.reviewMovie)
        {
            menu?.add(1,1001,1,"Add Review")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == 1001)
        {
            var myIntent = Intent(this, MovieRater::class.java)
            startActivityForResult(myIntent, 1)
        }
        return super.onContextItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1)
        {
            if (resultCode == Activity.RESULT_OK)
            {
                ratingBar.setVisibility(View.VISIBLE)

                var rating = data!!.getFloatExtra("rating", 0.0f)
                var ratingtext = data.getStringExtra("ratingtext")

                ratingBar.rating = rating
                reviewMovie.text = ratingtext
            }
        }
    }
}
