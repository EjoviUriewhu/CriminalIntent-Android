
package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class CrimeListViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.instance

    fun getCrimes(): List<Crime> {
        return crimeRepository.getCrimes()
    }

    fun addCrime(crime: Crime) {
        viewModelScope.launch {
            crimeRepository.addCrime(crime)
        }
    }

    fun deleteCrime(crime: Crime) {
        viewModelScope.launch {
            crimeRepository.deleteCrime(crime)
        }
    }
}
