package adityadifa.tugasmobile.difanotes

import adityadifa.tugasmobile.difanotes.HalamanUtama.NoteViewModel
import adityadifa.tugasmobile.difanotes.HalamanReviewNote.TextNoteViewModel
import adityadifa.tugasmobile.difanotes.HalamanUtama.ViewModelFactory
import adityadifa.tugasmobile.difanotes.database.Note
import adityadifa.tugasmobile.difanotes.textDatabase.TextNote
import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContentProviderCompat
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

