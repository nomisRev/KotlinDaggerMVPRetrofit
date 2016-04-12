package be.appfoundry.kotlindaggermvpretrofit.core.mvp

import com.hannesdorfmann.mosby.mvp.MvpPresenter
import com.hannesdorfmann.mosby.mvp.MvpView

interface MvpComponent<V : MvpView, out P : MvpPresenter<V>> {
  fun presenter(): P
}