package com.a_ches.mvvm.di

import com.a_ches.mvvm.model.data.DataModel
import com.a_ches.mvvm.model.datasource.RetrofitImplementation
import com.a_ches.mvvm.model.datasource.RoomDataBaseImplementation
import com.a_ches.mvvm.model.repository.Repository
import com.a_ches.mvvm.model.repository.RepositoryImplementation
import com.a_ches.mvvm.view.main.MainInteractor
import com.a_ches.mvvm.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(
        RetrofitImplementation()
    ) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(
        RoomDataBaseImplementation()
    ) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}