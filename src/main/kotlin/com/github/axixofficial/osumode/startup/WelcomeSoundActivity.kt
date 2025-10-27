package com.github.axixofficial.osumode.startup

import com.github.axixofficial.osumode.player.SoundPlayer
import com.intellij.openapi.project.Project
import com.intellij.openapi.startup.ProjectActivity

class WelcomeSoundActivity : ProjectActivity {

    override suspend fun execute(project: Project) {
        SoundPlayer.play("welcome.wav")
    }
}