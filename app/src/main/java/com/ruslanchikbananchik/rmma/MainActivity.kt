package com.ruslanchikbananchik.rmma

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.ruslanchikbananchik.rmma.`interface`.RetrofitServices
import com.ruslanchikbananchik.rmma.adapter.FactAdapter
import com.ruslanchikbananchik.rmma.common.Common
import com.ruslanchikbananchik.rmma.databinding.ActivityMainBinding
import com.ruslanchikbananchik.rmma.model.Fact
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    //private lateinit var binding: ActivityMainBinding
    lateinit var fService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: FactAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        fService = Common.retrofitService
        factsRecyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        factsRecyclerView.layoutManager = layoutManager

        getCatFacts()
    }

    private fun getCatFacts() {
        fService.getFactsList().enqueue(object : Callback<MutableList<Fact>> {
            override fun onFailure(call: Call<MutableList<Fact>>, t: Throwable) {
                //TODO("Not yet implemented")
            }
            override fun onResponse(
                call: Call<MutableList<Fact>>,
                response: Response<MutableList<Fact>>
            ) {
                adapter = FactAdapter(baseContext, response.body() as MutableList<Fact>)
                adapter.notifyDataSetChanged()
                factsRecyclerView.adapter = adapter
            }
        })

    }
}