package morales.damian.volley_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import morales.damian.volley_recyclerview.ClasesNecesarias.Personaje
import morales.damian.volley_recyclerview.adaptador.PersonajeAdapt


class ActivityLista : AppCompatActivity() {
    lateinit var miRecyclerView: RecyclerView
    val lisPersonaje = ArrayList<Personaje>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)
        miRecyclerView = findViewById(R.id.RecyclerPersonaje)
        miRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        getPersonaje()
    }

    fun getPersonaje(){
        val queue = Volley.newRequestQueue(this)
        val url = "https://rickandmortyapi.com/api/character"
        val jsonObject = JsonObjectRequest(Request.Method.GET,url,null,
            {respuesta->
                val newjson = respuesta.getJSONArray("results")
                for(i in 0..7){
                    val newobj= newjson.getJSONObject(i)
                    val personaje = Personaje(newobj.getString("name"),newobj.getString("image"))
                    lisPersonaje.add(personaje)
                }
                miRecyclerView.adapter = PersonajeAdapt(lisPersonaje)
            },{error->
                Log.e("volley_recyclerview","error")
            }
        )
        queue.add((jsonObject))
    }
}