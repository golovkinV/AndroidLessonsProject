package com.study.androidstudy.di


import com.github.terrakok.cicerone.Cicerone
import com.study.androidstudy.screens.auth.AuthViewModel
import com.study.androidstudy.screens.calculation.CalculationViewModel
import com.study.androidstudy.screens.hello.HelloViewModel
import com.study.androidstudy.screens.main.MainViewModel
import com.study.androidstudy.screens.math_calculation.MathCalculationViewModel
import com.study.androidstudy.screens.timeline.TimelineViewModel
import com.study.androidstudy.screens.timeline.add_timeline.AddTimelineViewModel
import com.study.androidstudy.screens.timeline.controllers.TimelineController
import com.study.androidstudy.screens.timeline.detail_timeline.DetailTimelineFragment
import com.study.androidstudy.screens.timeline.detail_timeline.DetailTimelineViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    val cicerone = Cicerone.create()
    single { cicerone.router }
    single { cicerone.getNavigatorHolder() }

    // Controllers

    single { TimelineController() }

    // View Models

    viewModel { MainViewModel(get()) }
    viewModel { HelloViewModel(get()) }
    viewModel { CalculationViewModel(get()) }
    viewModel { MathCalculationViewModel(get()) }
    viewModel { TimelineViewModel(get(), get()) }
    viewModel { AddTimelineViewModel(get()) }
    viewModel { DetailTimelineViewModel(get(), get()) }
    viewModel { AuthViewModel(get()) }
}