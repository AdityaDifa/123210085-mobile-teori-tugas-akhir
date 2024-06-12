package adityadifa.tugasmobile.difanotes.HalamanReviewNote

import adityadifa.tugasmobile.difanotes.HalamanUtama.ViewModelFactory
import adityadifa.tugasmobile.difanotes.R
import adityadifa.tugasmobile.difanotes.database.Note
import adityadifa.tugasmobile.difanotes.textDatabase.TextNote
import android.app.AlertDialog
import android.app.Dialog
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

/**
 * A simple [Fragment] subclass.
 * Use the [TambahTextFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TambahTextFragment : DialogFragment() {
    private var text: TextNote? = null
    private lateinit var noteViewModel: TextNoteViewModel
    // TODO: Rename and change types of parameters
//    private var param1: String? = null
//    private var param2: String? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
//        }
//    }

//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_tambah_text, container, false)
//    }

    private lateinit var note: Note
override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
    noteViewModel = obtainViewModel(this)
    // Menggunakan layout XML untuk tampilan dialog
    val inflater = requireActivity().layoutInflater
    val view = inflater.inflate(R.layout.fragment_tambah_text, null)
    arguments?.let {
        note = it.getParcelable("Note")!! // Mendapatkan objek TextNote dari argumen
    }

    // Mengambil referensi ke elemen-elemen tampilan dalam layout
    val inputNama = view.findViewById<EditText>(R.id.inputText)
    val btnTambah = view.findViewById<Button>(R.id.btnTambah)

    btnTambah.setOnClickListener(){
        val title = inputNama.text.toString().trim()
        Log.d(ContentValues.TAG, "${title}")
        when {
            title.isEmpty() -> {
                showToast("text masih kosong")
            }
            else -> {
                text = TextNote()
                text.let { text ->
                    text?.itemtext = title
                    text?.idnote = note.id
                }
                noteViewModel.insert(text as TextNote)
                showToast("text berhasil ditambah")
                dismiss()
            }
        }
    }

    // Membuat AlertDialog menggunakan builder dan mengatur tampilan dari layout XML
    val builder = AlertDialog.Builder(requireActivity())
    builder.setView(view)

    // Membuat dialog dari builder
    return builder.create()
}
    private fun showToast(message:String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
    }
    private fun obtainViewModel(fragment: Fragment): TextNoteViewModel {
        val factory = ViewModelFactory.getInstance(fragment.requireActivity().application)
        return ViewModelProvider(fragment, factory).get(TextNoteViewModel::class.java)
    }

}