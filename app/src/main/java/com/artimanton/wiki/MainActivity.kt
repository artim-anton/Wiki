package com.artimanton.wiki

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.artimanton.wiki.adapter.CharacterAdapter
import com.artimanton.wiki.model.AllCharacters
import com.artimanton.wiki.retrofit.Common
import com.artimanton.wiki.retrofit.RetrofitServices
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*

class MainActivity : AppCompatActivity(), CharacterAdapter.OnItemClickListener {
    lateinit var mService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: CharacterAdapter
    lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mService = Common.retrofitService
        recyclerView = recycler_view
        recyclerView.setHasFixedSize(true)
        layoutManager = GridLayoutManager(this,2)
        recyclerView.layoutManager = layoutManager

        getAllMovieList()
    }

    private fun getAllMovieList() {

        mService.getCharacterList().enqueue( object : Callback<AllCharacters> {
            override fun onFailure(call: Call<AllCharacters>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Get post failed", Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<AllCharacters>, response: Response<AllCharacters>) {
                adapter = CharacterAdapter(this@MainActivity, response.body()!!)
                adapter.notifyDataSetChanged()
                recyclerView.adapter = adapter
            }
        })

    }

    override fun onItemClick(position: Int) {
        Toast.makeText(this, "Item $position clicked", Toast.LENGTH_SHORT).show()
        adapter.notifyItemChanged(position)
    }


}
