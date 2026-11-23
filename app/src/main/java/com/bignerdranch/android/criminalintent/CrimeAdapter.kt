
package com.bignerdranch.android.criminalintent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CrimeAdapter(
    private val crimes: List<Crime>,
    private val onCrimeClicked: (Crime) -> Unit
) : RecyclerView.Adapter<CrimeHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CrimeHolder {

        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_crime, parent, false)

        return CrimeHolder(view)
    }

    override fun onBindViewHolder(
        holder: CrimeHolder,
        position: Int
    ) {
        val crime = crimes[position]

        holder.bind(crime, onCrimeClicked)
    }

    override fun getItemCount(): Int {
        return crimes.size
    }
}
