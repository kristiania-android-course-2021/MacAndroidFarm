package no.kristiania.android.farm

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import no.kristiania.android.farm.databinding.ActivityMainBinding
import no.kristiania.android.farm.details.ChickenFragment
import no.kristiania.android.farm.details.SheepFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        with(binding) {
            btnChicken.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ChickenFragment()).commit()
            }
            btnSheep.setOnClickListener {
                supportFragmentManager.beginTransaction().replace(R.id.fragment_container, SheepFragment()).commit()
            }
        }
    }
}