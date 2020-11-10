package com.example.zooapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater

import android.view.View

import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.animal_ticket.view.*


class MainActivity : AppCompatActivity() {

    var listOfAnimals = ArrayList<Animal>()
    var adapter: AnimalsAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        listOfAnimals.add(
            Animal(
                "Baboon",
                "Baboon live in a big place with tree",
                R.drawable.baboon,
                false
            )
        )
        listOfAnimals.add(
            Animal(
                "Bulldog",
                "Bulldog live in a big place with tree",
                R.drawable.bulldog,
                false
            )
        )
        listOfAnimals.add(
            Animal(
                "Panda",
                "Panda live in a big place with tree",
                R.drawable.panda,
                true
            )
        )
        listOfAnimals.add(
            Animal(
                "Swallow Bird",
                "Swallow Bird live in a big place with tree",
                R.drawable.swallow_bird,
                false
            )
        )
        listOfAnimals.add(
            Animal(
                "White Tiger",
                "White Tiger live in a big place with tree",
                R.drawable.white_tiger,
                true
            )
        )
        listOfAnimals.add(
            Animal(
                "Zebra",
                "Zebra live in a big place with tree",
                R.drawable.zebra,
                false
            )
        )

        adapter = AnimalsAdapter(listOfAnimals, this)
        tvListAnimal.adapter = adapter
    }


    class AnimalsAdapter(
        private val listOfAnimals: ArrayList<Animal>, private val context: Context) : BaseAdapter() {

        override fun getCount(): Int {
            return listOfAnimals.size
        }

        override fun getItem(position: Int): Any {
            return listOfAnimals[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            val animal = listOfAnimals[position]
            val inflater =
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val myView: View?
            myView = if (!animal.isKiller)
                inflater.inflate(R.layout.animal_ticket, null)
            else
                inflater.inflate(R.layout.animal_killer_ticket, null)

            myView!!.tvName.text = animal.name
            myView.tvDes.text = animal.des
            myView.ivAnimalImage.setImageResource(animal.image)
            myView.ivAnimalImage.setOnClickListener {
                val intent = Intent(context, AnimalInfo::class.java)
                intent.putExtra("name", animal.name)
                intent.putExtra("des", animal.des)
                intent.putExtra("image", animal.image)
                context.startActivity(intent)
            }
            return myView
        }

    }


}