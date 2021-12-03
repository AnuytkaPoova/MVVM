package com.a_ches.mvvm.presenter

import com.a_ches.mvvm.view.base.View
import com.a_ches.mvvm.model.data.AppState

interface Presenter <T: AppState, V: View> {

    fun attachView(view: V)
    fun detachView(view: V)
    // Получение данных с флагом isOnline(из Интернета или нет)
    fun getData(word: String, isOnline: Boolean)

}