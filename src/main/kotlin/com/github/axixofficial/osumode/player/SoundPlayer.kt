
package com.github.axixofficial.osumode.player

import javax.sound.sampled.AudioSystem
import kotlin.concurrent.thread

object SoundPlayer {

    fun play(sound: String) {
        thread(isDaemon = true) {
            try {
                val resourcePath = "/sounds/$sound"
                val audioInputStream = AudioSystem.getAudioInputStream(javaClass.getResource(resourcePath))
                val clip = AudioSystem.getClip()
                clip.open(audioInputStream)
                clip.start()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun playRandom() {
        val randomSound = "${(1..5).random()}.wav"
        play(randomSound)
    }
}
