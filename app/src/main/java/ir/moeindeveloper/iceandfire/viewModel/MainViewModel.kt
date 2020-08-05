package ir.moeindeveloper.iceandfire.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.moeindeveloper.iceandfire.data.pojo.books.Book
import ir.moeindeveloper.iceandfire.data.pojo.characters.Character
import ir.moeindeveloper.iceandfire.data.pojo.houses.House
import ir.moeindeveloper.iceandfire.data.pojo.quote.Quote
import ir.moeindeveloper.iceandfire.data.preference.SettingsPreference
import ir.moeindeveloper.iceandfire.data.repository.MainRepository
import ir.moeindeveloper.iceandfire.utils.character.QuoteCharacter
import ir.moeindeveloper.iceandfire.utils.network.Resource
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject
constructor(private val mainRepository: MainRepository,
            val settings: SettingsPreference): ViewModel() {

    private val _quote = MutableLiveData<Resource<Quote>>()

    val quote : LiveData<Resource<Quote>> get() = _quote

    private val _books = MutableLiveData<Resource<List<Book>>>()

    val books : LiveData<Resource<List<Book>>> get() = _books

    private val _characters = MutableLiveData<Resource<List<Character>>>()

    val characters : LiveData<Resource<List<Character>>> get() = _characters

    private val _houses = MutableLiveData<Resource<List<House>>>()

    val houses : LiveData<Resource<List<House>>> get() = _houses


    init {
        if (settings.isCharacterSaved()){
            getFilteredQuote()
        } else {
            getQuote()
        }
        getBooks()
        getCharacters()
        getHouses()
    }


    fun getQuote(){
        viewModelScope.launch {

            _quote.postValue(Resource.loading(null))

            mainRepository.getQuotes().let {response ->
                if (response.isSuccessful) {
                    _quote.postValue(Resource.success(response.body()))
                } else _quote.postValue(Resource.error(response.errorBody().toString(),null))
            }
        }
    }


    fun getFilteredQuote(){
        if (settings.getCharacter() == QuoteCharacter.NONE) return

        viewModelScope.launch {

            _quote.postValue(Resource.loading(null))

            mainRepository.filterQuotes(settings.getCharacter().queryName).let { response ->
                if (response.isSuccessful) {
                    _quote.postValue(Resource.success(response.body()))
                } else _quote.postValue(Resource.error(response.errorBody().toString(),null))
            }
        }
    }

    fun getBooks(){
        viewModelScope.launch {

            _books.postValue(Resource.loading(null))

            mainRepository.getBooks().let {response ->
                if (response.isSuccessful) {
                    _books.postValue(Resource.success(response.body()))
                } else _books.postValue(Resource.error(response.errorBody().toString(),null))
            }
        }
    }

    fun getCharacters(){
        viewModelScope.launch {

            _characters.postValue(Resource.loading(null))

            mainRepository.getCharacters().let {response ->
                if (response.isSuccessful) {
                    _characters.postValue(Resource.success(response.body()))
                } else _characters.postValue(Resource.error(response.errorBody().toString(),null))
            }
        }
    }

    fun getHouses(){
        viewModelScope.launch {
            _houses.postValue(Resource.loading(null))

            mainRepository.getHouses().let {response ->
                if (response.isSuccessful) {
                    _houses.postValue(Resource.success(response.body()))
                } else _houses.postValue(Resource.error(response.errorBody().toString(),null))
            }
        }
    }



}