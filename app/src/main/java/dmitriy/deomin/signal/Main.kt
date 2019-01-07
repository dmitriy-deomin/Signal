package dmitriy.deomin.signal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import kotlinx.android.synthetic.main.main.*

class Main : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        //создаём приемник
        Slot(this, "slot1").runEvent {
            textview.text = textview.text.toString() + "\nура работает  " + it.toString()
        }

        button.setOnClickListener {
            //пошлём сигнал
            Signal(this, "slot1")
                .putExtra("run", true)
                .putExtra("param", "zaebis")

        }
        button2.setOnClickListener {
            //пошлём сигнал и выключим приёмник
            val i = Intent("slot1")
            i.putExtra("run", false)
            i.putExtra("param", "zaebis")
            this.sendBroadcast(i)
        }
    }
}

