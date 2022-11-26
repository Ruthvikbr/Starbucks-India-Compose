package com.ruthvikbr.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ruthvikbr.data.models.OrderItem

@Database(entities = [OrderItem::class], version = 1, exportSchema = false)
abstract class StarbucksDatabase : RoomDatabase() {
    abstract fun starbucksDao(): StarbucksDao
}
