package com.example.instagramclone

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.text.method.ScrollingMovementMethod
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_video.*
import kotlinx.android.synthetic.main.feed_view.*


class MainActivity : AppCompatActivity(), InstagramAdapter.OnItemClickListener, FeedAdapter.OnItemClickListener {

    private val storyList = generateRandomStoryData(100)
    private val storyAdapter = InstagramAdapter(storyList, this)
    private var heartIsClicked : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        println("the app just started")

        //get the story feed view
        storyRecycleView.adapter = InstagramAdapter(storyList, this)
        storyRecycleView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        storyRecycleView.setHasFixedSize(true)


        //get the  feed recycle view
        val feedList = generateRandomFeedData(100)
        feedRecycleView.adapter = FeedAdapter(feedList,this)
        feedRecycleView.layoutManager =
            LinearLayoutManager(this)
        feedRecycleView.setHasFixedSize(true)

    }


    private fun generateRandomStoryData(size: Int): ArrayList<StoryItem> {
        val list = ArrayList<StoryItem>()

        for (i in 0 until size) {
            val drawable = when (i % 8) {

                0 -> R.drawable.avatar1
                1 -> R.drawable.avatar2
                2 -> R.drawable.avatar3
                3 -> R.drawable.avatar4
                4 -> R.drawable.avatar5
                5 -> R.drawable.avatar6
                6 -> R.drawable.avatar7
                else -> R.drawable.avatar8
            }

            val storyUserName = when (i % 8) {

                0 -> "Rose"
                1 -> "Salinas"
                2 -> "Nansi"
                3 -> "Lawson"
                4 -> "Chase"
                5 -> "Browning"
                6 -> "Jemma"
                else -> "Stout"
            }


            val item = StoryItem(drawable, storyUserName)
            list += item
        }
        return list
    }

    fun generateRandomFeedData(size: Int): ArrayList<FeedItem> {
        val list = ArrayList<FeedItem>()

        for (i in 0 until size) {


            val userImage = when (i % 8) {

                0 -> R.drawable.avatar8
                1 -> R.drawable.avatar7
                2 -> R.drawable.avatar6
                3 -> R.drawable.avatar5
                4 -> R.drawable.avatar4
                5 -> R.drawable.avatar3
                6 -> R.drawable.avatar2
                else -> R.drawable.avatar1
            }


            val feedImage = when (i % 9) {

                0 -> R.drawable.category1
                1 -> R.drawable.category2
                2 -> R.drawable.category3
                3 -> R.drawable.category4
                4 -> R.drawable.category5
                5 -> R.drawable.category6
                6 -> R.drawable.category7
                7 -> R.drawable.category8
                8 -> R.drawable.category9
                else -> R.drawable.category10
            }

            val userName = when (i % 9) {

                0 -> "Murphy Mcguire"
                1 -> "Amrita Mcnamara"
                2 -> "Jamie-Lee Middleton"
                3 -> "Zeshan Rennie"
                4 -> "Rickie Bright"
                5 -> "Lucia Truong"
                6 -> "Emilie Acevedo"
                7 -> "Jennie Lloyd"
                8 -> "Rafi Mcmahon"
                else -> "Angelica Sparks"
            }

            val userLoaction = when (i % 9) {

                0 -> "Stockton-on-Tees (UK)"
                1 -> "Kingsteignton (UK)"
                2 -> "Ceduna(AU)"
                3 -> "Boonville (US)"
                4 -> "Park Ridge (US)"
                5 -> "Wokingham (UK)"
                6 -> "Hartland (UK)"
                7 -> "Marinette (US)"
                8 -> "Stuttgart (US)"
                else -> "Palm Beach (US)"
            }

            val item = FeedItem(userImage,userName,userLoaction,feedImage)
            list += item
        }
        return list


    }


    override fun onFeedItemClick(position: Int) {

        println("feed item $position clicked")

    }
    override fun onStoryItemClick(position: Int) {


//        //set up the action when the whole item is clicked
//        Toast.makeText(this, "item $position clicked", Toast.LENGTH_SHORT).show()
//
//        val clickedItem: StoryItem = storyList[position]
//        clickedItem.storyUserName = "beautiful"
//        clickedItem.imageResource = R.drawable.account
//
//        storyAdapter.notifyItemChanged(position)

//        or you can pass the data to a different page
    }


    fun onShare(view: View){
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        val shareBody = "Here is the share content body"
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, "Subject Here")
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        ContextCompat.startActivity(this,Intent.createChooser(sharingIntent, "Share via"),null)
//        startActivity(sharingIntent)
    }

    fun onCamera(view: View){

        //open up the camera
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(cameraIntent)
    }


    fun onTV(view: View){
        startActivity(Intent(this, VideoActivity::class.java))
    }

}


