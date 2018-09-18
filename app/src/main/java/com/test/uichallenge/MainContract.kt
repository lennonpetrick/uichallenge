package com.test.uichallenge

interface MainContract {

    interface View {
        fun setRecyclerItems(items: List<Item>)
    }

    interface Presenter {
        fun load()
    }
}