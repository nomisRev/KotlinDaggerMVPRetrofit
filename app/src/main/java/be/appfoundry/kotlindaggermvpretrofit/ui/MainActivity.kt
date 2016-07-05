package be.appfoundry.kotlindaggermvpretrofit.ui

import android.os.Bundle
import android.util.Log
import be.appfoundry.kotlindaggermvpretrofit.KotlinApp
import be.appfoundry.kotlindaggermvpretrofit.core.mvp.MVPBaseActivity

class MainActivity : MVPBaseActivity<MainPresenter, MainComponent>(), MainView {

  override fun createComponent(): MainComponent =
      DaggerMainComponent.builder().applicationComponent(KotlinApp.component).build()

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    presenter.getData()
  }

  override fun printRepo(text: String) {
    Log.e("MainActivity",text)
  }
}