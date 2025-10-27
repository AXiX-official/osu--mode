
package com.github.axixofficial.osumode.listeners

import com.github.axixofficial.osumode.player.SoundPlayer
import com.intellij.openapi.editor.event.*
import com.intellij.openapi.editor.impl.EditorImpl

class OsuEditorListener : EditorFactoryListener {

    override fun editorCreated(event: EditorFactoryEvent) {
        val editor = event.editor
        editor.document.addDocumentListener(OsuDocumentListener())
        editor.addEditorMouseListener(OsuMouseListener())
    }
}

private class OsuDocumentListener : DocumentListener {
    private var beforeLength = 0

    override fun beforeDocumentChange(event: DocumentEvent) {
        beforeLength = event.document.textLength
    }

    override fun documentChanged(event: DocumentEvent) {
        val newLength = event.document.textLength
        if (newLength < beforeLength) {
            // Deletion
            SoundPlayer.play("back_space.wav")
        } else if (newLength > beforeLength) {
            // Insertion
            val fragment = event.newFragment.toString()
            when {
                fragment.contains("\n") -> SoundPlayer.play("enter.wav")
                fragment == " " -> SoundPlayer.play("space.wav")
                else -> SoundPlayer.playRandom()
            }
        }
    }
}

private class OsuMouseListener : EditorMouseListener {
    override fun mouseClicked(event: EditorMouseEvent) {
        // Play click sound only for main button clicks in the editing area
        if (!event.isConsumed && event.area == EditorMouseEventArea.EDITING_AREA && event.mouseEvent.button == 1) {
            SoundPlayer.play("click.wav")
        }
    }
}

