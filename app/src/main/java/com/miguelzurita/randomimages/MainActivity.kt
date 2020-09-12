package com.miguelzurita.randomimages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var model = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        var urlImage: MutableLiveData<String>? = model.callURLImage()

        urlImage?.observe(this, Observer {
            Picasso.get().load(it)
                .into(imagePhoto)

            Picasso.get().load(it)
                .into(imagePhoto2)
        })

        btnGetURLImage.setOnClickListener {
            model.randomNumbersURL()
        }

    }
}