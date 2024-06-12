package adityadifa.tugasmobile.difanotes.HalamanReviewNote

import adityadifa.tugasmobile.difanotes.databinding.ItemtextBinding
import adityadifa.tugasmobile.difanotes.textDatabase.TextNote
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class TextAdapter(private val deleteNoteCallback: (TextNote) -> Unit) : RecyclerView.Adapter<TextAdapter.NoteViewHolder>() {
    private val listNotes = ArrayList<TextNote>()
    fun setListNotes(listNotes: List<TextNote>) {
        val diffCallback = TextNoteDiffCallback(this.listNotes, listNotes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        this.listNotes.clear()
        this.listNotes.addAll(listNotes)
        diffResult.dispatchUpdatesTo(this)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemtextBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(binding)
    }
    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.bind(listNotes[position])
    }
    override fun getItemCount(): Int {
        return listNotes.size
    }
    inner class NoteViewHolder(private val binding: ItemtextBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: TextNote) {
            with(binding) {
                itemtext.text = note.itemtext
                btnedit.setOnClickListener{
                    deleteNoteCallback(note)
                }
            }
        }
    }
}