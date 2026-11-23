
package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import androidx.lifecycle.ViewModelProvider
import java.util.UUID

class CrimeListFragment :
    Fragment(R.layout.fragment_crime_list) {

    private lateinit var crimeRecyclerView: RecyclerView

    private lateinit var crimeListViewModel: CrimeListViewModel

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        crimeListViewModel =
            ViewModelProvider(this)[CrimeListViewModel::class.java]

        crimeRecyclerView =
            view.findViewById(R.id.crime_recycler_view)

        crimeRecyclerView.layoutManager =
            LinearLayoutManager(requireContext())

        updateCrimeList()

        val addCrimeButton =
            view.findViewById<FloatingActionButton>(
                R.id.add_crime_button
            )

        addCrimeButton.setOnClickListener {
            openCrimeDetails(null)
        }
    }

    private fun updateCrimeList() {

        val crimes = crimeListViewModel.getCrimes()

        crimeRecyclerView.adapter =
            CrimeAdapter(crimes) { crime ->
                openCrimeDetails(crime.id)
            }
    }

    private fun openCrimeDetails(crimeId: UUID?) {

        val fragment = CrimeFragment()

        fragment.arguments = Bundle().apply {
            putString("crime_id", crimeId?.toString())
        }

        parentFragmentManager.commit {

            setReorderingAllowed(true)

            replace(
                R.id.fragment_container,
                fragment
            )

            addToBackStack(null)
        }
    }

    override fun onResume() {
        super.onResume()

        if (::crimeRecyclerView.isInitialized) {
            updateCrimeList()
        }
    }
}
