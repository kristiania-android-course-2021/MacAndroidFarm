package no.kristiania.android.farm.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import no.kristiania.android.farm.databinding.AnimalImageItemBinding

class AnimalsListAdapter(private val list: List<Int>, val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<AnimalsListAdapter.AnimalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = AnimalImageItemBinding.inflate(LayoutInflater.from(parent.context))
        return AnimalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.binding.imgSmall.setImageResource(list[position])
        holder.binding.root.setOnClickListener {
            onClick(list[position])
        }
    }

    override fun getItemCount(): Int = list.size

    class AnimalViewHolder(val binding: AnimalImageItemBinding) : RecyclerView.ViewHolder(binding.root)
}

