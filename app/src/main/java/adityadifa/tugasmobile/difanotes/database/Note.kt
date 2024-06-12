package adityadifa.tugasmobile.difanotes.database

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
    @Entity
    @Parcelize
    data class Note(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id")
        var id: Int = 0,

        @ColumnInfo(name = "judul")
        var judul: String? = null,

    ) : Parcelable
