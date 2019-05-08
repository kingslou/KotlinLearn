package com.example.kotlinlearn

import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.toolbar.*


class Main2Activity : AppCompatActivity() {

    var fragmentHome = HomeFragment();
    var fragmentDash = DashFragment();
    var fragmentNotification = NotiFragment();

    val listFragment = listOf(fragmentHome, fragmentDash, fragmentNotification)

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                mainViewPager.setCurrentItem(0, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                mainViewPager.setCurrentItem(1, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                mainViewPager.setCurrentItem(2, true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private val mOnMenuClickListener = Toolbar.OnMenuItemClickListener { item ->
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        setSupportActionBar(mToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        mToolbar.setOnMenuItemClickListener(mOnMenuClickListener)

        mToolbar.setNavigationOnClickListener { finish() }

        mainViewPager.adapter = PageAdapter(supportFragmentManager, listFragment);

        mainViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                navigation.getMenu().getItem(position).setChecked(true);
            }

        })

    }

    class PageAdapter(fragmentManager: FragmentManager?, var list: List<Fragment>) :
        FragmentPagerAdapter(fragmentManager) {
        override fun getItem(position: Int): Fragment {
            return list.get(position)
        }

        override fun getCount(): Int {
            return list.size
        }
    }

}
