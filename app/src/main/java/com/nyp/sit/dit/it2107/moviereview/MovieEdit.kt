package com.nyp.sit.dit.it2107.moviereview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.RadioButton
import kotlinx.android.synthetic.main.activity_movie_edit.*


class MovieEdit : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_edit)

        var movie = createMovie("Avengers", "Moving about a lot of people hitting each other", "English", "2001", "Yes")

        inputName.setText(movie.movieTitle)
        inputDescription.setText(movie.movieDesc)
        if (movie.movieLang == "English")
        {
            langEnglish.isChecked = true
        }
        else if (movie.movieLang == "Chinese")
        {
            langChinese.isChecked = true
        }
        else if (movie.movieLang == "Malay")
        {
            langMalay.isChecked = true
        }
        else if (movie.movieLang == "Tamil")
        {
            langTamil.isChecked = true
        }
        inputDate.setText(movie.movieDate)
        if (movie.movieSuitable == "Yes")
        {
            notSuitableCheckbox.isChecked = false
        }
        else if(movie.movieSuitable == "No")
        {
            notSuitableCheckbox.isChecked = true
        }

        violenceCheckbox.setVisibility(View.INVISIBLE)
        languageCheckbox.setVisibility(View.INVISIBLE)

        notSuitableCheckbox.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                violenceCheckbox.setVisibility(View.VISIBLE)
                languageCheckbox.setVisibility(View.VISIBLE)
            }
            else
            {
                violenceCheckbox.setVisibility(View.INVISIBLE)
                languageCheckbox.setVisibility(View.INVISIBLE)
                violenceCheckbox.isChecked = false
                languageCheckbox.isChecked = false
            }

        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == R.id.miSave)
        {
            val name: String = inputName.text.toString()
            val description: String = inputDescription.text.toString()
            val date: String = inputDate.text.toString()

            var langID = inputLanguage.checkedRadioButtonId
            var lang: RadioButton = inputLanguage.findViewById(langID)
            var language: String = lang.text.toString()

            var suitable: String = ""
            val scheck: Boolean = notSuitableCheckbox.isChecked
            if(scheck == false)
            {
                suitable = "Yes"
            }
            else if(scheck == true)
            {
                suitable = "No"
            }
            else
            {
                if(languageCheckbox.isChecked)
                    suitable = "No (Language)"
                if(violenceCheckbox.isChecked)
                    suitable = "No (Violence)"
                if(languageCheckbox.isChecked && violenceCheckbox.isChecked)
                    suitable = "No (Language & Violence)"
            }


            if(name.isEmpty())
                inputName.setError("Field empty")
            if(description.isEmpty())
                inputDescription.setError("Field empty")
            if(date.isEmpty())
                inputDate.setError("Field empty")

            if(name.isNotEmpty() && description.isNotEmpty() && date.isNotEmpty())
            {
                var myIntent = Intent(this, MovieDetails::class.java)

                myIntent.putExtra("name", name)
                myIntent.putExtra("desc", description)
                myIntent.putExtra("lang", language)
                myIntent.putExtra("date", date)
                myIntent.putExtra("suitable", suitable)

                startActivity(myIntent)
                finish()
            }
        }
        else if (item?.itemId == R.id.miCancel)
        {
            var myIntent = Intent(this, LandingPage::class.java)
            startActivity(myIntent)
        }
        else if (item?.itemId == android.R.id.home)
        {
            var myIntent = Intent(this, LandingPage::class.java)
            startActivity(myIntent)
        }
        return super.onOptionsItemSelected(item)
    }
}
