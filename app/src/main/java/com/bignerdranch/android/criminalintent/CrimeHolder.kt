
package com.bignerdranch.android.criminalintent

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.DateFormat
import java.util.Date

class CrimeHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {

    private val titleTextView: TextView =
        itemView.findViewById(R.id.crime_title)

    private val dateTextView: TextView =
        itemView.findViewById(R.id.crime_date)

    fun bind(
        crime: Crime,
        onCrimeClicked: (Crime) -> Unit
    ) {
        titleTextView.text = crime.title

        dateTextView.text =
            DateFormat.getDateInstance()
                .format(Date(crime.date))

        itemView.setOnClickListener {
            onCrimeClicked(crime)
        }
    }
}
