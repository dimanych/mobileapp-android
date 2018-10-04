package com.dimanych.cleanbaseapplication.base

import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.lang.ref.WeakReference


/**
 * @author Dmitriy Grigoriev
 */
abstract class AbstractBasePresenter<T : BaseView> : BasePresenter<T> {

    private var view: WeakReference<T>? = null
    /**
     * Subscribers for actions
     */
    private val disposables = CompositeDisposable()

    /**
     * For attaching to View
     */
    override fun takeView(t: T) {
        view = WeakReference(t)
        if (view != null) {
            onFirstAttach()
        }
    }

    /**
     * For detaching from View. Need for cleaning subscribes, etc
     */
    override fun detachFromView() {
        disposables.clear()
    }
    
    fun getView() = view?.get()

    /**
     * On first attach presenter can load some init data
     */
    open fun onFirstAttach() {}


    /**
     * Subscribers for interactions.
     * Every method has default flow switching for background and main flows,
     * also added onError default handler
     */

    fun <T> subscribe(observable: Single<T>, action: ((T) -> Unit)) {
        disposables.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ action.invoke(it) }, {
                    getView()?.onError(it.localizedMessage)
                    Timber.e(it)
                }))
    }

    fun <T> subscribe(observable: Maybe<T>, action: ((T) -> Unit)) {
        disposables.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ action.invoke(it) }, {
                    getView()?.onError(it.localizedMessage)
                    Timber.e(it)
                }))
    }

    fun <T> subscribe(observable: Flowable<T>, action: ((T) -> Unit)) {
        disposables.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ action.invoke(it) }, {
                    getView()?.onError(it.localizedMessage)
                    Timber.e(it)
                }))
    }

    fun subscribe(observable: Completable, action: (() -> Unit)) {
        disposables.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ action.invoke() },
                        { Timber.e(it) })
        )
    }

    fun subscribe(observable: Completable, action: (() -> Unit), error: ((Throwable) -> Unit)) {
        disposables.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ action.invoke() },
                        { error.invoke(it)
                            Timber.e(it) })
        )
    }

    fun <T> subscribe(observable: Single<T>, action: ((T) -> Unit), error: ((Throwable) -> Unit)) {
        disposables.add(observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ action.invoke(it) },
                        { error.invoke(it)
                            Timber.e(it) })
        )
    }
}
