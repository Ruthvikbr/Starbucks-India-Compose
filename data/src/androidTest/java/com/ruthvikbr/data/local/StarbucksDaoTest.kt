package com.ruthvikbr.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import androidx.test.filters.SmallTest
import com.ruthvikbr.data.models.OrderItem
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
@SmallTest
@ExperimentalCoroutinesApi
class StarbucksDaoTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: StarbucksDatabase

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            getApplicationContext(),
            StarbucksDatabase::class.java
        ).build()
    }

    @After
    fun teardown() {
        database.close()
    }

    @Test
    fun insertOrderItemTest() = runTest {
        val orderItem = OrderItem(
            "Coffee",
            0,
            200,
            "sampleurl",
            "sample description",
            "Hot Coffee",
            1
        )

        database.starbucksDao().insertOrderItem(orderItem)

        val tasks = database.starbucksDao().getOrderItems("Hot Coffee")

        assert(tasks.first().contains(orderItem))
    }

    @Test
    fun updateOrderItemTest() = runTest {
        val orderItem = OrderItem(
            "Coffee",
            0,
            200,
            "sampleurl",
            "sample description",
            "Hot Coffee",
            1
        )

        database.starbucksDao().insertOrderItem(orderItem)

        val updateOrderItem = orderItem.copy(itemDescription = "Sample description")

        database.starbucksDao().updateOrderItem(updateOrderItem)

        val tasks = database.starbucksDao().getOrderItems("Hot Coffee")

        assert(tasks.first().contains(updateOrderItem))
        assert(tasks.first()[0].itemDescription == "Sample description")
    }

    @Test
    fun deleteOrderItemTest() = runTest {
        val orderItem = OrderItem(
            "Coffee",
            0,
            200,
            "sampleurl",
            "sample description",
            "Hot Coffee",
            1
        )

        database.starbucksDao().insertOrderItem(orderItem)

        val tasks = database.starbucksDao().getOrderItems("Hot Coffee")
        assert(tasks.first().contains(orderItem))

        database.starbucksDao().deleteOrderItem(orderItem)
        val tasksAfterDeletion = database.starbucksDao().getOrderItems("Hot Coffee")

        assert(!tasksAfterDeletion.first().contains(orderItem))
    }

    @Test
    fun retrieveOrderItemsForInactiveCategoryTest() = runTest {
        val orderItem = OrderItem(
            "Coffee",
            0,
            200,
            "sampleurl",
            "sample description",
            "Hot Coffee",
            1
        )

        database.starbucksDao().insertOrderItem(orderItem)

        val tasks = database.starbucksDao().getOrderItems("Hot Tea")
        assert(!tasks.first().contains(orderItem))
    }

    @Test
    fun retrieveCartItemsTest() = runTest {
        val orderItem1 = OrderItem(
            "Coffee",
            2,
            200,
            "sampleurl",
            "sample description",
            "Hot Coffee",
            1
        )
        val orderItem2 = OrderItem(
            "Coffee",
            0,
            200,
            "sampleurl",
            "sample description",
            "Hot Coffee",
            2
        )

        database.starbucksDao().insertOrderItem(orderItem1)
        database.starbucksDao().insertOrderItem(orderItem2)

        val tasks = database.starbucksDao().getCartItems()
        assert(tasks.first().contains(orderItem1))
        assert(!tasks.first().contains(orderItem2))
    }

    @Test
    fun deleteAllCartItemsTest() = runTest {
        val orderItem1 = OrderItem(
            "Coffee",
            2,
            200,
            "sampleurl",
            "sample description",
            "Hot Coffee",
            1
        )
        val orderItem2 = OrderItem(
            "Coffee",
            0,
            200,
            "sampleurl",
            "sample description",
            "Hot Coffee",
            2
        )

        database.starbucksDao().insertOrderItem(orderItem1)
        database.starbucksDao().insertOrderItem(orderItem2)

        database.starbucksDao().deleteAllCartItems()
        val tasks = database.starbucksDao().getCartItems()
        assert(tasks.first().isEmpty())
    }
}
