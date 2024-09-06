package com.example.aidar_badirov_hw_5_1

import android.graphics.Color

class MainPresenter {

    private val model = CounterModel()
    private var contract: CounterContract? = null

    fun attachContract(contract: CounterContract) {
        this.contract = contract
    }

    fun onIncrement() {
        model.increment()
        val result = model.getResult()
        contract?.updateCount(result)
        checkForSpecialValue(result)
    }

    fun onDecrement() {
        model.decrement()
        val result = model.getResult()
        contract?.updateCount(result)
        checkForSpecialValue(result)
    }

    fun detachContract() {
        contract = null
    }

    private fun checkForSpecialValue(value: Int) {
        if (value == 10) {
            contract?.showToast("Поздравляю")
        }
        if (value == 15) {
            contract?.changeColor(Color.GREEN)
        } else {
            contract?.changeColor(Color.BLACK)
        }
    }
}