package com.dimanych.cleanbaseapplication

import com.dimanych.cleanbaseapplication.data.main.MainLocalRepository
import com.dimanych.cleanbaseapplication.data.main.model.ImageData
import com.dimanych.cleanbaseapplication.util.SharedPreferencesHelper
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito

class MainLocalRepositoryTest {

    private lateinit var mainLocalRepository: MainLocalRepository
    private lateinit var preferencesHelper: SharedPreferencesHelper
    private lateinit var list: List<ImageData>

    @Before
    fun setUp() {
        preferencesHelper = Mockito.mock(SharedPreferencesHelper::class.java)
        mainLocalRepository = MainLocalRepository(preferencesHelper)
        list = listOf(ImageData(("one")), ImageData(("two")))

        Mockito.`when`(preferencesHelper.getImagesList())
                .thenReturn(Single.just(list))

        Mockito.`when`(preferencesHelper.putImagesData(list))
                .thenReturn(Completable.complete())

    }

    @Test
    fun loadImagesTest() {
        val testObserver = TestObserver<List<ImageData>>()
        mainLocalRepository.loadImages()
                .subscribe(testObserver)

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValue { it.size == 2 }
        testObserver.assertValue { it[0].imgSource == "one" }
        testObserver.assertValue { it[1].imgSource == "two" }
    }

    @Test
    fun loadImageTest() {
        val testObserver = TestObserver<ImageData>()
        mainLocalRepository.loadImage(0)
                .subscribe(testObserver)

        testObserver.assertComplete()
        testObserver.assertNoErrors()
        testObserver.assertValue { it.imgSource == "one" }
    }

    @Test
    fun saveImagesTest() {
        val testObserver = TestObserver<Completable>()
        mainLocalRepository.saveImages(list)
                .subscribe(testObserver)

        testObserver.assertComplete()
        testObserver.assertNoErrors()
    }

}