package com.abdallamusa.taskhub.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ShapeDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.abdallamusa.taskhub.data.model.Priority
import com.abdallamusa.taskhub.data.model.Task
import com.abdallamusa.taskhub.ui.components.DatePickerDialog
import com.abdallamusa.taskhub.ui.components.PrioritySelector
import com.abdallamusa.taskhub.ui.theme.PrimaryBlue
import com.abdallamusa.taskhub.ui.theme.SurfaceLight

@OptIn(ExperimentalMaterial3Api::class)
@Composable

fun TaskFormScreen(
    isEditingMode: Boolean,
    task: Task,
    onTitleChange: (String) -> Unit,
    onDescriptionChange: (String) -> Unit,
    onPrioritySelected: (Priority) -> Unit,
    onDueDateChange: (Long?) -> Unit,
    onSaveClick: () -> Unit,
    onClickBack: () -> Unit


) {

    var showDatePicker by rememberSaveable { mutableStateOf(false) }

    Scaffold(
        containerColor = Color(0xFFF8F9FA),
        contentColor = MaterialTheme.colorScheme.primary,
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0XFFF8F9FA),
                    navigationIconContentColor = MaterialTheme.colorScheme.onSurface,
                    titleContentColor = MaterialTheme.colorScheme.onSurface
                ),
                navigationIcon = {
                    IconButton(onClick = onClickBack) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "ArrowBack Icon"
                        )
                    }
                },
                title = {
                    Text(
                        text = if (isEditingMode) "Edit Task" else "New Task",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Normal
                    )
                },

                )
        }

    ) { innerPadding ->

        Column(
            Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .padding(
                    horizontal = 16.dp,
                    vertical = 10.dp
                ), verticalArrangement = Arrangement.spacedBy(10.dp)

        )

        {

            OutlinedTextField(
                value = task.title,
                onValueChange = { onTitleChange(it) },
                label = { Text(text = "Title") },
                shape = ShapeDefaults.Small,
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedLabelColor = PrimaryBlue,
                    focusedBorderColor = PrimaryBlue
                )

            )
            OutlinedTextField(

                value = task.description,
                onValueChange = { onDescriptionChange(it) },
                label = { Text(text = "Description") },
                shape = ShapeDefaults.Small,
                minLines = 6,
                        modifier = Modifier.fillMaxWidth(),

                                colors = OutlinedTextFieldDefaults.colors(
                                focusedLabelColor = PrimaryBlue,
                focusedBorderColor = PrimaryBlue
            )

            )
            OutlinedTextField(

                value = task.dueDate,
                onValueChange = {},
                label = { Text(text = "Due Date") },
                shape = ShapeDefaults.Small,
                singleLine = true,
                readOnly = true,

                trailingIcon = {
                    IconButton(onClick = { showDatePicker = true }) {
                        Icon(Icons.Outlined.DateRange, contentDescription = "Select Date")
                    }
                },

                modifier = Modifier.fillMaxWidth().clickable { showDatePicker = true },
                        colors = OutlinedTextFieldDefaults.colors(
                        focusedLabelColor = PrimaryBlue,
                focusedBorderColor = PrimaryBlue
            )
            )
            if (showDatePicker) {
                DatePickerDialog(
                    onConfirm = { selectedDateMillis ->
                        onDueDateChange(selectedDateMillis)
                        showDatePicker = false
                    },
                    onDismiss = {
                        showDatePicker = false
                    }
                )
            }

            Text("Priority" , color = Color.Black)
            PrioritySelector(
                selectedPriority = task.priority,
                onPrioritySelected = {
                    onPrioritySelected(it)
                }
            )
            Spacer(Modifier.height(10.dp))
            Button(
                onClick = { onSaveClick()},
                Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = PrimaryBlue
                ),
                shape = ShapeDefaults.Small
            ){
                Text(
                    if (isEditingMode) "Save Changes" else "Create Task",
                    color = Color.White
                )
            }
        }


    }

}