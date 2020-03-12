package com.example.kotlinrecylerview
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.example_item.view.*

class ExampleAdapter(private val exampleList:
List<ExampleItem>): RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder>(){

    //parent is a RecyclerView and the ExampleViewHolder we are creating will be
    //place in it
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.example_item,
            parent, false )
        //false means don't add to the recyclerView immediately
        return ExampleViewHolder(itemView);
    }

    override fun getItemCount() = exampleList.size

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        //this sets the data for the views
        val currentItem = exampleList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.textView1.text = currentItem.text1
        holder.textView2.text = currentItem.text2

        /**
         * Dont Do:
         * holder.itemView.text_view_1.text = currentItem.text1
         * bc it calls findViewById under the hood and that's
         * what you should typically avoid*/
    }

    class ExampleViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.image_view
        val textView1: TextView = itemView.text_view_1
        val textView2: TextView = itemView.text_view_2

    }
}