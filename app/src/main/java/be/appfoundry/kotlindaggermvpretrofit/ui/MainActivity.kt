package be.appfoundry.kotlindaggermvpretrofit.ui

import android.os.Bundle
import be.appfoundry.kotlindaggermvpretrofit.KotlinApp
import be.appfoundry.kotlindaggermvpretrofit.core.mvp.BaseActivity

class MainActivity : BaseActivity<MainView, MainPresenter, MainComponent>(), MainView {

  override fun createComponent(): MainComponent =
      DaggerMainComponent.builder().applicationComponent(KotlinApp.component).build()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    presenter.getData()
  }
}