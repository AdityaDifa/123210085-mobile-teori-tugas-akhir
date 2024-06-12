package adityadifa.tugasmobile.difanotes.HalamanReviewNote

import adityadifa.tugasmobile.difanotes.Repository.NoteRepository
import adityadifa.tugasmobile.difanotes.Repository.TextNoteRepository
import adityadifa.tugasmobile.difanotes.database.Note
import adityadifa.tugasmobile.difanotes.textDatabase.TextNote
import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class TextNoteMainViewModel (application: Application) : ViewModel() {
    private val mNoteRepository: TextNoteRepository = TextNoteRepository(application)
    private val noteRepository: NoteRepository = NoteRepository(application)

    fun getAllNotes(foreignkey:Int): LiveData<List<TextNote>> = mNoteRepository.getAllNotes(foreignkey)
    fun delete(note: TextNote) {
        mNoteRepository.delete(note)
    }

    fun delete(note: Note) {
        noteRepository.delete(note)
    }
}