package com.rymin.todolist.page.list.vm

import androidx.lifecycle.ViewModel
import com.rymin.todolist.page.list.data.TodoListItem

class ListViewModel : ViewModel() {
    lateinit var items: List<TodoListItem>
    fun viewStart() {
        items = listOf(TodoListItem(0, "message", false,""))
    }

    fun setTodoList(index: Int, message: String?, isDone: Boolean) {

    }
}