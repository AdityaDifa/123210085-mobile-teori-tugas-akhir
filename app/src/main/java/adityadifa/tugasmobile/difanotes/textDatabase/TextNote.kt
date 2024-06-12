package adityadifa.tugasmobile.difanotes.textDatabase

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
    @Entity
    @Parcelize
    data class TextNote(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Int = 0,

        @ColumnInfo(name = "IDNote")
        var idnote: Int? = null,

        @ColumnInfo(name = "itemtext")
        var itemtext: String? = null,

    ) : Parcelable
