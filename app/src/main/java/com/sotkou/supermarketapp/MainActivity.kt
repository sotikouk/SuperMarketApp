package com.sotkou.supermarketapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1. AdapterView. Αρχικοποιούμε το RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        // Ορίζουμε το layoutManager του recyclerView.
        // Είναι υπεύθυνο για: Την τοποθέτηση και μέτρηση των items στο RecyclerView
        // To LinearLayoutManager ειναι ενα απο τα Build in layout managers που μας παρέχει
        // το android για το RecyclerView. Τακτοποιεί τα items με γραμμικό τρόπο(οριζόντια ή
        // κάθετα) ανάλογα με την κατεύθυνση που του ορίζουμε.
        recyclerView.layoutManager = LinearLayoutManager(
            this, // Το context της παρούσας Activity
            LinearLayoutManager.VERTICAL, // Κάθετα
            false // Ορίζουμε αν θέλουμε να αντιστρέψουμε την σειρά των items
        )

        // 2. Data Source
        val goods: ArrayList<Item> = ArrayList()

        val g1 = Item("Fruits", "Greek producers Fruits",R.drawable.fruit)
        val g2 = Item("Vegetables", "Greek origin always fresh", R.drawable.vegetables)
        val g3 = Item("Bread", "Hot tasty bread", R.drawable.bread)
        val g4 = Item("Orange Juice", "100% from fresh Oranges", R.drawable.orangejuice)
        val g5 = Item("Milk", "Fresh milk produced today", R.drawable.milk)
        val g6 = Item("Snacks", "The best of quality",R.drawable.popcorn)

        goods.add(g1)
        goods.add(g2)
        goods.add(g3)
        goods.add(g4)
        goods.add(g5)
        goods.add(g6)

        // 3 Adapter
        val adapter = MyAdapter(goods)
        recyclerView.adapter = adapter


    }
}