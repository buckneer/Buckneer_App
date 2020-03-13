package com.miftarisimel.buckneer.data.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.miftarisimel.buckneer.models.Project

object EventBus {
    private val liveDataBus = MutableLiveData<Event>()

    val events: LiveData<Event> = liveDataBus

    fun publish(event: Event) {
        liveDataBus.value = event
    }
}

sealed class Event {
    data class CreateProject(val post: Project) : Event()
}