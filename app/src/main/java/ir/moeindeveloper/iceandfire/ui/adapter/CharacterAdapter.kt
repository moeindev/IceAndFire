package ir.moeindeveloper.iceandfire.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.moeindeveloper.iceandfire.data.pojo.characters.Character
import ir.moeindeveloper.iceandfire.databinding.ItemMultipleBinding
import ir.moeindeveloper.iceandfire.utils.intractors.CharacterClickListener


class CharacterAdapter(private val listener: CharacterClickListener): RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val binding = ItemMultipleBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return CharacterViewHolder(binding)
    }

    override fun getItemCount(): Int = characters.size

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bindItem(characters[position],listener)
    }

    class CharacterViewHolder(private val binding: ItemMultipleBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindItem(character: Character, listener: CharacterClickListener) {

            val name = if (character.name.isEmpty()){
                if (character.aliases.size == 1) {
                    character.aliases[0]
                }else character.culture
            } else character.name
            binding.itemMultipleText.text = name

            binding.root.setOnClickListener {
                listener.onCharacterSelect(character)
            }
        }
    }


    private var characters: List<Character> = listOf()


    fun updateCharacters(chars: List<Character>) {
        characters = chars
        notifyDataSetChanged()
    }
}