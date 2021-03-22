package com.artimanton.wiki.adapter

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artimanton.wiki.R
import com.artimanton.wiki.model.AllCharacters
import com.artimanton.wiki.model.Character
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_character.view.*
import java.lang.String


class CharacterAdapter(private val context: Context, private var character: AllCharacters): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCharacter: Character = character.results!!.get(position)
        Picasso.get().load(currentCharacter.image).into(holder.imageView)
        holder.textViewTitle.setText(currentCharacter.name)
        //holder.textViewDescription.setText(currentCharacter.species)
    }

    override fun getItemCount() = character.results!!.size

    /*fun setNotes(character: List<Character?>) {
        this.character = character as List<Character>
        notifyDataSetChanged()
    }*/

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val textViewTitle: TextView
        //internal val textViewDescription: TextView
        internal val imageView: ImageView

        init {
            textViewTitle = itemView.text_view_title
            //textViewDescription = itemView.text_view_description
            imageView = itemView.image
        }
    }
}