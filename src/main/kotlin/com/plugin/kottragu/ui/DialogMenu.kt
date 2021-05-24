package com.plugin.kottragu.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.ui.DialogWrapper
import com.intellij.ui.JBColor
import com.plugin.kottragu.service.TimerService
import org.jdesktop.swingx.JXLabel
import org.jdesktop.swingx.JXPanel
import org.jdesktop.swingx.JXTextField
import javax.swing.JComponent

class DialogMenu (project: Project): DialogWrapper(project) {
    private var textField = JXTextField()
    private var dialogPanel = JXPanel()
    private var errorLabel = JXLabel()
    private var isError = false

    init {
        super.init()
        setSize(1000, 1000)
        title = "Timer manager"
    }

    override fun doOKAction() {
        val regex = Regex("\\d+")
        if (regex.matches(textField.text)) {
            super.doOKAction()
            TimerService.time = textField.text.toInt()
            TimerService.startTimer()
        } else if (!isError) {
            isError = true
            errorLabel.text = "Incorrect time"
            errorLabel.foreground = JBColor.RED
            dialogPanel.add(errorLabel)
        }
    }

    override fun createCenterPanel(): JComponent {
        val label = JXLabel("Input time in minutes")
        dialogPanel.add(label)
        textField.setSize(500, 250)
        textField.prompt = "InputText"
        dialogPanel.add(textField)
        return dialogPanel
    }
}