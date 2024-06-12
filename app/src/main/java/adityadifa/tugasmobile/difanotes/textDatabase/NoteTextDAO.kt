package adityadifa.tugasmobile.difanotes.textDatabase

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

class NoteTextDAO {
    @Dao
    interface NoteTextDao {
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        fun insert(textNote: TextNote)

        @Update
        fun update(textNote: TextNote)

        @Delete
        fun delete(textNote: TextNote)

        @Query("SELECT * from TextNote WHERE idnote = :foreignkey ORDER BY id ASC")
        fun getAllNotes(foreignkey:Int): LiveData<List<TextNote>>
    }
}