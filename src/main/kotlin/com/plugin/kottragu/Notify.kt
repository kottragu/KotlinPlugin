package com.plugin.kottragu

import com.intellij.notification.NotificationDisplayType
import com.intellij.notification.NotificationGroup
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.plugin.kottragu.service.TimerService


class Notify : StartupActivity {
    companion object {
        private val STICKY_GROUP = NotificationGroup("demo.notifications.balloon",
            NotificationDisplayType.STICKY_BALLOON, true)
    }

    override fun runActivity(project: Project) {
        TimerService.project = project
        TimerService.notificationGroup = STICKY_GROUP
    }
}