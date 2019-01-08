package dmitriy.deomin.signal

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter

class Slot(context: Context, name: String) {

    private val con = context
    private val broadcastReceiver: BroadcastReceiver
    private var event: ((Intent) -> Unit)? = null

    init {
        val intentFilter = IntentFilter()
        intentFilter.addAction(name)
        //приёмник  сигналов
        broadcastReceiver = object : BroadcastReceiver() {
            override fun onReceive(c: Context, intent: Intent) {
                //если получен наш сигнал
                if (intent.action == name) {
                    //если сигнал послан для однократного выполнения, удалим слот
                    //иначе пусть дальше слушает
                    if (intent.getBooleanExtra("run", true)) {
                        run(intent)
                    } else {
                        run(intent)
                        delete_slot()
                    }
                }
            }
        }
        //регистрируем приёмник
        con.registerReceiver(broadcastReceiver, intentFilter)
    }

    //выполняется на стороне
    fun onRun(block: (Intent) -> Unit) {
        event = block
    }

    //срабатывает при приемке сигнала
    private fun run(param: Intent) {
        event?.invoke(param)
    }

    //удалить приёмник
    private fun delete_slot() {
        con.unregisterReceiver(broadcastReceiver)
    }
}

//созданим signal тотже интент только имя поменяем
class Signal(context: Context, name: String) : Intent() {
    init {
        this.action = name
        context.sendBroadcast(this)
    }
}

