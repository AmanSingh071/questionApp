package com.example.questionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var adapter:questionAdapter
    private var articles = mutableListOf<Question>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyview=findViewById<RecyclerView>(R.id.recy)



            Toast.makeText(this@MainActivity,"clcik",Toast.LENGTH_SHORT).show()
            val servicegenrator=ServiceGen.buildService(apiService::class.java)
            var call=servicegenrator.getposts()
            call.enqueue(object : Callback<MutableList<Question>>{
                override fun onResponse(call: Call<MutableList<Question>>, response: Response<MutableList<Question>>) {
                    if (response.isSuccessful){

                        Toast.makeText(this@MainActivity,"success",Toast.LENGTH_SHORT).show()
                      /* recyview.apply {
                          val layoutManager=LinearLayoutManager(this@MainActivity)
                           adapter= questionAdapter(response.body()!!)
                       }*/
                        /*val strbuilder=StringBuilder()
                        for (mydata in responsebody){
                            strbuilder.append(mydata.Question)
                            strbuilder.append("\n")
                        }
                        opta.text=strbuilder*/

                        val layoutManager =LinearLayoutManager(this@MainActivity)
                        adapter = questionAdapter(response.body()!!)
                        recyview.adapter=adapter
                        recyview.layoutManager=layoutManager



                    }
                }

                override fun onFailure(call: Call<MutableList<Question>>, t: Throwable) {
                    t.printStackTrace()
                    Toast.makeText(this@MainActivity,t.message.toString(),Toast.LENGTH_SHORT).show()
                    Log.e("fail,",t.message.toString())

                }

            })



    }
}