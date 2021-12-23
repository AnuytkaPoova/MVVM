package com.a_ches.mvvm.di

import androidx.room.Room
import com.a_ches.model.data.dto.SearchResultDto

import com.a_ches.mvvm.room.HistoryDataBase
import com.a_ches.mvvm.view.history.HistoryActivity
import com.a_ches.mvvm.view.history.HistoryInteractor
import com.a_ches.mvvm.view.history.HistoryViewModel
import com.a_ches.mvvm.view.main.MainActivity
import com.a_ches.mvvm.view.main.MainInteractor
import com.a_ches.mvvm.view.main.MainViewModel
import com.a_ches.repository.*
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResultDto>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResultDto>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}

val historyScreen = module {
    scope(named<HistoryActivity>()) {
        scoped { HistoryInteractor(get(), get()) }
        viewModel { HistoryViewModel(get()) }
    }
}
