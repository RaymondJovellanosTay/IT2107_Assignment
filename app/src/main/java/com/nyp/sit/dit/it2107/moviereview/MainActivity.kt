package com.nyp.sit.dit.it2107.moviereview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        langEnglish.isChecked = true

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

    fun addMovieBtn (v: View) {
        val name: String = inputName.text.toString()
        val description: String = inputDescription.text.toString()
        val date: String = inputDate.text.toString()

        var langID = inputLanguage.checkedRadioButtonId
        var lang: RadioButton = inputLanguage.findViewById(langID);
        var language: String = lang.text.toString();

        val suitable: Boolean = notSuitableCheckbox.isChecked
        var reasonViolence: String = ""
        var reasonLanguage: String = ""

        if(languageCheckbox.isChecked)
            reasonLanguage = "Language"
        if(violenceCheckbox.isChecked)
            reasonViolence = "Violence"

        if(name.isEmpty())
            inputName.setError("Field empty")
        if(description.isEmpty())
            inputDescription.setError("Field empty")
        if(date.isEmpty())
            inputDate.setError("Field empty")

        Toast.makeText(this,
            "Title = $name \n" +
                    "Overview = $description \n" +
                    "Release date = $date \n" +
                    "Language = $language \n" +
                    "Suitable for all ages = $suitable \n" +
                    "Reason: \n" +
                    "$reasonLanguage\n" +
                    "$reasonViolence"
            , Toast.LENGTH_LONG).show()
    }
}
