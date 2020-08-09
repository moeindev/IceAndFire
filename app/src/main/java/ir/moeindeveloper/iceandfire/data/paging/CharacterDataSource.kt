package ir.moeindeveloper.iceandfire.data.paging

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import ir.moeindeveloper.iceandfire.data.pojo.characters.Character
import ir.moeindeveloper.iceandfire.data.repository.MainRepository
import ir.moeindeveloper.iceandfire.utils.network.Resource
import kotlinx.coroutines.*

class CharacterDataSource(private val repository: MainRepository,
                                              private val scope: CoroutineScope) : PageKeyedDataSource<Int, Character>() {

    private var supervisorJob = SupervisorJob()

    private val TAG = CharacterDataSource::class.simpleName


    private val characters = MutableLiveData<Resource<List<Character>>>()



    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Character>
    ) {
        characters.postValue(Resource.loading(null))

        executeQuery(1){
            callback.onResult(it,null,2)
        }
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        characters.postValue(Resource.loading(null))

        val page = params.key
        executeQuery(page){
            callback.onResult(it,page + 1)
        }
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Character>) {
        // Do nothing here
    }

    // UTILS ---
    private fun executeQuery(page: Int,callback:(List<Character>) -> Unit) {
        // ...
        scope.launch(getJobErrorHandler() + supervisorJob) {
            delay(200) // To handle user typing case
            val chars = repository.getCharacters(page).body()!!

            characters.postValue(Resource.success(chars))

            callback(chars)
        }
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, e ->
        Log.e(TAG, "An error happened: $e")
        characters.postValue(Resource.error(e.message.toString(),null))
    }

    override fun invalidate() {
        super.invalidate()
        supervisorJob.cancelChildren()
    }
}