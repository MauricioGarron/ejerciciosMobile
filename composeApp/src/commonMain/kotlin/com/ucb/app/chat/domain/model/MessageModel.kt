package com.ucb.app.chat.domain.model

data class MessageModel(
    val id: String,
    val content: String,
    val dateTime: String,
    val senderTo: String,  // pepe, Grupo
    val fromTo: String    // roberto, carlos, maria
)
