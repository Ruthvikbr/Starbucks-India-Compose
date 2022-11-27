package com.ruthvikbr.data.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ruthvikbr.data.local.OrderMenuItems
import com.ruthvikbr.data.local.StarbucksDao
import com.ruthvikbr.data.local.StarbucksDatabase
import com.ruthvikbr.data.repo.HomeRepoImpl
import com.ruthvikbr.data.repo.OrderRepoImpl
import com.ruthvikbr.domain.repo.HomeRepository
import com.ruthvikbr.domain.repo.OrderRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Provides
    @Singleton
    fun provideHomeRepo(): HomeRepository = HomeRepoImpl()

    @OptIn(DelicateCoroutinesApi::class)
    @Provides
    @Singleton
    fun provideStarbucksDatabase(
        @ApplicationContext context: Context,
        starbucksDaoProvider: Provider<StarbucksDao>
    ) =
        Room.databaseBuilder(context, StarbucksDatabase::class.java, "Starbucks_db")
            .addCallback(object : RoomDatabase.Callback() {
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    GlobalScope.launch {
                        OrderMenuItems.orderItemsList.forEach { item ->
                            starbucksDaoProvider.get().insertOrderItem(item)
                        }
                    }
                }
            }).build()

    @Provides
    @Singleton
    fun provideStarbucksDao(db: StarbucksDatabase) = db.starbucksDao()

    @Provides
    @Singleton
    fun provideOrderRepo(dao: StarbucksDao): OrderRepository = OrderRepoImpl(dao)
}
