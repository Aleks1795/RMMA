package com.ruslanchikbananchik.rmma

import android.content.Context
import android.net.ConnectivityManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import com.ruslanchikbananchik.rmma.`interface`.RetrofitServices
import com.ruslanchikbananchik.rmma.adapter.FactAdapter
import com.ruslanchikbananchik.rmma.common.Common
import com.ruslanchikbananchik.rmma.databinding.ActivityMainBinding
import com.ruslanchikbananchik.rmma.model.Facts
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var fService: RetrofitServices
    lateinit var layoutManager: LinearLayoutManager
    lateinit var adapter: FactAdapter

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        fService = Common.retrofitService
        binding.factsRecyclerView.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        binding.factsRecyclerView.layoutManager = layoutManager

        isOnline(this)
    }

    private fun getCatFacts() {
        binding.progressBar.visibility = View.INVISIBLE
        fService.getFactsList().enqueue(object : Callback<Facts> {
            override fun onFailure(call: Call<Facts>, t: Throwable) {

            }
            override fun onResponse(
                call: Call<Facts>,
                response: Response<Facts>
            ) {
                adapter = FactAdapter(baseContext, response.body() as Facts)
                adapter.notifyDataSetChanged()
                factsRecyclerView.adapter = adapter
            }
        })

    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun isOnline(context: Context) {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (connectivityManager != null) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                getCatFacts()
            } else {
                binding.progressBar.visibility = View.VISIBLE
                Toast.makeText(context, "Offline!", Toast.LENGTH_LONG).show()
            }
        }
    }
}