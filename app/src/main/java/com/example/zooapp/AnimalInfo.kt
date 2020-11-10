package com.example.zooapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.animal_ticket.*

class AnimalInfo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animal_info)

        val bundle: Bundle? = intent.extras
        tvName.text = bundle!!.getString("name")
        tvDes.text = bundle.getString("des")
        ivAnimalImage.setImageResource(bundle.getInt("image"))

    }
}