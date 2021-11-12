package io.lb.stefaniniandroidchallenge.core.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.lb.stefaniniandroidchallenge.model.post.Post

@Dao
interface AppDao {
    @Query("SELECT * FROM posts")
    fun getAllRecords(): LiveData<List<Post>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertRecords(repositoryData: Post)

    @Query("DELETE FROM posts")
    fun deleteAllRecords()
}