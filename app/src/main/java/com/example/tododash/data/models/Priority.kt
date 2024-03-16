package com.example.tododash.data.models


import androidx.compose.ui.graphics.Color
import com.example.tododash.ui.theme.HighPriorityColor
import com.example.tododash.ui.theme.LowPriorityColor
import com.example.tododash.ui.theme.MediumPriorityColor
import com.example.tododash.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}