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
        Slot(this, "slot1").onRun {
            textview.text = textview.text.toString() + "\nура работает  " + it.toString()
        }

        button.setOnClickListener {
            //пошлём сигнал
            signal("slot1")
                .putExtra("param", "zaebis").send(this)

        }
        button2.setOnClickListener {
            //пошлём сигнал и отключим
            signal("slot1")
                .putExtra("param", "zaebis")
                .putExtra("run", false).send(this)
        }
    }
}

