package no.kristiania.android.farm.details

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import no.kristiania.android.farm.R
import no.kristiania.android.farm.databinding.FragmentAnimalBinding

class ChickenFragment : Fragment(R.layout.fragment_animal) {

    private lateinit var binding: FragmentAnimalBinding
    var mPlayer: MediaPlayer? = null

    @Suppress("DuplicatedCode")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentAnimalBinding.bind(view)

        binding.imageBigger.setImageResource(R.drawable.chicken)
        binding.textNameAnimal.text = getString(R.string.chicken)

        binding.imageBigger.setOnClickListener {
            playAudio(R.raw.chicken)
        }
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