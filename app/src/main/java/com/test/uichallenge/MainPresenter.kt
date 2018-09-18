package com.test.uichallenge

class MainPresenter(val view: MainContract.View) : MainContract.Presenter {

    override fun load() {
        val items = arrayListOf<Item>()
        val item = Item()
        item.picture = R.drawable.item_background
        item.title = "About Us"
        item.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Proin nibh elit, luctus sed convallis ut, convallis eget purus. " +
                "Phasellus diam tortor, commodo non orci a, commodo malesuada est. " +
                "Integer nec nisi orci"

        val item2 = Item()
        item2.picture = R.drawable.item_background
        item2.title = "Menu"
        item2.description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                "Proin nibh elit, luctus sed convallis ut, convallis eget purus. " +
                "Phasellus diam tortor, commodo non orci a, commodo malesuada est. " +
                "Integer nec nisi orci"

        items.add(item)
        items.add(item2)
        view.setRecyclerItems(items)
    }
}