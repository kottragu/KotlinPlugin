package com.plugin.kottragu.service

import com.intellij.notification.Notification
import com.intellij.notification.NotificationGroup
import com.intellij.notification.NotificationType
import com.intellij.openapi.project.Project
import com.plugin.kottragu.ui.DialogMenu
import java.util.*

object TimerService {
    var project: Project? = null
    lateinit var notificationGroup: NotificationGroup
    var time: Int = 3600000 // 1 hour
        set(value) {
            field = value*1000*60 // принимает минуты
        }

    fun opeDialogWindow() {
        val menu = DialogMenu(project!!)
        menu.show()
    }

    fun startTimer() {
        MyTimer.createTimerTask(createTimerTask(), time)
    }

    private fun createTimerTask(): TimerTask {
        return MyTimerTask();
    }

    class MyTimerTask: TimerTask() {
        override fun run() {
            val msg: Notification = notificationGroup.createNotification(
                "Napominanie",
                "You arbeitest uze " + time/(60*1000) + " minutes",
                "Take a rest for 5 min",
                NotificationType.INFORMATION
            )
            msg.notify(project )
        }
    }
}