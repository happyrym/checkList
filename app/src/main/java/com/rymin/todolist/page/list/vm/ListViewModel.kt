package com.rymin.todolist.page.list.vm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rymin.todolist.page.base.BaseViewModel
import com.rymin.todolist.page.list.data.TodoListItem
import com.rymin.todolist.page.list.data.TodoListItems
import com.rymin.todolist.page.list.ui.DeviceListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor() : BaseViewModel<ListViewModel.Event>() {

    sealed class Event {
        object Finish : Event()
        object AppExit : Event()

        class AddEvent(val message: String) : Event()
        object GotoAboutPage : Event()
    }

    private val _deviceListUiState = MutableStateFlow(DeviceListUiState.empty())
    val deviceListUiState: StateFlow<DeviceListUiState> = _deviceListUiState.asStateFlow()


    init {
        viewModelScope.launch {
            val deviceListItems = TodoListItems(listOf(TodoListItem("key 1")))
            _deviceListUiState.value = deviceListUiState.value.copy(loading = false, deviceListItems = deviceListItems)
        }
    }

    fun addTodoList(message: String) {
        var s = _deviceListUiState.value.deviceListItems.copyMutableList().toMutableList()
        s.add(TodoListItem("key $message"))
        val deviceListItems = TodoListItems(s)
        _deviceListUiState.value = deviceListUiState.value.copy(loading = false, deviceListItems = deviceListItems)
    }

    fun getTodoList(): List<TodoListItem> {
        return _deviceListUiState.value.deviceListItems.copyMutableList()
    }
}