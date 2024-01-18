package com.rymin.todolist.page.list.data

data class TodoListItem(val message: String)


data class TodoListItems(
    private val list: List<TodoListItem>
) {

    companion object {
        fun empty(): TodoListItems = TodoListItems(listOf())
    }

    override fun toString(): String {
        return "DeviceListItems(list=$list)"
    }

    fun copyMutableList(): List<TodoListItem> = list.toMutableList()
}

