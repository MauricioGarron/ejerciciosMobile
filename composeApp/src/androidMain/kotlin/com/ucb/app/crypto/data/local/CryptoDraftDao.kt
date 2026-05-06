package com.ucb.app.crypto.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CryptoDraftDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveDraft(draft: CryptoDraftEntity)

    @Query("SELECT * FROM crypto_draft LIMIT 1")
    suspend fun getDraft(): CryptoDraftEntity?

    @Query("DELETE FROM crypto_draft")
    suspend fun clearDraft()
}