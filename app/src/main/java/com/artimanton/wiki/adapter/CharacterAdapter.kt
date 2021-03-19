package com.artimanton.wiki.adapter

import android.provider.ContactsContract.CommonDataKinds.Note
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.artimanton.wiki.R
import com.artimanton.wiki.model.Character
import java.lang.String


class CharacterAdapter(var character: List<Character>): RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCharacter: Character = character.get(position)
        holder.textViewTitle.setText(currentCharacter.name)
        holder.textViewDescription.setText(currentCharacter.species)
        holder.textViewPriority.setText(String.valueOf(currentCharacter.created))
    }

    override fun getItemCount(): Int {
        return character.size
    }

    fun setNotes(character: List<Character?>) {
        this.character = character as List<Character>
        notifyDataSetChanged()
    }

    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal val textViewTitle: TextView
        internal val textViewDescription: TextView
        internal val textViewPriority: TextView

        init {
            textViewTitle = itemView.findViewById(R.id.text_view_title)
            textViewDescription = itemView.findViewById(R.id.text_view_description)
            textViewPriority = itemView.findViewById(R.id.text_view_priority)
        }
    }
}