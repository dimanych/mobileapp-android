package com.dimanych.cleanbaseapplication.presentation.main.submain

import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.dimanych.cleanbaseapplication.R
import com.dimanych.cleanbaseapplication.base.AbstractBaseFragment
import com.dimanych.cleanbaseapplication.util.bind.Layout
import kotlinx.android.synthetic.main.fragment_main.*
import timber.log.Timber

@Layout(R.layout.fragment_main)
class MainFragment : AbstractBaseFragment<SubMainView, SubMainPresenter>(), SubMainView {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter.loadData()
        btnAddActiveReport.setOnClickListener {
            Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDataLoaded(data: String) {
        Timber.d("loaded $data")
    }

}
