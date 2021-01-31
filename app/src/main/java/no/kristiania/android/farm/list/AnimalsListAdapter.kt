package no.kristiania.android.farm.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import no.kristiania.android.farm.databinding.AnimalImageItemBinding

class AnimalsListAdapter(private val list: List<Int>, val onClick: (Int) -> Unit) :
    RecyclerView.Adapter<AnimalsListAdapter.AnimalViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimalViewHolder {
        val binding = AnimalImageItemBinding.inflate(LayoutInflater.from(parent.context))
        return AnimalViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: AnimalViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

    class AnimalViewHolder(private val binding: AnimalImageItemBinding, val onClick: (Int) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Int) {
            binding.imgSmall.setImageResource(item)
            binding.imgSmall.setOnClickListener {
                onClick(item)
            }
        }
    }
}