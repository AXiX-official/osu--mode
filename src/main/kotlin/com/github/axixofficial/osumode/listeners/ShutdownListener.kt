
package com.github.axixofficial.osumode.listeners

import com.github.axixofficial.osumode.player.SoundPlayer
import com.intellij.openapi.project.Project
import com.intellij.openapi.project.ProjectManagerListener

class ShutdownListener : ProjectManagerListener {
    override fun projectClosing(project: Project) {
        SoundPlayer.play("seeya.wav")
    }
}
