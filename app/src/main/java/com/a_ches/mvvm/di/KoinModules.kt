package com.a_ches.mvvm.di

import androidx.room.Room
import com.a_ches.mvvm.model.data.DataModel
import com.a_ches.mvvm.model.datasource.RetrofitImplementation
import com.a_ches.mvvm.model.datasource.RoomDataBaseImplementation
import com.a_ches.mvvm.model.repository.Repository
import com.a_ches.mvvm.model.repository.RepositoryImplementation
import com.a_ches.mvvm.model.repository.RepositoryImplementationLocal
import com.a_ches.mvvm.model.repository.RepositoryLocal
import com.a_ches.mvvm.room.HistoryDataBase
import com.a_ches.mvvm.view.history.HistoryInteractor
import com.a_ches.mvvm.view.history.HistoryViewModel
import com.a_ches.mvvm.view.main.MainInteractor
import com.a_ches.mvvm.view.main.MainViewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}

val mainScreen = module {
    factory { MainViewModel(get()) }
    factory { MainInteractor(get(), get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}