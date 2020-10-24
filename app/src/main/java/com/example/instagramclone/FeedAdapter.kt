package com.example.instagramclone

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivities
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView


class FeedAdapter (private val feedList: List<FeedItem>,
                   private val listener: OnItemClickListener
) : RecyclerView.Adapter<FeedAdapter.ExampleViewHolder>() {

    inner class ExampleViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener {
        //where you cache the view and use it in the onbind later
        val userImageView: ImageView = itemView.findViewById(R.id.feedUserImageView)
        val userNameTextView: TextView = itemView.findViewById(R.id.feedUserNameTextView)
        val userLocationTextView: TextView = itemView.findViewById(R.id.feedUserLocationTextView)
        val feedImageView: ImageView = itemView.findViewById(R.id.feedImageView)

        //setup more click listeners
        val heartIcon: ImageView = itemView.findViewById(R.id.heartIcon)
        val feedImage: ImageView = itemView.findViewById(R.id.feedImageView)
        var heartClicked = false
        val shareImage: ImageView = itemView.findViewById(R.id.sendIcon)

        //create onclick listener on the specific item
        init {
            itemView.setOnClickListener(this)

            heartIcon.setOnClickListener {
            if (heartClicked){
                heartIcon.setImageResource(R.drawable.heart)
                heartClicked = false
            }else{
                heartIcon.setImageResource(R.drawable.heartcilcked)
                heartClicked = true
                }
            }

            feedImage.setOnClickListener {
                if (heartClicked){
                    heartIcon.setImageResource(R.drawable.heart)
                    heartClicked = false
                }else{
                    heartIcon.setImageResource(R.drawable.heartcilcked)
                    heartClicked = true
                }
            }

            shareImage.setOnClickListener {



            }


        }

        override fun onClick(v: View?) {

            val position: Int = adapterPosition
            if (position != RecyclerView.NO_POSITION){
                listener.onFeedItemClick(position)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExampleViewHolder {

        //row layout -- template, where you can copy it everytime
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.feed_view,
            parent, false)

        return ExampleViewHolder(itemView)
    }




    override fun getItemCount(): Int {

        return feedList.size
    }

    override fun onBindViewHolder(holder: ExampleViewHolder, position: Int) {
        //where to show the data on the view
        val currentItem = feedList[position]
        holder.userImageView.setImageResource(currentItem.userImage)
        holder.userNameTextView.text = currentItem.userRealName
        holder.userLocationTextView.text = currentItem.userLocation
        holder.feedImageView.setImageResource(currentItem.feedImage)
    }

    interface OnItemClickListener {
        fun onFeedItemClick(position: Int)
    }

}