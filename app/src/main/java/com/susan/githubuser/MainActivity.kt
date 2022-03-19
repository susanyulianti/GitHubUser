package com.susan.githubuser

import android.content.Intent
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.susan.githubuser.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var rvUser: RecyclerView
    private val list = ArrayList<GitUser>()

    companion object{
        const val DETAIL_USER = "detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        rvUser = findViewById(R.id.rv_user)
        rvUser.setHasFixedSize(true)

        list.addAll(listUser)
        showRecyclerList()
    }

    private val listUser: ArrayList<GitUser>
        get() {
            val userName = resources.getStringArray(R.array.username)
            val name = resources.getStringArray(R.array.name)
            val photo = resources.obtainTypedArray(R.array.avatar)
            val dataRepository = resources.getStringArray(R.array.repository)
            val location = resources.getStringArray(R.array.location)
            val company = resources.getStringArray(R.array.company)
            val dataFollowers = resources.getStringArray(R.array.followers)
            val dataFollowing = resources.getStringArray(R.array.following)
            val listUser = ArrayList<GitUser>()
            for (i in name.indices) {
                val user = GitUser(userName[i], name[i], photo.getResourceId(i, -1), dataRepository[i], location[i], company[i], dataFollowers[i], dataFollowing[i])
                listUser.add(user)
            }
            return listUser
        }

    private fun showRecyclerList() {
        rvUser.layoutManager = GridLayoutManager(this, 2)
        if (applicationContext.resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            rvUser.layoutManager = GridLayoutManager(this, 2)
        } else {
            rvUser.layoutManager = LinearLayoutManager(this)
        }

        val GitUserAdapter = GitUserAdapter(list)
        rvUser.adapter = GitUserAdapter

        GitUserAdapter.setOnItemClickCallback(object : GitUserAdapter.OnItemClickCallback {
            override fun onItemClicked(data: GitUser) {
                val moveintent = Intent(this@MainActivity, DetailUser::class.java)
                moveintent.putExtra(DETAIL_USER, data)
                startActivity(moveintent)
            }
        })
    }
}