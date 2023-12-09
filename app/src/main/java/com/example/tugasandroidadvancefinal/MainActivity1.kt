package com.example.tugasandroidadvancefinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity1 : AppCompatActivity() {
    lateinit var toolbar: Toolbar
    lateinit var drawer_layout: DrawerLayout

    companion object {
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        drawer_layout = findViewById(R.id.drawer_layout)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        val superheroList = listOf<Superhero>(
            Superhero(
                R.drawable.antman,
                "Ant Man",
                "Manusia Semut"
            ),
            Superhero(
                R.drawable.captain,
                "Captain America",
                "Manusia Semut"

            ),
            Superhero(
                R.drawable.marvel,
                "The Marvels",
                "Manusia Semut"
            ),
            Superhero(
                R.drawable.spiderman,
                "Spider-Man",
                "Manusia Semut"
            ),
            Superhero(
                R.drawable.thor,
                "Thor",
                "Manusia Semut"
            ),

            Superhero(
                R.drawable.aquaman,
                "Aquaman",
                "Manusia Semut"
            ),

            Superhero(
                R.drawable.avenger,
                "Avenger",
                "Manusia Semut"
            ),
            Superhero(
                R.drawable.eternal,
                "Eternal",
                "Manusia Semut"
            )

        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_hero)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = SuperheroAdapter(this, superheroList){
            val intent = Intent(this, DetailSuperheroActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController = findNavController(R.id.fragmentContainerView)
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.favFragment, R.id.movieFragment, R.id.newsFragment))
        setupActionBarWithNavController(navController, appBarConfiguration)

        bottomNavigationView.setupWithNavController(navController)


    }

    override fun onBackPressed() {
        if(drawer_layout.isDrawerOpen(GravityCompat.START)){
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}