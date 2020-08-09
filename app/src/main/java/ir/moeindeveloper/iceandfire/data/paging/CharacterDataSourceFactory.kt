package ir.moeindeveloper.iceandfire.data.paging

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import ir.moeindeveloper.iceandfire.data.pojo.characters.Character
import ir.moeindeveloper.iceandfire.data.repository.MainRepository
import kotlinx.coroutines.CoroutineScope

class CharacterDataSourceFactory(private val repository: MainRepository,
                                                     private val scope: CoroutineScope): DataSource.Factory<Int,Character>(){

    val source = MutableLiveData<CharacterDataSource>()
    override fun create(): DataSource<Int, Character> {
        val dSource = CharacterDataSource(repository,scope)
        source.postValue(dSource)

        return dSource
    }

}