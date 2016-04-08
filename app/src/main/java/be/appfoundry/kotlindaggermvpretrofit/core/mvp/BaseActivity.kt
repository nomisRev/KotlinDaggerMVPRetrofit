package be.appfoundry.kotlindaggermvpretrofit.core.mvp

import android.os.Bundle
import android.support.annotation.LayoutRes
import com.hannesdorfmann.mosby.mvp.MvpActivity
import com.hannesdorfmann.mosby.mvp.MvpPresenter
import com.hannesdorfmann.mosby.mvp.MvpView

abstract class BaseActivity<V : MvpView, P : MvpPresenter<V>, C : MvpComponent<V, P>> : MvpActivity<V, P>(), MvpView {
  protected val component: C by lazy { createComponent() }

  protected abstract fun createComponent() : C

  override fun createPresenter(): P {
    return component.presenter()
  }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
  }

  override fun setContentView(@LayoutRes layoutResID: Int) {
    delegate.setContentView(layoutResID)
  }
}