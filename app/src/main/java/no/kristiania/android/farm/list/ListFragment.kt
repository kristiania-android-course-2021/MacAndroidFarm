package no.kristiania.android.farm.list


import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import no.kristiania.android.farm.R
import no.kristiania.android.farm.databinding.FragmentListBinding
import no.kristiania.android.farm.details.AnimalFragment

class ListFragment : Fragment(R.layout.fragment_list) {

    private val animals: List<Int> = mutableListOf(
        R.drawable.chicken,
        R.drawable.cow,
        R.drawable.goat,
        R.drawable.sheep,
        R.drawable.chicken,
        R.drawable.cow,
        R.drawable.goat,
        R.drawable.sheep,
        R.drawable.chicken,
        R.drawable.cow,
        R.drawable.goat,
        R.drawable.sheep,
        R.drawable.chicken,
        R.drawable.cow,
        R.drawable.goat,
        R.drawable.sheep,
        R.drawable.chicken,
        R.drawable.cow,
        R.drawable.goat,
        R.drawable.sheep
    )

    lateinit var binding: FragmentListBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentListBinding.bind(view)
        with(binding) {
            animalsList.layoutManager = GridLayoutManager(requireContext(), 2)
            animalsList.adapter = AnimalsListAdapter(animals) { item ->
                showDetails(item)
            }
        }
    }

    private fun showDetails(item: Int) {
        fragmentManager?.apply {
            beginTransaction()
                .replace(R.id.fragment_container, AnimalFragment.newInstance(item))
                .addToBackStack("animal_fragment").commit()
        }
    }
}