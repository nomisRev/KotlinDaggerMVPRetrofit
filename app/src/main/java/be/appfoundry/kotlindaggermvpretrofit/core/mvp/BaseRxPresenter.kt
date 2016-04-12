package be.appfoundry.kotlindaggermvpretrofit.core.mvp

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby.mvp.MvpView
import rx.Observable
import rx.Subscriber
import rx.subscriptions.CompositeSubscription

abstract class BaseRxPresenter<V : MvpView> : MvpBasePresenter<V>() {
  protected var subscriptions: CompositeSubscription = CompositeSubscription()

  override fun attachView(view: V) {
    super.attachView(view)
    subscriptions = CompositeSubscription()
  }

  override fun detachView(retainInstance: Boolean) {
    super.detachView(retainInstance)
    if (!retainInstance) {
      subscriptions.unsubscribe()
    }
  }

  inner class RxSubscription<T> {

    fun add(observable: Observable<T>, subscriber: Subscriber<T>): RxSubscription<T> {
      this@BaseRxPresenter.subscriptions.add(observable.subscribe(subscriber))
      return this
    }
  }
}