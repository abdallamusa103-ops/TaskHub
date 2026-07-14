package com.abdallamusa.taskhub.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.abdallamusa.taskhub.data.dummydata.sampleTasks
import com.abdallamusa.taskhub.data.model.Task
import com.abdallamusa.taskhub.ui.theme.BackgroundDark
import com.abdallamusa.taskhub.ui.theme.BackgroundLight
import com.abdallamusa.taskhub.ui.theme.CoolSlateBackground
import com.abdallamusa.taskhub.ui.theme.SurfaceDark
import com.abdallamusa.taskhub.ui.theme.TextSecondaryLight

@Composable
fun TaskDetailedCard(
    task: Task,

    ) {

    Column(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        Card(
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 3.dp),
            shape = RoundedCornerShape(16.dp)

        ) {
            Column(
                Modifier.fillMaxWidth().padding(20.dp),
              //  horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Row(
                    Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(CircleShape)
                            .background(color = task.priority.textColor)
                    )
                    Text(
                        text = task.priority.label,
                        style = MaterialTheme.typography.bodyMedium,
                        fontWeight = FontWeight.Normal,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                Text(
                    text = task.title,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    text = task.description,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

            }
        }


        Spacer(Modifier.height(10.dp))


        Card(
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            colors = CardDefaults.cardColors(
                containerColor = CoolSlateBackground
            ),
            shape = RoundedCornerShape(16.dp)

        ) {
            Row (
                Modifier.fillMaxWidth().padding(horizontal = 20.dp , vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(
                    text = "Priority",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,

                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = task.priority.label,

                    Modifier
                        .clip(ShapeDefaults.Small)
                        .background(task.priority.containerColor)
                        .padding(vertical = 5.dp, horizontal = 10.dp),
                    color =  task.priority.textColor
                )
            }

            Row(
                Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Due Date",
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.Normal,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Row(verticalAlignment = Alignment.CenterVertically
                , horizontalArrangement = Arrangement.spacedBy(5.dp)) {
                    Icon(Icons.Outlined.DateRange, contentDescription = "Date Calender Icon")
                    Text(task.dueDate)



                }
            }


        }


    }


}


@Preview
@Composable
fun TaskDetailedCardPreview() {

    TaskDetailedCard(task = sampleTasks()[4])
}