# Signal






https://github.com/dmitriy-deomin/Signal/blob/master/app/src/main/java/dmitriy/deomin/signal/Slot.kt
<br>

Used:Place The Slot.kt file into your project<br>
<br>
//create a receiver<br>
Slot(this, "slot1").runEvent {<br>
     //it - intent<br>
     //val value = it.getStringExtra("key")<br>
  }<br>
  <br>
 //Send a signal to the receiver<br>
 //putExtra("run", true) - After receiving the alarm will do the rest<br>
 //putExtra("run", false) - After receiving the signal will be destroyed<br>
 //By default true<br>
 Signal(this, "slot1")<br>
                .putExtra("run", false)<br>
                .putExtra("key", "value")<br>           
  
  
