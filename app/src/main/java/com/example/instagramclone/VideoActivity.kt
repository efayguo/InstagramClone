package com.example.instagramclone

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.MediaController
import kotlinx.android.synthetic.main.activity_video.*


//reference https://youtu.be/Jd3nTm-wvyA
class VideoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video)

        val mediaController = MediaController(this)
        mediaController.setAnchorView(videoView)

//        val onlineUri: Uri = Uri.parse("http://www.ebookfrenzy.com/android_book/movie.mp4")
        val offlineUri:Uri = Uri.parse("android.resource://$packageName/${R.raw.couple}")
//        val offlineUri:Uri = Uri.fromFile(new File(R.drawable.))

        videoView.setMediaController(mediaController)
        videoView.setVideoURI(offlineUri)
        videoView.requestFocus()
        videoView.start()
    }
}