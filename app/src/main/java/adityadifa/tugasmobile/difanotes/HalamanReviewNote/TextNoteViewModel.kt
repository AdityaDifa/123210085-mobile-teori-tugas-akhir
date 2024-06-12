package adityadifa.tugasmobile.difanotes.HalamanReviewNote

import adityadifa.tugasmobile.difanotes.Repository.TextNoteRepository
import adityadifa.tugasmobile.difanotes.textDatabase.TextNote
import android.app.Application
import androidx.lifecycle.ViewModel

class TextNoteViewModel (application: Application) : ViewModel(){
    private val mNoteRepository: TextNoteRepository = TextNoteRepository(application)

    fun insert(note: TextNote) {
        mNoteRepository.insert(note)
    }

    fun update(note: TextNote) {
        mNoteRepository.update(note)
    }

    fun delete(note: TextNote) {
        mNoteRepository.delete(note)
    }

}