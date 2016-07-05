package be.appfoundry.kotlindaggermvpretrofit.core.mvp

import java.lang.ref.WeakReference

abstract class MVPBasePresenter<V : MVPView> : MVPPresenter {

  private var viewRef: WeakReference<V>? = null

  override fun attachView(view: V) {
    viewRef = WeakReference(view)
  }

  fun getView(): MVPView? {
    return if (viewRef == null) null else (viewRef as WeakReference<MVPView>).get()
  }

  override fun isViewAttached(): Boolean = viewRef != null && (viewRef as WeakReference<V>).get() != null

  override fun detachView() {
    if (viewRef != null) {
      (viewRef as WeakReference<V>).clear()
      viewRef = null
    }
  }

}