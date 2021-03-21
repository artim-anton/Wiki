package com.artimanton.wiki.adapter

import android.content.Context
import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artimanton.wiki.R
import com.artimanton.wiki.model.Character
import kotlinx.android.synthetic.main.item_character.view.*
import java.lang.String


class CharacterAdapter(private val context: Context, private var character: Character): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCharacter: Character = character
        holder.textViewTitle.setText(currentCharacter.name)
        holder.textViewDescription.setText(currentCharacter.species)
        holder.textViewPriority.setText(String.valueOf(currentCharacter.created))
    }

    override fun getItemCount() = 1

    /*fun setNotes(character: List<Character?>) {
        this.character = character as List<Character>
        notifyDataSetChanged()
    }*/

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val textViewTitle: TextView
        internal val textViewDescription: TextView
        internal val textViewPriority: TextView

        init {
            textViewTitle = itemView.text_view_title
            textViewDescription = itemView.text_view_description
            textViewPriority = itemView.text_view_priority
        }
    }
}