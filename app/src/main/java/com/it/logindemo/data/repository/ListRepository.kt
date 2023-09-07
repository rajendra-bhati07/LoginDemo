

class ListRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllData() = retrofitService.getAllData()
}