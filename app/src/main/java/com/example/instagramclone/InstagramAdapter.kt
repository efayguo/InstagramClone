package com.example.instagramclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.feed_view.*
import kotlinx.android.synthetic.main.story_view.view.*
import kotlin.coroutines.coroutineContext

class InstagramAdapter (
    private val storyList: List<StoryItem>,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<InstagramAdapter.ExampleViewHolder>() {


    inner class ExampleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView),
    View.OnClickListener{
        //where you cache the view and use it in the onbind later
        val imageView: ImageView = itemView.storyImageView
        val userNameTextView: TextView = itemView.userNameTextView1

        //define the button you want to have an action on
        val igtvButton = itemView.findViewById<Button>(R.id.clickmeButton)
        val storyImage = itemView.findViewById<ImageView>(R.id.storyImageView)



            //create onclick listener on the specific item
        init {
            itemView.setOnClickListener(this)

            //set up the specific element
                igtvButton.setOnClickListener {
                    println("clickmebutton is tapped")
                    igtvButton.setBackgroundResource(R.drawable.clicked_bg)
                }

                storyImage.setOnClickListener{
                    println("storyImage is clicked")
//                    storyImage.setImageResource(R.drawable.category1)

                }
        }

        override fun onClick(v: View?) {

            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onStoryItemClick(position)
//                listener.onStoryImageClick(position)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {

        //row layout -- template, where you can copy it everytime
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.story_view,
            parent, false)

        return ExampleViewHolder(itemView)
    }

    override fun getItemCount(): Int {

        return storyList.size
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        //where to show the data on the view
        val currentItem = storyList[position]
        holder.imageView.setImageResource(currentItem.imageResource)
        holder.userNameTextView.text = currentItem.storyUserName

    }


    interface OnItemClickListener {
        fun onStoryItemClick(position: Int)


    }



}