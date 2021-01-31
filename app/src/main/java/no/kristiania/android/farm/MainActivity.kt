package no.kristiania.android.farm

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import no.kristiania.android.farm.databinding.ActivityMainBinding
import no.kristiania.android.farm.list.ListFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().add(R.id.fragment_container, ListFragment(), "animals_list")
                .commit()
        }
    }
}