package com.ivan.guess

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_record.*

class RecordActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        val count = intent.getIntExtra("COUNTER", -1)
        counter.setText(count.toString())
        save.setOnClickListener { view ->
            val nick = nickName.text.toString()
            getSharedPreferences("guess", Context.MODE_PRIVATE)
                .edit()
                .putInt("REC_COUNT", count)
                .putString("REC_NICK", nick)
                .apply()//有空的時候才寫
                //.commit()//會馬上寫入，故如下一行就需使用此資料，則須用commit
        }
    }
}
