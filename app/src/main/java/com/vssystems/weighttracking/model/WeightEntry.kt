package com.vssystems.weighttracking.model

import java.util.Date

data class WeightEntry(
    private var id: Int,
    private var weight: Double,
    private var entryDate: Date
)