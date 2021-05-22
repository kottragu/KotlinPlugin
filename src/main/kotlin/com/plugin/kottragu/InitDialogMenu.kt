package com.plugin.kottragu

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.plugin.kottragu.service.TimerService

class InitDialogMenu : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        TimerService.project = e.project
        TimerService.opeDialogWindow()
    }
}