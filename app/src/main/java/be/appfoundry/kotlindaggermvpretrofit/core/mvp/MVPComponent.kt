package be.appfoundry.kotlindaggermvpretrofit.core.mvp



interface MVPComponent<P : MVPPresenter> {
  fun presenter(): P
}