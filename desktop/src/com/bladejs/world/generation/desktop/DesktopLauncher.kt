package com.bladejs.world.generation.desktop

import com.badlogic.gdx.backends.lwjgl.LwjglApplication
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration
import com.bladejs.world.generation.WorldGenerationGame

object DesktopLauncher {
    @JvmStatic
    fun main(arg: Array<String>) {
        val config = LwjglApplicationConfiguration()
        with(config) {
            title = "World Generation"
            width = 1280
            height = 720
            LwjglApplication(WorldGenerationGame(), this)
        }
    }
}
