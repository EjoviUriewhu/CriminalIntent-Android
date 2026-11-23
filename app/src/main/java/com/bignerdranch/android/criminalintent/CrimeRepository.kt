
package com.bignerdranch.android.criminalintent

import android.content.Context
import java.util.UUID

class CrimeRepository {

    private var crimeDao: CrimeDao? = null

    fun initialize(context: Context) {
        val database = CrimeDatabase.getDatabase(context)
        crimeDao = database.crimeDao()
    }


    private val crimes = mutableListOf(
        Crime(title = "Theft"),
        Crime(title = "Assault"),
        Crime(title = "Fraud"),
        Crime(title = "Vandalism"),
        Crime(title = "Burglary")
    )

    fun getCrimes(): List<Crime> {
        return crimes.toList()
    }

    fun getCrime(id: UUID): Crime? {
        return crimes.find { it.id == id }
    }

    fun addCrime(crime: Crime) {
        crimes.add(crime)
    }

    fun updateCrime(crime: Crime) {
        val index = crimes.indexOfFirst {
            it.id == crime.id
        }

        if (index != -1) {
            crimes[index] = crime
        }
    }

    fun deleteCrime(crime: Crime) {
        crimes.removeAll {
            it.id == crime.id
        }
    }

    companion object{
        val instance: CrimeRepository by lazy { CrimeRepository() }
    }

}