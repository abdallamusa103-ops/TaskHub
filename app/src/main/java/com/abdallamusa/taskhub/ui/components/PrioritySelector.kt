package com.abdallamusa.taskhub.ui.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdallamusa.taskhub.data.dummydata.sampleTasks
import com.abdallamusa.taskhub.data.model.Priority
import com.abdallamusa.taskhub.ui.theme.BackgroundDark
import com.abdallamusa.taskhub.ui.theme.BackgroundLight
import com.abdallamusa.taskhub.ui.theme.PrimaryBlue
import com.abdallamusa.taskhub.ui.theme.PrimaryBlueDark
import com.abdallamusa.taskhub.ui.theme.SurfaceDark
import com.abdallamusa.taskhub.ui.theme.SurfaceLight
import com.abdallamusa.taskhub.ui.theme.TextSecondaryLight

@Composable
fun PrioritySelector(

    selectedPriority: Priority,
    onPrioritySelected: (Priority) -> Unit
) {

    FlowRow(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Priority.entries.forEach { priority ->
            val isSelectedPriority = (priority == selectedPriority)

            val backgroundColor = if (isSelectedPriority) Color(0xFFC4D3FF) else SurfaceLight
            val textColor = if (isSelectedPriority) PrimaryBlue else TextSecondaryLight
            val border = if (isSelectedPriority) null else BorderStroke(1.dp, Color(0xFFCCCCCC))
            val fontWeight = if (isSelectedPriority) FontWeight.SemiBold else FontWeight.Normal
            Card(
                shape = ShapeDefaults.Small,
                colors = CardDefaults.cardColors(
                    containerColor = backgroundColor,

                ),
                border = border,
                modifier = Modifier.clickable{onPrioritySelected(priority)}
            ) {
                Text(text = priority.label ,
                    style = MaterialTheme.typography.labelMedium.
                    copy(fontWeight = fontWeight, color = textColor),
                    modifier = Modifier.padding(vertical = 10.dp , horizontal = 20.dp))
            }

        }

    }

}


@Preview(showBackground = true)
@Composable
fun PrioritySelectorPreview() {
    PrioritySelector(
        selectedPriority = sampleTasks()[0].priority,
        onPrioritySelected = {}
    )

}