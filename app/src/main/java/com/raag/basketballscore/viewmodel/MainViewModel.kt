package com.raag.basketballscore.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var _localScore: MutableLiveData<Int> = MutableLiveData()
    private var _visitScore: MutableLiveData<Int> = MutableLiveData()

    val localScore: LiveData<Int>
    get() = _localScore
    val visitScore: LiveData<Int>
    get() = _visitScore

    init {
        resetScore()
    }

    fun resetScore() {
        _localScore.value = 0
        _visitScore.value = 0
    }

    fun aumentarPoint(point: Int, local: Boolean) {
        if (local) {
            _localScore.value = _localScore.value?.plus(point)
        } else {
            _visitScore.value = _visitScore.value?.plus(point)
        }
    }

    fun quitarPointLocal() {
        if (_localScore.value!! > 0) {
            _localScore.value = _localScore.value?.minus(1)
        }
    }

    fun quitarPointVisit() {
        if (_visitScore.value!! > 0) {
            _visitScore.value = _visitScore.value?.minus(1)
        }


    }
}