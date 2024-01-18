package com.rymin.todolist.page.list

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rymin.todolist.page.list.data.TodoListItem
import com.rymin.todolist.page.list.vm.ListViewModel
import com.rymin.todolist.ui.theme.ToDoListTheme

@Preview
@Composable
fun ListScreen() {
    viewModel<ListViewModel>().viewStart()

    ToDoListTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(modifier = Modifier
                    .clickable {

                    }, text = "+"
                )
                TodoList(viewModel = viewModel())

            }
        }
    }
}

@Preview
@Composable
fun CreateCircle() {
    var moneyCounter by remember {
        mutableStateOf(0)
    }
    Card(
        modifier = Modifier
            .padding(3.dp)
            .size(50.dp)
            .clickable {
                moneyCounter += 1
            },
        shape = CircleShape
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(color = Color.Red),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Tap $moneyCounter")
        }
    }
}


@Composable
fun TodoList(
    viewModel: ListViewModel = viewModel()
) {
    Column {
        viewModel.items.forEach { item ->
            TodoItem(item)
        }
    }
}
@Composable
fun TodoItem(item: TodoListItem, modifier: Modifier = Modifier) {
    Row {
        Text(
            text = item.message,
            modifier = modifier
        )
    }
}
