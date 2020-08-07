package ir.moeindeveloper.iceandfire.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ir.moeindeveloper.iceandfire.data.pojo.books.Book
import ir.moeindeveloper.iceandfire.databinding.ItemMultipleBinding
import ir.moeindeveloper.iceandfire.utils.intractors.BookClickListener


class BookAdapter(private val listener: BookClickListener): RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        val binding = ItemMultipleBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return BookViewHolder(binding)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.bindItem(books[position],listener)
    }

    class BookViewHolder(private val binding: ItemMultipleBinding): RecyclerView.ViewHolder(binding.root) {

        fun bindItem(book: Book, listener: BookClickListener) {

            val name = book.name

            binding.itemMultipleText.text = name

            binding.root.setOnClickListener {
                listener.onBookSelect(book)
            }
        }
    }


    private var books: List<Book> = listOf()


    fun updateBooks(b: List<Book>) {
        books = b
        notifyDataSetChanged()
    }
}