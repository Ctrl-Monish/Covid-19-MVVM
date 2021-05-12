package com.projects.covidmvvm.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.projects.covidmvvm.R
import com.projects.covidmvvm.data.models.StateWiseModel
import com.projects.covidmvvm.data.models.StatewiseItem
import com.projects.covidmvvm.ui.adapter.StateAdapter
import com.projects.covidmvvm.ui.viewModel.StateViewModel
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    val vm by lazy {
        ViewModelProvider(this).get(StateViewModel::class.java)
    }

    var tempList = arrayListOf<StatewiseItem>()
    var displaylist = arrayListOf<StatewiseItem>()
    val myadapter = StateAdapter(displaylist)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val decoration = DividerItemDecoration(this,DividerItemDecoration.VERTICAL)
        statewiseRecyclerView.addItemDecoration(decoration)
        statewiseRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = myadapter
        }


        vm.fetchdata()
        vm.liveData.observe(this, Observer<StateWiseModel> {
            if(it != null){
                tempList = it.statewise
                displaylist.addAll(tempList)
                myadapter.setUpdateData(displaylist)
            }
        })



        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                if (newText!!.isNotEmpty()){
                    Log.e("MainActivity","Display cleared")
                    displaylist.clear()
                    val search = newText.toLowerCase(Locale.getDefault())
                    Log.e("MainActivity","searching $search")
                    tempList.forEach {
                        if (it.state.toLowerCase(Locale.getDefault()).contains(search)){
                            Log.e("MainActivity","found $search")
                            displaylist.add(it)
                        }
                    }
                    myadapter.setUpdateData(displaylist)
                } else{
                        displaylist.clear()
                        displaylist.addAll(tempList)
                        myadapter.setUpdateData(displaylist)
                    }
                return true
            }
        })
    }
}