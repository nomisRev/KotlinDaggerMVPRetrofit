package be.appfoundry.kotlindaggermvpretrofit.ui

import be.appfoundry.kotlindaggermvpretrofit.core.di.ActivityScope
import be.appfoundry.kotlindaggermvpretrofit.core.di.ApplicationComponent
import be.appfoundry.kotlindaggermvpretrofit.core.mvp.MvpComponent
import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(ApplicationComponent::class))
interface MainComponent : MvpComponent<MainView, MainPresenter> {
  override fun presenter(): MainPresenterImpl

}