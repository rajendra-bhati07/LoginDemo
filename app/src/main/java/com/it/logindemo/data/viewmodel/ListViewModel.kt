package com.it.logindemo.data.viewmodel
import ListRepository
import RowData
import RowList
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
class ListViewModel(private val repository: ListRepository) : ViewModel() {
    val dataList = MutableLiveData<List<RowData>>()
    val errorMessage = MutableLiveData<String>()
    lateinit var disposable: Disposable

    fun getAllData() {
        // observer subscribing to observable
        val response = repository.getAllData()
        response.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getDataListObserver())
    }

    private fun getDataListObserver(): Observer<RowList> {
        return object : Observer<RowList> {
            override fun onComplete() {
                //hide progress bar
            }

            override fun onError(e: Throwable) {
                dataList.postValue(null)

            }

            override fun onNext(t: RowList) {
                dataList.postValue(t.mList)
            }

            override fun onSubscribe(d: Disposable) {
                disposable = d
                //start showing progress bar
            }
        }
    }
}