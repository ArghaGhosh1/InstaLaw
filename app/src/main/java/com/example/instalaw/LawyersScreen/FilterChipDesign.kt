package com.example.instalaw.LawyersScreen

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterChipDesign(
    filterChipModel: FilterChipModel
) {

    var isSelected by remember() {
        mutableStateOf(false)
    }

    FilterChip(
        selected = isSelected,
        onClick = { isSelected = !isSelected },

        label = {
            Text(
                text = filterChipModel.title,
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        },

        trailingIcon = if (isSelected) {
            {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = null,
                    modifier = Modifier.size(16.dp),
                    tint = Color.White
                )
            }
        } else {
            null
        },

        shape = RoundedCornerShape(18.dp),

        colors = FilterChipDefaults.filterChipColors(
            selectedContainerColor = Color(0xFF1976D2),
            selectedLabelColor = Color.White,
            containerColor = Color(0xFFE8F0FE),
            labelColor = Color(0xFF334155)
        ),

        border = null
    )
}