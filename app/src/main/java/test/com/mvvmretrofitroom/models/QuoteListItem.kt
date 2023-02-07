package test.com.mvvmretrofitroom.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "quotes")
data class QuoteListItem(
    @PrimaryKey(autoGenerate = true)
    var QuoteId: Int?,
    var author: String?,
    var text: String?
)

