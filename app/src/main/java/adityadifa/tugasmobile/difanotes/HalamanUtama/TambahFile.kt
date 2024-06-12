package adityadifa.tugasmobile.difanotes.HalamanUtama

import adityadifa.tugasmobile.difanotes.R
import adityadifa.tugasmobile.difanotes.database.Note
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
 * Use the [TambahFile.newInstance] factory method to
 * create an instance of this fragment.
 */
class TambahFile : DialogFragment() {
    private var note: Note? = null
    private lateinit var noteViewModel: NoteViewModel

//    // TODO: Rename and change types of parameters
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
//        return inflater.inflate(R.layout.fragment_tambah_file, container, false)
//    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        noteViewModel = obtainViewModel(this)
        // Menggunakan layout XML untuk tampilan dialog
        val inflater = requireActivity().layoutInflater
        val view = inflater.inflate(R.layout.fragment_tambah_file, null)

        // Mengambil referensi ke elemen-elemen tampilan dalam layout
        val inputNama = view.findViewById<EditText>(R.id.inputNama)
        val btnBatal = view.findViewById<Button>(R.id.btnBatal)
        val btnBuat = view.findViewById<Button>(R.id.btnBuat)

        btnBuat.setOnClickListener(){
            val title = inputNama.text.toString().trim()
            Log.d(ContentValues.TAG, "${title}")
            when {
                title.isEmpty() -> {
                    showToast("text masih kosong")
                }
                else -> {
                    note = Note()
                    note.let { note ->
                        note?.judul = title
                    }
                    noteViewModel.insert(note as Note)
                    showToast("file berhasil ditambah")
                    dismiss()
                }
            }
        }
        btnBatal.setOnClickListener(){
            dismiss()
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
    private fun obtainViewModel(fragment: Fragment): NoteViewModel {
        val factory = ViewModelFactory.getInstance(fragment.requireActivity().application)
        return ViewModelProvider(fragment, factory).get(NoteViewModel::class.java)
    }
}