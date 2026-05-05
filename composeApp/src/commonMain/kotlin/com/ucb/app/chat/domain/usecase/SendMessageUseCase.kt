package com.ucb.app.chat.domain.usecase

import com.ucb.app.chat.domain.model.MessageModel
import com.ucb.app.chat.domain.repository.ChatRepository

class SendMessageUseCase(
    private val chatRepository: ChatRepository
) {
    suspend fun invoke(message: MessageModel, chatId: String) {

    }
}

// Individuales, Grupales