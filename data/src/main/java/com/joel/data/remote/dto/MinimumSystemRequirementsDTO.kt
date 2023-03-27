package com.joel.data.remote.dto

import com.joel.domain.model.MinimumSystemRequirements

data class MinimumSystemRequirementsDTO(
    val graphics: String,
    val memory: String,
    val os: String,
    val processor: String,
    val storage: String
) {
    fun toRequirementsDomain() : MinimumSystemRequirements{
        return MinimumSystemRequirements(
            graphics, memory, os, processor, storage
        )
    }
}