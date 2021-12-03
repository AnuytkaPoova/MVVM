package com.a_ches.mvvm.view.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.a_ches.mvvm.model.data.AppState
import com.a_ches.mvvm.viewmodel.BaseViewModel

abstract class BaseActivity<T : AppState> : AppCompatActivity() {

    abstract val model: BaseViewModel<T>

    abstract fun renderData(appState: T)
}
