package adityadifa.tugasmobile.difanotes.HalamanUtama

import adityadifa.tugasmobile.difanotes.HalamanReviewNote.TextNoteMainViewModel
import adityadifa.tugasmobile.difanotes.HalamanReviewNote.TextNoteViewModel
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory private constructor(private val mApplication: Application) : ViewModelProvider.NewInstanceFactory() {
    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        @JvmStatic
        fun getInstance(application: Application): ViewModelFactory {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    INSTANCE = ViewModelFactory(application)
                }
            }
            return INSTANCE as ViewModelFactory
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(mApplication) as T
        } else if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            return NoteViewModel(mApplication) as T
        }
        else if (modelClass.isAssignableFrom(TextNoteViewModel::class.java)) {
            return TextNoteViewModel(mApplication) as T
        }
        else if (modelClass.isAssignableFrom(TextNoteMainViewModel::class.java)) {
            return TextNoteMainViewModel(mApplication) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}