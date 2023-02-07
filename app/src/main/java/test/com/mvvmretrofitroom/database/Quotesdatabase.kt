package test.com.mvvmretrofitroom.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import test.com.mvvmretrofitroom.models.QuoteListItem

/**
 * Created by Mukesh on 19-01-2023.
 */


@Database(entities = [QuoteListItem::class], version = 1, exportSchema = false)
abstract class Quotesdatabase : RoomDatabase() {

    abstract fun getQuotesDao(): QuotesDao

    companion object {
        @Volatile
        var INSTANCE: Quotesdatabase? = null

        fun getDatabase(context: Context): Quotesdatabase {

            if (INSTANCE == null) {

                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        Quotesdatabase::class.java,
                        "QuotesDB"
                    ).build()
                }
            }

            return INSTANCE!!
        }
    }
}