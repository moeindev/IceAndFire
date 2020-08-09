package ir.moeindeveloper.iceandfire.ui.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.api.load
import ir.moeindeveloper.iceandfire.R
import ir.moeindeveloper.iceandfire.data.pojo.characters.Character
import ir.moeindeveloper.iceandfire.databinding.ItemCharacterBinding
import ir.moeindeveloper.iceandfire.utils.intractors.CharacterClickListener

class CharactersAdapter(private val listener: CharacterClickListener): PagedListAdapter<Character, CharactersAdapter.CharactersViewHolder>(
    diffCallback) {
    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Character>() {
            override fun areItemsTheSame(oldItem: Character, newItem: Character): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: Character, newItem: Character): Boolean = oldItem == newItem
        }
    }


    class CharactersViewHolder(private val binding: ItemCharacterBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindCharacter(character: Character?, listener: CharacterClickListener){
            character?.let {char->
                val name = if (char.name.isEmpty()){
                    if (char.aliases.size == 1) {
                        char.aliases[0]
                    }else char.culture
                } else char.name
                binding.itemCharacterText.text = name

                val gender = when(char.gender) {
                    "Male" -> R.drawable.ic_gender_male
                    "Female" -> R.drawable.ic_gender_female
                    else -> R.drawable.ic_gender_male
                }

                binding.itemCharacterImg.load(gender)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder {
        val binding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return CharactersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        holder.bindCharacter(getItem(position),listener)
    }
}