package com.raag.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.raag.basketballscore.databinding.ActivityMainBinding
import com.raag.basketballscore.model.Score

class MainActivity : AppCompatActivity() {
    companion object{
        const val KEY_RESULT = "result"
    }
    private lateinit var binding: ActivityMainBinding
    private var resultLocal: Int = 0
    private var resultVisit: Int = 0
    private var masUno: Int = 1
    private var masDos: Int = 2
    private var menosUno: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.reset.setOnClickListener {
            resetScore()
        }
        binding.menosUnoLocal.setOnClickListener {
            menosUnoLocal()
        }

        binding.masUnoLocal.setOnClickListener {
            masUnoLocal()
        }

        binding.masDosLocal.setOnClickListener {
            masDosLocal()
        }

        binding.menosUnoVisit.setOnClickListener {
            menosUnoVisit()
        }

        binding.masUnoVisit.setOnClickListener {
            masUnoVisit()
        }

        binding.masDosVisit.setOnClickListener {
            masDosVisit()
        }

        binding.result.setOnClickListener {
            val finalScore = Score(resultLocal, resultVisit)
            seeResult(finalScore)
        }
    }

    private fun masDosLocal() {
        resultLocal += masDos
        binding.scoreLocal.text = resultLocal.toString()
    }

    private fun masUnoLocal() {
        resultLocal += masUno
        binding.scoreLocal.text = resultLocal.toString()
    }

    private fun menosUnoLocal() {
        if(resultLocal>0){
            resultLocal += menosUno
            binding.scoreLocal.text = resultLocal.toString()
        }else{
            Snackbar.make(binding.root, getString(R.string.puntaje_local), Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun masDosVisit() {
        resultVisit += masDos
        binding.scoreVisitante.text = resultVisit.toString()
    }

    private fun masUnoVisit() {
        resultVisit += masUno
        binding.scoreVisitante.text = resultVisit.toString()
    }

    private fun menosUnoVisit() {
        if(resultVisit>0){
            resultVisit += menosUno
            binding.scoreVisitante.text = resultVisit.toString()
        }else{
            Snackbar.make(binding.root, getString(R.string.puntaje_local), Snackbar.LENGTH_SHORT).show()
        }
    }

    private fun resetScore() {
        resultLocal = 0
        binding.scoreLocal.text = resultLocal.toString()
        resultVisit = 0
        binding.scoreVisitante.text = resultVisit.toString()
        Snackbar.make(binding.root, getString(R.string.reset), Snackbar.LENGTH_SHORT).show()
    }

    private fun seeResult(result: Score) {
        val i = Intent(this, ResultActivity::class.java)
        i.putExtra(KEY_RESULT, result)
        startActivity(i)

    }
}