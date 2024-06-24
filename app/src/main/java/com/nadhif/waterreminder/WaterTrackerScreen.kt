package com.nadhif.waterreminder

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun WaterTrackerScreen(navController: NavHostController, userViewModel: UserViewModel) {
    var waterIntake by remember { mutableStateOf(0) }
    var waterInput by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Water Intake Tracker",
            style = MaterialTheme.typography.headlineSmall
        )
        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Name: ${userViewModel.name.value}",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "Gender: ${userViewModel.gender.value}",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "Age: ${userViewModel.age.value}",
            style = MaterialTheme.typography.bodySmall
        )
        Text(
            text = "Weight: ${userViewModel.weight.value} kg",
            style = MaterialTheme.typography.bodySmall
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = waterInput,
            onValueChange = { waterInput = it },
            label = { Text("Enter water intake (ml)") }
        )
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            waterIntake += waterInput.toIntOrNull() ?: 0
            waterInput = ""
        }) {
            Text(text = "Add Water Intake")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Total Water Intake: $waterIntake ml",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {
            // scheduleWaterReminder(context)
        }) {
            Text(text = "Set Reminder")
        }
    }
}
