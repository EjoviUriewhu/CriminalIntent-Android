
package com.bignerdranch.android.criminalintent

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.fragment.app.Fragment

class CrimeFragment : Fragment(R.layout.fragement_crime) {

    private lateinit var crimeViewModel: CrimeViewModel

    private lateinit var crimeTitle: EditText
    private lateinit var crimeSolved: CheckBox
    private lateinit var saveCrimeButton: Button

    override fun onViewCreated(
        view: View,
        savedInstanceState: Bundle?
    ) {
        super.onViewCreated(view, savedInstanceState)

        crimeViewModel =
            ViewModelProvider(this)[CrimeViewModel::class.java]

        crimeTitle = view.findViewById(R.id.crime_title_edit)
        crimeSolved = view.findViewById(R.id.crime_solved_checkbox)
        saveCrimeButton = view.findViewById(R.id.save_crime_button)

        saveCrimeButton.setOnClickListener {

            val title = crimeTitle.text.toString().trim()

            if (title.isEmpty()) {
                crimeTitle.error = "Please enter a crime title"
                return@setOnClickListener
            }

            val newCrime = Crime(
                title = title,
                isSolved = crimeSolved.isChecked
            )

            crimeViewModel.addCrime(newCrime)

            Toast.makeText(
                requireContext(),
                "Crime saved successfully",
                Toast.LENGTH_SHORT
            ).show()

            parentFragmentManager.popBackStack()
        }
    }
}
