package com.joel.data.remote.dto

import com.joel.domain.model.ScreenShot

data class ScreenshotDTO(
    val id: Int,
    val image: String
) {
    fun toScreenShotDomain() : ScreenShot{
        return ScreenShot(
            id = id,
            image = image
        )
    }
}