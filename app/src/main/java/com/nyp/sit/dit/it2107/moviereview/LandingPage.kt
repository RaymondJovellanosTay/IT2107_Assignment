package com.nyp.sit.dit.it2107.moviereview

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_landing_page.*

class LandingPage : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)

        registerForContextMenu(textmenu)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if(v?.id == R.id.textmenu)
        {
            menu?.add(1, 1001, 1, "Add")
        }
    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        if(item?.itemId == 1001)
        {
            var intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        return super.onContextItemSelected(item)
    }
}
