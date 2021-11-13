package io.lb.stefaniniandroidchallenge.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.lb.stefaniniandroidchallenge.core.GeneralConstants
import io.lb.stefaniniandroidchallenge.model.post.Post

@Database(entities = [Post::class], version = 1, exportSchema = false)
@TypeConverters(StefaniniConverters::class)
abstract class AppDataBase: RoomDatabase() {
    abstract fun getAppDao(): AppDao

    companion object {
        private var dbInstance: AppDataBase? = null

        fun getAppDataBaseInstance(context: Context): AppDataBase {
            if (dbInstance == null) {
                dbInstance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDataBase::class.java,
                    GeneralConstants.DATABASE
                ).build()
            }
            return dbInstance!!
        }
    }
}