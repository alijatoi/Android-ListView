package com.example.listviewproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var listView : ListView
    lateinit var button : Button
    lateinit var textview : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Making array of string elements and putting this into address variable
        // Calling ListView findViewById
        listView = findViewById(R.id.listView)
        button = findViewById(R.id.buttonEntr)
        textview =findViewById(R.id.editTxt)

        var address = arrayOf("Germany","Magdeburg item", "Stadfeld OST", "39108",
            "freiligrathrasse")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,address)
        listView.adapter = adapter

        button.setOnClickListener {

            val text = textview.text.toString()
            address += text // add 5 to nums[]
            adapter.notifyDataSetChanged()
        }

        listView.setOnItemClickListener { adapterView, view, i, l ->

            Toast.makeText(applicationContext, "You Clicked " + address[i], Toast.LENGTH_SHORT).show()

        }


        // calling adapter via ListView , ArrayAdapter of Type 'String' ( this 'is the current class Context',
        // 'android.R.layout.simple_list_item 1 is pre defined style of showing list', addres is array of string elements which is defined above
       // listView.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,address)

        // Listener of Each Items of The List
        //1st Parameter AdapterView : 'View of the list' , 2nd is view, that is 'view of item that is clicked'
        //3rd is i which is position of item being clicked, l is the 'id' of item that is being clicked


    }
}