package com.dimanych.cleanbaseapplication.base

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast

import com.dimanych.cleanbaseapplication.util.bind.LayoutBinder

import javax.inject.Inject

import butterknife.ButterKnife
import dagger.android.support.AndroidSupportInjection

/**
 * @author Dmitrii Grigorev
 */
abstract class AbstractBaseFragment<in V : BaseView, P : BasePresenter<V>> : Fragment(), BaseView {

    @Inject
    lateinit var presenter: P

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return LayoutBinder.bind(inflater, this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        AndroidSupportInjection.inject(this)
        ButterKnife.bind(this, view)
        presenter.takeView(this as V)
    }

    override fun onDetach() {
        presenter.detachFromView()
        super.onDetach()
    }

    override fun onError(message: String?) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}
