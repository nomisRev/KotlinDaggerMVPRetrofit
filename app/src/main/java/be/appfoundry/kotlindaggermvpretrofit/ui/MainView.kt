package be.appfoundry.kotlindaggermvpretrofit.ui

import be.appfoundry.kotlindaggermvpretrofit.core.mvp.MVPView

interface MainView : MVPView{
  fun printRepo(text: String)
}

