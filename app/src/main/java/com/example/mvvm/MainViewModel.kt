package com.example.mvvm

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.data.SaveCounter
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val saveCounter: SaveCounter): ViewModel() {

    val counter = ObservableField(0)

    fun increaseCounter(){
        saveCounter.counter += 1
        sendValue()
    }

    fun decreaseCounter(){
        saveCounter.counter -= 1
        sendValue()
    }

    fun sendValue() {
        counter.set(saveCounter.counter)
    }

    /*@Suppress("UNCHECKED_CAST")
    class Factory(private val saveCounter: SaveCounter): ViewModelProvider.Factory{
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(saveCounter) as T
        }
    }*/
}