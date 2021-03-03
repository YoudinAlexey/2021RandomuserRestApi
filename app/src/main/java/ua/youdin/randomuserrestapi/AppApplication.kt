package ua.youdin.randomuserrestapi

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module
import ua.youdin.randomuserrestapi.data.RandomUserRepository
import ua.youdin.randomuserrestapi.data.randomuserApi.RandomUserServise
import ua.youdin.randomuserrestapi.ui.load.LoadDataViewModel

class AppApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        addTheme()
        startKoin {
            androidLogger()
            androidContext(this@AppApplication)
            modules(appModule)
        }
    }

    private fun addTheme() {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        AppCompatDelegate.setDefaultNightMode(
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        )
    }

    private val appModule = module {
        single { RandomUserServise.create() }
        single { RandomUserRepository(get()) }
        viewModel { LoadDataViewModel(get()) }
    }
}