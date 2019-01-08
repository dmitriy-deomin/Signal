# Signal





<h2><strong><span style="text-decoration: underline;">Used</span>:</strong>Place The Slot.kt file into your project <a href="https://github.com/dmitriy-deomin/Signal/blob/master/app/src/main/java/dmitriy/deomin/signal/Slot.kt">link</a></h2>
<hr />
<p><span style="text-decoration: underline;"><strong>Cre</strong></span><span style="text-decoration: underline;"><strong>ate a receiver:</strong></span></p>
<p><span style="color: #0000ff;"><span style="color: #0000ff;"><span style="color: #0000ff;"><span style="color: #0000ff;"><strong>Slot(this, "slot1").onRun {<br />&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; val value = it.getStringExtra("key")<br />&nbsp;}</strong></span></span></span></span></p>
<p>//it - intent</p>
<p><br /><span style="text-decoration: underline;"><strong>Send a signal to the receiver:</strong></span></p>
<p><span style="color: #0000ff;"><strong>Signal(this, "slot1")</strong><br /><strong>&nbsp; &nbsp; &nbsp; &nbsp; .putExtra("<span style="color: #ff0000;">run</span>", <span style="color: #ff0000;">false</span>)</strong><br /><strong>&nbsp; &nbsp; &nbsp; &nbsp; .putExtra("key", value)</strong></span><span style="color: #0000ff;"><strong></strong></span></p>
<p>//putExtra("run", <span style="color: #ff0000;">true</span>) - After receiving the alarm will do the rest<br />//putExtra("run", <span style="color: #ff0000;">false</span>) - After receiving the signal will be destroyed</p>
<p>//By default true, value =&nbsp;any(Intent.putExtra)</p>
         
  
  
