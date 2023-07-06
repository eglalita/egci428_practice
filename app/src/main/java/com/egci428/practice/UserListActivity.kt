package com.egci428.practice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ListView
import com.egci428.practice.model.User
import com.egci428.practice.model.UserAdapter
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception

class UserListActivity : AppCompatActivity() {

    lateinit var userList: MutableList<User>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)

        val listView = findViewById<ListView>(R.id.listView)

        userList = mutableListOf()


        listView.setOnItemClickListener { parent, view, position, id ->

            val auser = userList!!.get(position)
            displayMap(auser)
        }
    }

    private fun displayMap(ausr: User) {
        val intent = Intent(this, MapsActivity::class.java)
        intent.putExtra("selUser", ausr.username)
        intent.putExtra("selLat", ausr.latitude)
        intent.putExtra("selLon", ausr.longitude)
        startActivity(intent)
    }


}
