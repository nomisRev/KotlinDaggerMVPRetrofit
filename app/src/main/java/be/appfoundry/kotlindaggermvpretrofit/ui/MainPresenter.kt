package be.appfoundry.kotlindaggermvpretrofit.ui

import com.hannesdorfmann.mosby.mvp.MvpPresenter

interface MainPresenter : MvpPresenter<MainView>{
  fun getData()
}