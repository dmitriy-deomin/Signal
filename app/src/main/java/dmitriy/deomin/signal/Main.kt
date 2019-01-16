package dmitriy.deomin.signal

import android.app.Activity
import android.os.Bundle
import kotlinx.android.synthetic.main.main.*

class Main : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)

        //создаём приемник(будет слушать пока не прикажут умереть)
        Slot(this, "slot1").onRun {it->
            val text = textview.text.toString() + "\nура работает  " + it.getStringExtra("param")
            textview.text = text
        }

        //создаём приемник(отработает один раз и уничтожится)
        Slot(this, "slot2",false).onRun {it->
            val text = textview.text.toString() + "\nура работает  " + it.getStringExtra("param")
            textview.text = text
        }


        button.setOnClickListener {
            //пошлём сигнал
            signal("slot1")
                .putExtra("param", "zaebis slot1").run(this)

            //пошлём сигнал
            signal("slot2")
                .putExtra("param", "zaebis slot2").run(this)

        }
        button2.setOnClickListener {
            //пошлём сигнал и отключим
            signal("slot1")
                .putExtra("param", "zaebis slot1")
                .putExtra("run", false).run(this)
        }
    }
}

