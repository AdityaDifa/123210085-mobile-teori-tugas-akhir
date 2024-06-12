package adityadifa.tugasmobile.difanotes.Repository

import adityadifa.tugasmobile.difanotes.textDatabase.NoteTextDAO
import adityadifa.tugasmobile.difanotes.textDatabase.NoteTextRoomDatabase
import adityadifa.tugasmobile.difanotes.textDatabase.TextNote
import android.app.Application
import androidx.lifecycle.LiveData
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class TextNoteRepository(application: Application)  {
    private val mNotesDao: NoteTextDAO.NoteTextDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = NoteTextRoomDatabase.getDatabase(application)
        mNotesDao = db.noteTextDao()
    }

    fun getAllNotes(foreignkey:Int): LiveData<List<TextNote>> = mNotesDao.getAllNotes(foreignkey)

    fun insert(note: TextNote) {
        executorService.execute { mNotesDao.insert(note) }
    }

    fun delete(note: TextNote) {
        executorService.execute { mNotesDao.delete(note) }
    }

    fun update(note: TextNote) {
        executorService.execute { mNotesDao.update(note) }
    }
}