package com.example.pageviewactivity

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import android.os.Bundle
import android.view.View
import java.util.ArrayList

class MainActivity : FragmentActivity() {
    //internal var pageAdapter: MyPageAdapter
    private lateinit var pageAdapter: MyPageAdapter

    private val fragments: List<Fragment>
        get() {
            val fList = ArrayList<Fragment>()

            fList.add(MyFragment.newInstance("Master Splinter", R.drawable.ms))
            fList.add(MyFragment.newInstance("Leonardo", R.drawable.leo))
            fList.add(MyFragment.newInstance("Donatello", R.drawable.donatello))
            fList.add(MyFragment.newInstance("Raphael", R.drawable.raph))
            fList.add(MyFragment.newInstance("Michelangelo", R.drawable.miche))
            return fList
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragments = fragments

        pageAdapter = MyPageAdapter(supportFragmentManager, fragments)
        val pager = findViewById<View>(R.id.viewpager) as ViewPager
        pager.adapter = pageAdapter

    }

    private inner class MyPageAdapter(fm: FragmentManager, private val fragments: List<Fragment>) : FragmentPagerAdapter(fm) {
        private val mResources: IntArray? = null

        override fun getItem(position: Int): Fragment {
            return this.fragments[position]
        }

        override fun getCount(): Int {
            return this.fragments.size
        }
    }

}
