package com.susan.githubuser

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitUser (
    var username: String?,
    var name: String?,
    var avatar: Int,
    var repository: String?,
    var company: String?,
    var location: String?,
    var followers: String?,
    var following: String?
) : Parcelable

