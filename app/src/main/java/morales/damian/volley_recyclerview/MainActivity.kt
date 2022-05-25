package morales.damian.volley_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnLista:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnLista=findViewById(R.id.btnIrALista)


        btnLista.setOnClickListener {
            val intentLista = Intent(this, ActivityLista::class.java)

            startActivity(intentLista)

        }
    }
}
