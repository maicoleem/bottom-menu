package com.forpus.menufragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.forpus.menufragment.databinding.ActivityHomeBinding
import com.forpus.menufragment.fragments.FirstFragment
import com.forpus.menufragment.fragments.SecondFragment
import com.forpus.menufragment.fragments.ThirdFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var firstFragment: FirstFragment
    private lateinit var secondFragment: SecondFragment
    private lateinit var thirdFragment: ThirdFragment
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        //enableEdgeToEdge()
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }*/
        firstFragment = FirstFragment()
        secondFragment = SecondFragment()
        thirdFragment = ThirdFragment()
        loadFragment(firstFragment)
        setContentView(binding.root)

        binding.bottomMenu.setOnItemSelectedListener {
            when(it.itemId){
                R.id.first->{
                    loadFragment(firstFragment)
                    true
                }
                R.id.second->{
                    loadFragment(secondFragment)
                    true
                }
                R.id.thrid->{
                    loadFragment(thirdFragment)
                    true
                }else->{
                    false
                }
            }
        }
    }
    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(com.google.android.material.R.id.container, fragment)
        transaction.commit()
    }
}