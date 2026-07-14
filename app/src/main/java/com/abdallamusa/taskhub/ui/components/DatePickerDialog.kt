package com.abdallamusa.taskhub.ui.components

import androidx.compose.material3.DatePicker
import  androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable

@Composable
fun DatePickerDialog(

    onConfirm: (Long?) -> Unit,
    onDismiss: () -> Unit
){
    val datePickerState = rememberDatePickerState()
   DatePickerDialog(
       onDismissRequest = { onDismiss() },
       confirmButton = {
           // Use clean TextButtons with no surrounding borders for Material 3 design spec
           TextButton(
               onClick = {
                   // Extract the raw Long stopwatch count and pass it up
                   onConfirm(datePickerState.selectedDateMillis)

               }
           ) {
               Text("OK")
           }
       },
       dismissButton = {
           TextButton(
               onClick = {
                  onDismiss()

               }
           ) {
               Text("Cancel")
           }
       }
   )
   {
       DatePicker(state = datePickerState)
   }

}