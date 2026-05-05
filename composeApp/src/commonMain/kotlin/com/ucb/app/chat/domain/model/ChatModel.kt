package com.ucb.app.chat.domain.model

enum class TypeChatEnum {
    INDIVIDUAL,
    GROUP
}

data class ChatModel(
    val id: String,
    val name: String,
    val imagen: String,
    val lastMessage: String,
    val timestamp: String,
    val messages: List<MessageModel>,
    val type: TypeChatEnum = TypeChatEnum.INDIVIDUAL
)