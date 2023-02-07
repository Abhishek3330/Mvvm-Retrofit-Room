package test.com.mvvmretrofitroom.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import test.com.mvvmretrofitroom.R
import test.com.mvvmretrofitroom.models.QuoteListItem

/**
 * Created by Mukesh on 18-01-2023.
 */
class Adapter(private val qList: List<QuoteListItem>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

        // create new views
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            // inflates the item_view view
            // that is used to hold list item
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list, parent, false)

            return ViewHolder(view)
        }

        // binds the list items to a view
        override fun onBindViewHolder(holder: ViewHolder, position: Int) {

            val ItemsViewModel = qList[position]

            // sets the image to the imageview from our itemHolder class
            holder.author.text =ItemsViewModel.author

            // sets the text to the textview from our itemHolder class
            holder.text.text = ItemsViewModel.text

        }

        // return the number of the items in the list
        override fun getItemCount(): Int {
            return qList.size
        }

        // Holds the views for adding it to image and text
        class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
            val author: TextView = itemView.findViewById(R.id.author)
            val text: TextView = itemView.findViewById(R.id.text)
        }


}