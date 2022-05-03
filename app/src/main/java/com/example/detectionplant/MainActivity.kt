package com.example.detectionplant

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.CoordinatorLayout
import android.support.v4.widget.DrawerLayout
import android.view.View
import android.widget.Toolbar
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var mCategorization: Categorization
    private lateinit var mBitmap: Bitmap
    private val mCameraRequestCode = 0
    private val mGalleryRequestCode = 2

    private val mInputSize = 22
    private val mModelPath ="plant_disease_model.tfLite"
    private val mLabelPath ="plant_labels.txt"

    private val mSamplePath = "automn.jpg"
    lateinit var toolbar: Toolbar
    lateinit var drawerLayout: DrawerLayout
    lateinit var navigationView: NavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navigationView = findViewById<View>(R.id.nav_views) as NavigationView
        toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        drawerLayout= findViewById<View>(R.id.drawer_layout) as DrawerLayout

    }
}