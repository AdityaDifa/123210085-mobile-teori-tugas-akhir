package adityadifa.tugasmobile.difanotes.HalamanReviewNote

import adityadifa.tugasmobile.difanotes.textDatabase.TextNote
import androidx.recyclerview.widget.DiffUtil

class TextNoteDiffCallback(private val oldNoteList: List<TextNote>, private val newNoteList: List<TextNote>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldNoteList.size
    override fun getNewListSize(): Int = newNoteList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldNoteList[oldItemPosition].id == newNoteList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldNote = oldNoteList[oldItemPosition]
        val newNote = newNoteList[newItemPosition]
        return oldNote.itemtext == newNote.itemtext
    }
}