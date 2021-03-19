package com.artimanton.wiki.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.artimanton.wiki.model.Character


@Database(entities = arrayOf(Character::class), version = 1)
abstract class RoomDB : RoomDatabase() {
        private var instance: RoomDB? = null
        abstract fun characterDao(): CharacterDao?

        companion object {
                private lateinit var context: Context
                private val database: RoomDB by lazy(LazyThreadSafetyMode.SYNCHRONIZED) {
                        Room.databaseBuilder(context, RoomDB::class.java, "character.db")
                                .fallbackToDestructiveMigration()
                                .build()
                }
                fun getInstance(context: Context): RoomDB? {
                        this.context = context.applicationContext
                        return database
                }
        }


}