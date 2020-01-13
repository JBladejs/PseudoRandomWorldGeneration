package com.bladejs.world.generation

import com.badlogic.gdx.ApplicationAdapter
import com.badlogic.gdx.Game
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.bladejs.world.generation.screens.RandomWorldScreen
import javax.swing.Renderer

class WorldGenerationGame : Game() {
    lateinit var renderer: ShapeRenderer
    lateinit var gameScreen: Screen

    override fun create() {
        renderer = ShapeRenderer()
        renderer.setAutoShapeType(true)
        gameScreen = RandomWorldScreen(this)
        this.setScreen(gameScreen)
    }

    override fun dispose() {
        renderer.dispose()
        gameScreen.dispose()
    }
}
