# Signal






https://github.com/dmitriy-deomin/Signal/blob/master/app/src/main/java/dmitriy/deomin/signal/Slot.kt


Used:Place The Slot.kt file into your project

//create a receiver
Slot(this, "slot1").runEvent {
     //it - intent
     //val value = it.getStringExtra("key")
  }
  
 //Send a signal to the receiver
 //putExtra("run", true) - After receiving the alarm will do the rest
 //putExtra("run", false) - After receiving the signal will be destroyed
 //By default true
 Signal(this, "slot1")
                .putExtra("run", false)
                .putExtra("key", "value")             
  
  
