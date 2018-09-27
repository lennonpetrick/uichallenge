package com.test.uichallenge

import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.design.widget.CoordinatorLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.test.uichallenge.adapter.ItemRecyclerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View {

    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpRecyclerView()
        setUpAppBarLayout()
        presenter = MainPresenter(this)
        presenter.load()
    }

    override fun setRecyclerItems(items: List<Item>) {
        recyclerView.adapter = ItemRecyclerAdapter(items)
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

    private fun setUpAppBarLayout() {
        appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBar, offSet ->
            val offsetAbsolute = Math.abs(offSet)
            val totalScrollDouble = appBar.totalScrollRange.toDouble()
            val scrollRemaining = appBar.totalScrollRange - offsetAbsolute

            val layoutParams = nestedScrollView.layoutParams as CoordinatorLayout.LayoutParams
            val currentMarginTop = (scrollRemaining / totalScrollDouble * -200).toInt()
            layoutParams.topMargin = currentMarginTop
            nestedScrollView.layoutParams = layoutParams

            val percentScrolled = offsetAbsolute / totalScrollDouble
            val pictureHeight = (percentScrolled * 400).toInt()

            val progress = percentScrolled.toFloat()
            headerContainer.progress = progress
            (recyclerView.adapter as ItemRecyclerAdapter).changeImageWidth(pictureHeight)
        })
    }
}
