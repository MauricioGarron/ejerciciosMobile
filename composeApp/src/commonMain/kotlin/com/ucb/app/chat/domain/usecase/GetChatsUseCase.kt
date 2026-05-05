package com.ucb.app.chat.domain.usecase

import com.ucb.app.chat.domain.model.ChatModel
import com.ucb.app.chat.domain.repository.ChatRepository

class GetChatsUseCase(
    private val chatRepository: ChatRepository
) {
    suspend fun invoke(userId: String): List<ChatModel> {
        return chatRepository.getChats(userId)
    }
}