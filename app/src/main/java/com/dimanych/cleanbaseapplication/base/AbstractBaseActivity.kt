package com.dimanych.cleanbaseapplication.base

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.widget.Toast

import com.dimanych.cleanbaseapplication.util.bind.LayoutBinder

import javax.inject.Inject

import butterknife.ButterKnife
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ru.terrakok.cicerone.Navigator
import ru.terrakok.cicerone.NavigatorHolder

/**
 * @author Dmitriy Grigoriev
 */
abstract class AbstractBaseActivity<in V : BaseView, P : BasePresenter<V>, N : Navigator> : AppCompatActivity(),
        HasSupportFragmentInjector, BaseView {

    @Inject
    lateinit var fragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var presenter: P
    @Inject
    lateinit var navigator: N
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    override fun supportFragmentInjector(): AndroidInjector<Fragment>? {
        return fragmentInjector
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)

        LayoutBinder.bind(this)

        presenter.takeView(this as V)
    }

    override fun setContentView(@LayoutRes layoutResID: Int) {
        super.setContentView(layoutResID)
        ButterKnife.bind(this)
    }

    override fun onDestroy() {
        presenter.detachFromView()
        super.onDestroy()
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }

    override fun onError(message: String?) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
