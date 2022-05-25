package morales.damian.volley_recyclerview.adaptador

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import morales.damian.volley_recyclerview.ClasesNecesarias.Personaje
import morales.damian.volley_recyclerview.R


class PersonajeAdapt(val listaPersoanje:ArrayList<Personaje>): RecyclerView.Adapter<PersonajeAdapt.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.visualizar,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.Nombre.text = listaPersoanje[position].nombre


        Picasso.get()
            .load(listaPersoanje[position].imagen)
            .into(holder.Imagen)

    }

    override fun getItemCount(): Int {
        return listaPersoanje.size
    }

    class ViewHolder(visualizar: View): RecyclerView.ViewHolder(visualizar){
        val Nombre: TextView
        val Imagen: ImageView

        init {
            Nombre = visualizar.findViewById(R.id.NomPersonaje)
            Imagen = visualizar.findViewById(R.id.imgPersonaje)
        }
    }
}