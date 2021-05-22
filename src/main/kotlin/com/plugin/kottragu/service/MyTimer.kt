package com.plugin.kottragu.service

import java.util.*

object MyTimer {
    private var timer: Timer = Timer()

    fun createTimerTask(timerTask: TimerTask, delay: Int) {
        timerRestart()
        timer.schedule(timerTask, delay.toLong(), delay.toLong())
    }

    private fun timerRestart() {
        timer.cancel()
        timer = Timer()
    }
}