package com.bladejs.world.generation.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.OrthographicCamera
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.utils.Array
import com.bladejs.world.generation.WorldGenerationGame
import com.bladejs.world.generation.components.RNG
import com.bladejs.world.generation.entities.WorldSector

const val BOX_HEIGHT = 20
const val BOX_WIDTH = 20

class RandomWorldScreen(private val game: WorldGenerationGame): Screen {
    private val camera = OrthographicCamera()
    private val sectors = Array<Array<WorldSector>>()

    init {
        initiateSectors(Gdx.graphics.width, Gdx.graphics.height)
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        with(game.renderer){
            projectionMatrix = camera.combined
            begin(ShapeRenderer.ShapeType.Filled)
            for (i in 0 until sectors.size) {
                val sector = sectors[i]
                for (j in 0 until sector.size) {
                    color = sector[j].color
                    rect((i * BOX_WIDTH).toFloat(), (j * BOX_HEIGHT).toFloat(), BOX_WIDTH.toFloat(), BOX_HEIGHT.toFloat())
                }
            }
            end()
        }
    }

    override fun resize(width: Int, height: Int) {
        initiateSectors(width, height)
    }

    private fun initiateSectors(width: Int, height: Int) {
        camera.setToOrtho(false, width.toFloat(), height.toFloat())
        RNG.reset()
        sectors.clear()
        for (i in 0..width / BOX_WIDTH) {
            sectors.add(Array())
            for (j in 0..height / BOX_HEIGHT) {
                sectors[i].add(WorldSector(RNG.getSectorType()))
            }
        }
    }

    override fun hide() {}
    override fun show() {}
    override fun pause() {}
    override fun resume() {}
    override fun dispose() {}
}
