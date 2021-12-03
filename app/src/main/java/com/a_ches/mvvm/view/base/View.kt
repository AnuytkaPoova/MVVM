package com.a_ches.mvvm.view.base

import com.a_ches.mvvm.model.data.AppState

interface View {

    fun renderData(appState: AppState)
}