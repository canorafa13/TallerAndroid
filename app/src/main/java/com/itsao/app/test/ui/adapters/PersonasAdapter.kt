package com.itsao.app.test.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.itsao.app.test.R
import com.itsao.app.test.databinding.ItemListaBinding
import com.itsao.app.test.db.Persona

class PersonasAdapter(private val list: List<Persona>) : RecyclerView.Adapter<PersonasAdapter.ViewHolder>() {

    class ViewHolder(val item: ItemListaBinding) : RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista, parent, false)
        val binding = ItemListaBinding.bind(view)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.item.title.text = "${list[position].id} - ${list[position].name}"
        holder.item.description.text = "\t\t${list[position].firstName}, Edad: ${list[position].age} años"
    }
}