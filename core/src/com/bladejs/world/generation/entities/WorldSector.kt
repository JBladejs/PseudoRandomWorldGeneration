package com.bladejs.world.generation.entities

import com.badlogic.gdx.graphics.Color

class WorldSector(private var type: SectorType) {
    enum class SectorType(var color: Color) {
        FOREST(Color.GREEN), WATER(Color.BLUE), MOUNTAINS(Color.RED), GROUND(Color.YELLOW)
    }
    val color = type.color
}