
package com.bignerdranch.android.criminalintent

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import java.util.UUID

class CrimeViewModel : ViewModel() {

    private val crimeRepository = CrimeRepository.instance

    fun getCrime(id: UUID): Crime? {
        return crimeRepository.getCrime(id)
    }

    fun addCrime(crime: Crime) {
        viewModelScope.launch {
            crimeRepository.addCrime(crime)
        }
    }

    fun updateCrime(crime: Crime) {
        viewModelScope.launch {
            crimeRepository.updateCrime(crime)
        }
    }

    fun deleteCrime(crime: Crime) {
        viewModelScope.launch {
            crimeRepository.deleteCrime(crime)
        }
    }
}
