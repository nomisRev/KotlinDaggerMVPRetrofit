package be.appfoundry.kotlindaggermvpretrofit.ui

import android.util.Log
import be.appfoundry.kotlindaggermvpretrofit.core.mvp.MVPBasePresenter
import be.appfoundry.kotlindaggermvpretrofit.core.service.GitHubRepo
import be.appfoundry.kotlindaggermvpretrofit.core.service.GithubAPI
import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import javax.inject.Inject

class MainPresenterImpl @Inject constructor(githubAPI: GithubAPI) : MVPBasePresenter<MainView>(), MainPresenter {

  val githubAPI: GithubAPI = githubAPI
  val TAG = "MainPresenterImpl"

  override fun getData() {
    githubAPI.getData().flatMap { Observable.from(it) }.subscribeOn(Schedulers.io()).observeOn(
        AndroidSchedulers.mainThread()).subscribe(object : Subscriber<GitHubRepo>() {
      override fun onCompleted() {
        Log.e(TAG, "onCompleted")
      }

      override fun onError(e: Throwable?) {
        Log.e(TAG, e?.message)
      }

      override fun onNext(t: GitHubRepo?) {
        getView()?.
      }
    })
  }
}