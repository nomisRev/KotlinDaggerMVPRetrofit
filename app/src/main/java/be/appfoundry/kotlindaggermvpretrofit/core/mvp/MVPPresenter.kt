package be.appfoundry.kotlindaggermvpretrofit.core.mvp

interface MVPPresenter{

  fun attachView(view: MVPView)

  fun detachView()

  fun isViewAttached() : Boolean
}
