package com.sotkou.supermarketapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

// Ο adapter λειτουργεί ως γέφυρα μεταξύ των δεδομένων
// και του UI στοιχείου RecyclerView
class MyAdapter(val itemsList: ArrayList<Item>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    // Εσωτερική κλάση. Το ViewHolder κρατά τις αναφορές των Views απο κάθε ένα
    // απο τα items του RecyclerView
    // itemView: Είναι το View για το κάθε ένα απο τα στοιχεία του RecyclerView
    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        // Πρέπει να προσαρμόσουμε το δικό μας item στο ViewHolder
        var itemImage: ImageView
        var itemName: TextView
        var itemDescription: TextView

        init {
            itemImage = itemView.findViewById(R.id.imageView)
            itemName = itemView.findViewById(R.id.item_name)
            itemDescription = itemView.findViewById(R.id.description)

            itemView.setOnClickListener {
                Toast.makeText(itemView.context, "Buying some ${itemsList[adapterPosition].name}",Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Καλείται οταν το RecyclerView χρειάζεται ενα νεο ViewHolder
        // Φτιάχνει ενα νέο Layout για ενα στοιχείο και επιστρέφει ενα νεο ViewHolder
        // ViewGroup: Είναι το αρχικό View που θα "κολλήσουμε" το ν'εο view που φτιάξαμε
        // viewType: Σε κάποιες περιπτώσεις έχουμε διαφορετικούς τύπους view.

        val view = LayoutInflater.from(parent.context) // δημιουργεί μια οντότητα του xml με τα αντίστοιχα View αντικείμενα
            .inflate(R.layout.item_layout, parent, false) // δείχνει ποιό xml θα γίνει οντότητα, που και πότε
            // item_layout: το xml που θα εμφανιστεί
            // parent: που θα "κολλήσουμε" το xml
            // false: Να μην το εμφανίσουμε αμέσως. Το κανονίζει το RecyclerView
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        // Επιστρέφει τον αριθμό των αντικειμένων στο data set
        return itemsList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // "Δένει" δεδομένα στο viewholder σε συγκεκριμένη θέση (position)

        holder.itemName.text = itemsList[position].name
        holder.itemDescription.text = itemsList[position].description
        holder.itemImage.setImageResource(itemsList[position].image)
    }
}