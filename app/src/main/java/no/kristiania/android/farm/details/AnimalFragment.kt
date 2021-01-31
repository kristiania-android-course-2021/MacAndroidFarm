package no.kristiania.android.farm.details

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.fragment.app.Fragment
import no.kristiania.android.farm.R
import no.kristiania.android.farm.databinding.FragmentAnimalBinding

class AnimalFragment : Fragment(R.layout.fragment_animal) {

    private lateinit var binding: FragmentAnimalBinding
    var mPlayer: MediaPlayer? = null

    @Suppress("DuplicatedCode")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimalBinding.bind(view)

        val drawable = arguments?.getInt("item")
        if (drawable == null) {
            showError()
        } else {
            binding.imageBigger.setImageResource(drawable)
            binding.textNameAnimal.text = getString(itemToName(drawable))
        }

        binding.imageBigger.setOnClickListener {
            playAudio(R.raw.chicken)
        }
    }

    private fun itemToName(drawable: Int): Int = when (drawable) {
        R.drawable.chicken -> R.string.chicken
        R.drawable.sheep -> R.string.sheep
        R.drawable.cow -> R.string.cow
        R.drawable.goat -> R.string.goat
        else -> 0
    }

    private fun showError() {
        Toast.makeText(requireContext(), "No item found.", Toast.LENGTH_SHORT).show()
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

    companion object {
        fun newInstance(@DrawableRes drawable: Int): AnimalFragment {
            return AnimalFragment().apply {
                val bundle = Bundle()
                bundle.putInt("item", drawable)
                arguments = bundle
            }
        }
    }
}