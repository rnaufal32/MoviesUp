package std.aanrstudio.apps.moviesup.data.source.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "fav_movie")
data class Movie(

    @PrimaryKey
    @ColumnInfo(name = "id")
    var id: String = "",

    @ColumnInfo(name = "title")
    var title: String = "",

    @ColumnInfo(name = "overview")
    var overview: String = "",

    @ColumnInfo(name = "release_date")
    var release_date: String = "",

    @ColumnInfo(name = "duration")
    var duration: String = "",

    @ColumnInfo(name = "poster")
    var poster: String = ""
)