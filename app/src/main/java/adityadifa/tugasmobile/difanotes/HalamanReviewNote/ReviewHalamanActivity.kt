package adityadifa.tugasmobile.difanotes.HalamanReviewNote

import adityadifa.tugasmobile.difanotes.HalamanUtama.ViewModelFactory
import adityadifa.tugasmobile.difanotes.R
import adityadifa.tugasmobile.difanotes.database.Note
import adityadifa.tugasmobile.difanotes.databinding.ActivityReviewHalamanBinding
import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager

class ReviewHalamanActivity : AppCompatActivity() {

    private lateinit var binding: ActivityReviewHalamanBinding
    private lateinit var adapter: TextAdapter
    private var note: Note? = null
//    private var notetext: TextNote? = null
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityReviewHalamanBinding.inflate(layoutInflater)
        setContentView(binding.root)
        note = intent.getParcelableExtra(EXTRA_NOTE)
        supportActionBar?.title = note?.judul

        binding.tombolTambah.setOnClickListener{
            Log.d(ContentValues.TAG, "onCreate: tombol tambah clicked")
            val dialogFragment = TambahTextFragment()
            val bundle = Bundle().apply {
                putParcelable("Note", note) // Mengirim objek TextNote sebagai Parcelable
            }
            dialogFragment.arguments = bundle // Menetapkan argumen ke fragment
            dialogFragment.show(supportFragmentManager, "my_dialog_fragment_tag")
        }



        val mainViewModel = obtainViewModel(this)
        note?.let {
            mainViewModel.getAllNotes(it.id).observe(this) { noteList ->
                if (noteList != null) {
                    adapter.setListNotes(noteList)
                }
            }
        }

        adapter = TextAdapter(
            { notetext -> mainViewModel.delete(notetext) }
        )
        binding?.rvNotes?.layoutManager = LinearLayoutManager(this)
        binding?.rvNotes?.setHasFixedSize(true)
        binding?.rvNotes?.adapter = adapter

    }

    private fun obtainViewModel(activity: AppCompatActivity): TextNoteMainViewModel {
        val factory = ViewModelFactory.getInstance(activity.application)
        return ViewModelProvider(activity, factory).get(TextNoteMainViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.hapus_file_btn, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.actionhapus -> {
                val textNoteMainViewModel = obtainViewModel(this)
                note?.let { textNoteMainViewModel.delete(it) }
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    companion object {
        val EXTRA_NOTE: String = "extranote"
    }
}