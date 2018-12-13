package com.nyp.sit.dit.it2107.moviereview

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_movie_rater.*

class MovieRater : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_rater)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.rater, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == R.id.miSubmit)
        {
            var rating: Float = ratingBar.rating
            var ratingtext: String = ratingtext.text.toString()
            var myIntent = Intent(this, MovieDetails::class.java)
            myIntent.putExtra("rating", rating)
            myIntent.putExtra("ratingtext", ratingtext)

            setResult(Activity.RESULT_OK, myIntent)
            finish()
        }
        else if(item?.itemId == android.R.id.home)
        {
            finish()
        }
        return super.onOptionsItemSelected(item)
    }
}
