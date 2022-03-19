package com.susan.githubuser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.susan.githubuser.databinding.ActivityDetailUserBinding

class DetailUser : AppCompatActivity() {
    private lateinit var binding: ActivityDetailUserBinding

    private val DETAIL_USER = "detail"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailUserBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val data = intent.getParcelableExtra<GitUser>(DETAIL_USER) as GitUser
        binding.tvname.text = data.name
        binding.tvusername.text = data.username
        binding.imgUser.setImageResource(data.avatar)
        binding.tvlocation.text = data.location
        binding.tvcompany.text = data.company
        binding.tvrepo.text = data.repository
        binding.tvfollowers.text = data.followers
        binding.tvfollowing.text = data.following
    }
}