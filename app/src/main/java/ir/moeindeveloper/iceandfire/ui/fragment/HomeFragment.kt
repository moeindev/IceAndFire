package ir.moeindeveloper.iceandfire.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import coil.api.load
import coil.transform.BlurTransformation
import dagger.hilt.android.AndroidEntryPoint
import ir.moeindeveloper.iceandfire.R
import ir.moeindeveloper.iceandfire.data.pojo.books.Book
import ir.moeindeveloper.iceandfire.data.pojo.characters.Character
import ir.moeindeveloper.iceandfire.data.pojo.houses.House
import ir.moeindeveloper.iceandfire.databinding.FragmentHomeBinding
import ir.moeindeveloper.iceandfire.ui.adapter.BookAdapter
import ir.moeindeveloper.iceandfire.ui.adapter.CharacterAdapter
import ir.moeindeveloper.iceandfire.ui.adapter.HouseAdapter
import ir.moeindeveloper.iceandfire.utils.character.getQuoteCharacter
import ir.moeindeveloper.iceandfire.utils.intractors.BookClickListener
import ir.moeindeveloper.iceandfire.utils.intractors.CharacterClickListener
import ir.moeindeveloper.iceandfire.utils.intractors.HouseClickListener
import ir.moeindeveloper.iceandfire.utils.network.RequestStatus
import ir.moeindeveloper.iceandfire.utils.network.Resource
import ir.moeindeveloper.iceandfire.viewModel.MainViewModel

@AndroidEntryPoint
class HomeFragment : Fragment(), CharacterClickListener, HouseClickListener, BookClickListener {

    private lateinit var binding: FragmentHomeBinding


    private val vm: MainViewModel by viewModels()


    private fun observeVM() {
        vm.quote.observe(viewLifecycleOwner, Observer {
            Log.d("q",it.toString())
            when(it.status){
                RequestStatus.SUCCESS -> {
                    quoteVisibility(true)

                    binding.quoteText.text = it.data?.quote

                    binding.quoteCharacter.text = it.data?.character

                    binding.quoteImage.load(it.data?.character!!.getQuoteCharacter().image){
                        crossfade(true)
                        transformations(BlurTransformation(requireContext(),4F))
                    }
                }

                RequestStatus.LOADING -> {
                    quoteVisibility(false)
                }

                RequestStatus.ERROR -> {
                    quoteVisibility(false)
                }
            }
        })

        vm.characters.observe(viewLifecycleOwner, Observer {
            when(it.status) {
                RequestStatus.SUCCESS -> {
                    charactersVisibility(true)

                    it.data?.let { chars -> characterAdapter.updateCharacters(chars) }
                }

                RequestStatus.LOADING -> {
                    charactersVisibility(false)
                }

                RequestStatus.ERROR -> {
                    charactersVisibility(false)
                }
            }
        })

        vm.books.observe(viewLifecycleOwner, Observer {
            when(it.status) {
                RequestStatus.SUCCESS -> {
                    booksVisibility(true)

                    it.data?.let { books -> bookAdapter.updateBooks(books) }
                }

                RequestStatus.LOADING -> {
                    booksVisibility(false)
                }

                RequestStatus.ERROR -> {
                    booksVisibility(false)
                }
            }
        })

        vm.houses.observe(viewLifecycleOwner, Observer {
            when(it.status) {
                RequestStatus.SUCCESS -> {
                    houseVisibility(true)

                    it.data?.let { houses -> houseAdapter.updateHouses(houses) }
                }

                RequestStatus.LOADING -> {
                    houseVisibility(false)
                }

                RequestStatus.ERROR -> {
                    houseVisibility(false)
                }
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(inflater,container,false)

        observeVM()

        setupViews()

        return binding.root
    }


    private lateinit var characterAdapter: CharacterAdapter
    private lateinit var houseAdapter: HouseAdapter
    private lateinit var bookAdapter: BookAdapter

    private fun setupViews(){
        characterAdapter = CharacterAdapter(this)

        binding.sectionCharacterList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        binding.sectionCharacterList.adapter = characterAdapter

        houseAdapter = HouseAdapter(this)

        binding.sectionHouseList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        binding.sectionHouseList.adapter = houseAdapter

        bookAdapter = BookAdapter(this)

        binding.sectionBookList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)

        binding.sectionBookList.adapter = bookAdapter
    }




    private fun quoteVisibility(visible: Boolean){
        val visibility = when(visible){
            true -> View.VISIBLE
            false -> View.GONE
        }

        binding.quoteContainer.visibility = visibility
    }


    private fun charactersVisibility(visible: Boolean){
        val visibility = when(visible){
            true -> View.VISIBLE
            false -> View.GONE
        }

        binding.sectionCharacterTitle.visibility = visibility

        binding.sectionCharacterMore.visibility = visibility

        binding.sectionCharacterList.visibility = visibility

    }

    private fun houseVisibility(visible: Boolean){
        val visibility = when(visible){
            true -> View.VISIBLE
            false -> View.GONE
        }

        binding.sectionHouseTitle.visibility = visibility

        binding.sectionHouseMore.visibility = visibility

        binding.sectionHouseList.visibility = visibility
    }


    private fun booksVisibility(visible: Boolean){
        val visibility = when(visible){
            true -> View.VISIBLE
            false -> View.GONE
        }

        binding.sectionBookTitle.visibility = visibility

        binding.sectionBookMore.visibility = visibility

        binding.sectionBookList.visibility = visibility
    }


    override fun onCharacterSelect(character: Character) {
        //TODO("Not yet implemented")
    }

    override fun onHouseSelect(house: House) {
        //TODO("Not yet implemented")
    }

    override fun onBookSelect(book: Book) {
        //TODO("Not yet implemented")
    }
}