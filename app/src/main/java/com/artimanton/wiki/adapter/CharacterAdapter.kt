package com.artimanton.wiki.adapter

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


class CharacterAdapter(private val listener: OnItemClickListener,
                       private var character: AllCharacters):
    RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_character, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentCharacter: Character = character.results!!.get(position)
        Picasso.get().load(currentCharacter.image).into(holder.imageView)
        holder.textViewTitle.setText(currentCharacter.name)
    }

    override fun getItemCount() = character.results!!.size


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        internal val imageView: ImageView
        internal val textViewTitle: TextView

        init {
            imageView = itemView.image
            textViewTitle = itemView.text_view_title
            itemView.setOnClickListener(this)

        }

        override fun onClick(v: View?) {
            val position = adapterPosition
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position)
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

}

