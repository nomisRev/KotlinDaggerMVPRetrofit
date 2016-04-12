package be.appfoundry.kotlindaggermvpretrofit.core.di

import android.content.Context
import be.appfoundry.kotlindaggermvpretrofit.core.service.GithubAPI
import dagger.Component

@ApplicationScope
@Component(modules = arrayOf(ApplicationModule::class,ServiceModule::class))
interface ApplicationComponent {

  val applicationContext : Context;

  val githubAPI : GithubAPI
}