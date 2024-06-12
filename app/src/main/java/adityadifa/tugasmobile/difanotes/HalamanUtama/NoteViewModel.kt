package adityadifa.tugasmobile.difanotes.HalamanUtama

import adityadifa.tugasmobile.difanotes.Repository.NoteRepository
import adityadifa.tugasmobile.difanotes.database.Note
import android.app.Application
import androidx.lifecycle.ViewModel

class NoteViewModel (application: Application) : ViewModel(){
    private val mNoteRepository: NoteRepository = NoteRepository(application)

    fun insert(note: Note) {
        mNoteRepository.insert(note)
    }

    fun update(note: Note) {
        mNoteRepository.update(note)
    }

    fun delete(note: Note) {
        mNoteRepository.delete(note)
    }

}