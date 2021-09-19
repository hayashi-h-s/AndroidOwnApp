package jp.co.androidownapp.data

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.text.DateFormat


// room の追加

@Entity(tableName = "task_table")
@Parcelize // id 'kotlin-android-extensions' 追加で使用可 //https://developer.android.com/kotlin/parcelize?hl=ja // 基本コンストラクタの生成？
data class Task(
    val name: String,
    val important: Boolean = false,
    val completed: Boolean = false,
    /**
     * ava.lang.System.currentTimeMillis() は
        ミリ秒で表される現在の時間を返します
     */
    val created: Long = System.currentTimeMillis(), // https://akira-watson.com/android/system-currenttimemillis.html
    @PrimaryKey(autoGenerate = true) val id: Int = 0 // 自動生成 https://qiita.com/yonce/items/928058504ec5c3191725
) : Parcelable {
    val createdDateFormatted: String
        get() = DateFormat.getDateTimeInstance().format(created) //
}