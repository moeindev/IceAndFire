package ir.moeindeveloper.iceandfire.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import ir.moeindeveloper.iceandfire.R
import ir.moeindeveloper.iceandfire.data.pojo.characters.Character
import ir.moeindeveloper.iceandfire.databinding.FragmentCharactersBinding
import ir.moeindeveloper.iceandfire.ui.adapter.CharactersAdapter
import ir.moeindeveloper.iceandfire.utils.intractors.CharacterClickListener
import ir.moeindeveloper.iceandfire.utils.ui.FabExtendingOnScrollListener
import ir.moeindeveloper.iceandfire.viewModel.MainViewModel

@AndroidEntryPoint
class CharactersFragment : Fragment(), CharacterClickListener {

    private val vm: MainViewModel by viewModels()

    private lateinit var binding: FragmentCharactersBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCharactersBinding.inflate(inflater,container,false)
        // Inflate the layout for this fragment
        setupViews()

        observeVM()


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        ViewCompat.setTranslationZ(requireView(), 100f)
    }

    private lateinit var adapter: CharactersAdapter
    private fun setupViews() {
        binding.characterList.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
        adapter = CharactersAdapter(this)
        binding.characterList.adapter = adapter
        binding.characterList.addOnScrollListener(FabExtendingOnScrollListener(binding.characterFilter))
    }


    private fun observeVM() {
        vm.allCharacters.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

    override fun onCharacterSelect(character: Character) {

    }
}