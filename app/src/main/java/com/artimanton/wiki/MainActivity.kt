package com.artimanton.wiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artimanton.wiki.adapter.CharacterAdapter
import com.artimanton.wiki.model.Character
import com.artimanton.wiki.retrofit.Common
import com.artimanton.wiki.retrofit.RetrofitServices
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: CharacterAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        getAllMovieList()
    }

    private fun getAllMovieList() {

        mService.getCharacterList().enqueue(object : Callback<MutableList<Character>> {
            override fun onFailure(call: Call<MutableList<Character>>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Get post failed", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<MutableList<Character>>, response: Response<MutableList<Character>>) {
                adapter = CharacterAdapter(baseContext, response.body()!!)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
            }
        })
    }
}
