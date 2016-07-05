package be.appfoundry.kotlindaggermvpretrofit.core.mvp

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

abstract class MVPBaseActivity<P : MVPPresenter, C : MVPComponent<P>>() : AppCompatActivity(), MVPView {
  protected val component: C by lazy { createComponent() }
  protected val presenter: P by lazy { component.presenter() }
  protected var inBackground: Boolean = true;

  protected abstract fun createComponent() : C


  fun createPresenter(): P {
    return component.presenter()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    createPresenter()
    component.presenter().attachView(this)
  }

  fun isInBackground() : Boolean = inBackground

  fun isViewAttached() : Boolean = presenter.isViewAttached()

  override fun onResume() {
    super.onResume()
    inBackground = false;
  }

  override fun onStop() {
    inBackground = true;
    super.onStop()
  }

  override fun onDestroy() {
    component.presenter().detachView()
    super.onDestroy()
  }
}