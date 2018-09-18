package com.test.uichallenge

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.test.uichallenge.adapter.ItemRecyclerAdapter
import kotlinx.android.synthetic.main.main_start.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpToolbar()
        setUpRecyclerView()
        presenter = MainPresenter(this)
        presenter.load()
    }

    override fun setRecyclerItems(items: List<Item>) {
        recyclerView.adapter = ItemRecyclerAdapter(items)
    }

    private fun setUpToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setIcon(R.drawable.ic_menu)
        supportActionBar?.setDisplayShowTitleEnabled(false)
    }

    private fun setUpRecyclerView() {
        recyclerView.apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@MainActivity,
                    LinearLayoutManager.HORIZONTAL, false)
        }

        val decoration = DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)
        val drawable = getDrawable(R.drawable.layout_recycler_transparent_divider)
        decoration.setDrawable(drawable!!)

        recyclerView.addItemDecoration(decoration)
    }
}
