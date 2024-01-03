package com.nuhin13.cleanarchitecturewithjetpackcompose.db

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.filters.SmallTest
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.dao.UserInfoDao
import com.nuhin13.cleanarchitecturewithjetpackcompose.db.table.UserInfo
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import javax.inject.Named

@HiltAndroidTest
@SmallTest
class UserInfoDaoTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Inject
    @Named("Dummy_Database")
    lateinit var database: DummyProjectDatabase
    private lateinit var userDao: UserInfoDao

    @Before
    fun setup() {
        hiltRule.inject()
        userDao = database.userInfoDao()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertUser() = runBlocking {
        val user = UserInfo(
            phoneNumber = "01700000000",
            pin = "1234",
            email = "bugi.ll.com",
            id = 1
        )
        userDao.insert(user)
        val allUsers = userDao.fetchAll()

        assertEquals(allUsers[0], user)
    }
}