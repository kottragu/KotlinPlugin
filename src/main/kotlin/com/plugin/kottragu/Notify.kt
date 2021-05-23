package com.plugin.kottragu

import com.intellij.notification.NotificationGroupManager
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.StartupActivity
import com.plugin.kottragu.service.TimerService


class Notify : StartupActivity {
    companion object {
        private val STICKY_GROUP = NotificationGroupManager.getInstance().getNotificationGroup("notification")
    }

    override fun runActivity(project: Project) {
        TimerService.project = project
        TimerService.notificationGroup = STICKY_GROUP
    }
}