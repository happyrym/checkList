package com.rymin.todolist.page.list.ui

import com.rymin.todolist.page.list.data.TodoListItems


data class DeviceListUiState(
    val loading: Boolean,
    val deviceListItems: TodoListItems
) {
    companion object {
        fun empty(): DeviceListUiState = DeviceListUiState(true, TodoListItems.empty())
    }
}