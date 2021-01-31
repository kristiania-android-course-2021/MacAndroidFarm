package no.kristiania.android.farm.details

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import no.kristiania.android.farm.R
import no.kristiania.android.farm.databinding.FragmentAnimalBinding

class AnimalFragment : Fragment(R.layout.fragment_animal) {

    private lateinit var binding: FragmentAnimalBinding
    var mPlayer: MediaPlayer? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimalBinding.bind(view)
        val item = arguments?.getInt("item")
        if (item == null) {
            showError()
        } else {
            binding.imageBigger.setImageResource(item)
            binding.imageBigger.setOnClickListener {
                playAudio(itemToSound(item))
            }
            binding.textNameAnimal.text = itemToName(item)
        }

    }

    private fun itemToName(item: Int): String = when (item) {
        R.drawable.chicken -> getString(R.string.chicken)
        R.drawable.cow -> getString(R.string.cow)
        R.drawable.goat -> getString(R.string.goat)
        R.drawable.sheep -> getString(R.string.sheep)
        else -> ""
    }

    private fun itemToSound(item: Int): Int = when (item) {
        R.drawable.chicken -> R.raw.chicken
        R.drawable.cow -> R.raw.chicken
        R.drawable.goat -> R.raw.chicken
        R.drawable.sheep -> R.raw.chicken
        else -> 0
    }

    private fun showError() {
        Toast.makeText(requireContext(), "Something went wrong!!", Toast.LENGTH_SHORT).show()
    }

    private fun playAudio(rawMP3File: Int) {
        mPlayer = MediaPlayer.create(requireContext(), rawMP3File)
        mPlayer?.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPlayer?.stop()
        mPlayer?.release()
    }
}