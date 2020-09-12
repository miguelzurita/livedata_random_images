package com.miguelzurita.randomimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model: MainActivityViewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        val urlImage: MutableLiveData<String>? = model.getURLImageLiveData()

        urlImage?.observe(this, Observer {
            Picasso.get().load(it)
                    .into(imagePhoto)

            Picasso.get().load(it)
                    .into(imagePhoto2)
        })

        btnGetURLImage.setOnClickListener {
            model.changeRandomImage()
        }

        model.size.observe(this, Observer {
            textView.text = it
        })
    }
}