package com.bladejs.world.generation.components

import com.bladejs.world.generation.entities.WorldSector
import kotlin.math.abs

object RNG {
    private const val a = 12345
    private const val m = 16777216 // 2^24
    private const val c = 3545443 // ((3 - sqrt(3)) / 6) * m
    private const val originalSeed = 657895
    private var seed = originalSeed

    private fun getNumber() : Int {
        seed = abs((a * seed) + c) % m
        return (seed.toDouble() / m.toDouble() * 100).toInt()
    }

    fun getSectorType(): WorldSector.SectorType {
        val random = getNumber()
        if (random < 45) return WorldSector.SectorType.GROUND
        if (random < 65) return WorldSector.SectorType.FOREST
        if (random < 85) return WorldSector.SectorType.MOUNTAINS
        return WorldSector.SectorType.WATER
    }

    fun reset() {
        seed = originalSeed
    }
}