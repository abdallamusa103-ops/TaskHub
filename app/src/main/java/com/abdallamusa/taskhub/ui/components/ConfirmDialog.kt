package com.abdallamusa.taskhub.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.abdallamusa.taskhub.ui.theme.PrimaryBlue
import com.abdallamusa.taskhub.ui.theme.PrimaryBlueDark

@Composable
fun ConfirmDialog(
    title: String, message: String,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit
) {

    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text(text = title) },
        text = { Text(text = message) },
        confirmButton = {
            TextButton (onClick = onConfirm) {
                Text(text = "Confirm" , color = PrimaryBlue)
            }
        } ,
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "Cancel" , color = PrimaryBlue)
            }
        }


    )

}
@Preview(showBackground = true)
@Composable
fun ConfirmDialogPreview() {
    // 1. Wrap it in a parent Box container so there's an actual layout canvas
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        ConfirmDialog(
            title = "hello",
            message = "ok do it right now Please ?",
            onConfirm = {},
            onDismiss = {}
        )
    }
}