package adityadifa.tugasmobile.difanotes.textDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

    @Database(entities = [TextNote::class], version = 1)
    abstract class NoteTextRoomDatabase : RoomDatabase() {
        abstract fun noteTextDao(): NoteTextDAO.NoteTextDao

        companion object {
            @Volatile
            private var INSTANCE: NoteTextRoomDatabase? = null

            @JvmStatic
            fun getDatabase(context: Context): NoteTextRoomDatabase {
                if (INSTANCE == null) {
                    synchronized(NoteTextRoomDatabase::class.java) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            NoteTextRoomDatabase::class.java, "notetext_database")
                            .build()
                    }
                }
                return INSTANCE as NoteTextRoomDatabase
            }
        }
    }
