package be.appfoundry.kotlindaggermvpretrofit

import android.app.Application
import be.appfoundry.kotlindaggermvpretrofit.core.di.ApplicationComponent
import be.appfoundry.kotlindaggermvpretrofit.core.di.ApplicationModule
import be.appfoundry.kotlindaggermvpretrofit.core.di.DaggerApplicationComponent
import be.appfoundry.kotlindaggermvpretrofit.core.di.ServiceModule

class KotlinApp : Application() {

  companion object {
    lateinit var component: ApplicationComponent
  }

  override fun onCreate() {
    super.onCreate()

    component = DaggerApplicationComponent.builder()
        .serviceModule(ServiceModule())
        .applicationModule(ApplicationModule(this))
        .build()
  }
}