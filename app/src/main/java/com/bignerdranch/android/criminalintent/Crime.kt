
package com.bignerdranch.android.criminalintent

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity(tableName = "crimes")
data class Crime(

    @PrimaryKey
    val id: UUID = UUID.randomUUID(),

    var title: String = "",

    var date: Long = System.currentTimeMillis(),

    var isSolved: Boolean = false,

    var suspect: String = ""
)
