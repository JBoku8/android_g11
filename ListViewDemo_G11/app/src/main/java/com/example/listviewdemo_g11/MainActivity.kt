package com.example.listviewdemo_g11

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var mainListView: ListView

    private val techList = arrayOf<String>(
        "Google",
        "Facebook",
        "WhatsApp",
        "Instagram",
        "TikTok",
        "Amazon",
        "Apple",

        "Google",
        "Facebook",
        "WhatsApp",
        "Instagram",
        "TikTok",
        "Amazon",
        "Apple",

        "Google",
        "Facebook",
        "WhatsApp",
        "Instagram",
        "TikTok",
        "Amazon",
        "Apple"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainListView = findViewById(R.id.main_listView);

        // supportActionBar?.hide()


        // val color = Color.parseColor("#583d72");

        // mainListView.setBackgroundColor(color)

        mainListView.adapter = NamesAdapter(this, techList)

        mainListView.setOnItemClickListener { _, _, position, _ ->
            // Log.v("SELECTED_TECH", techList[position])

            val detailIntent = Intent(this, TechDetail::class.java)
            detailIntent.putExtra(Constants.Selected_Tech_Title, techList[position])
            detailIntent.putExtra(Constants.Selected_Tech_Desc, "Row Number - $position")
            startActivity(detailIntent)
        }
    }


    private class NamesAdapter(val context: Context, val dataSource: Array<String>): BaseAdapter(){
        override fun getCount(): Int {
            return dataSource.size;
        }

        override fun getItem(position: Int): Any {
            // Log.v("INDEX", position.toString())
            return  dataSource[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong();
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


            val color = Color.parseColor("#583d72");
            lateinit var listViewLayout: View

            if( convertView == null ) {
                // Log.i("FINDING", "Searching")
                val layoutInflater = LayoutInflater.from(context);
                listViewLayout = layoutInflater.inflate(R.layout.main_listview_layout, parent, false);
                val techTitle = listViewLayout.findViewById<TextView>(R.id.techTitle);
                val techDescription = listViewLayout.findViewById<TextView>(R.id.textViewDescription);
                val viewHolder = ViewHolder(techTitle, techDescription);

                listViewLayout.tag = viewHolder;
            }
            else {
                listViewLayout = convertView;
            }


            val viewHolder = listViewLayout.tag as ViewHolder;

            viewHolder.techTitle.text = dataSource[position]
            viewHolder.techDescription.text = "Row Number - $position"

            viewHolder.techTitle.setTextColor(color);
            viewHolder.techDescription.setTextColor(color);


            return  listViewLayout;


//            val textView = TextView(context)
//            textView.text = "Super Duper textView";
//            val color = Color.parseColor("#583d72");
//            textView.setTextColor(color);
//            return textView
        }

        private class ViewHolder(var techTitle: TextView, var techDescription: TextView);
    }
}