package com.example.myapplication1.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication1.R
import com.example.myapplication1.adapters.PersonAdapter
import com.example.myapplication1.models.Person
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity : AppCompatActivity() {

    private lateinit var adapter: PersonAdapter
    private lateinit var personList: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)

        personList = getPersons()
        adapter = PersonAdapter(this, R.layout.list_view_person, getPersons())


        listView.adapter = adapter

    }

    private fun getPersons(): List<Person>{
        return listOf(
                Person("André", "Ibarra", 22),
                Person("Alejandro", "Salazar", 21),
                Person("Miguel", "Gonzalez", 23)
        )
    }
}