package com.raag.basketballscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raag.basketballscore.MainActivity.Companion.KEY_RESULT
import com.raag.basketballscore.databinding.ActivityResultBinding
import com.raag.basketballscore.model.Score

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding

    private var local:Int = 0
    private var visit: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        val result = bundle?.getParcelable<Score>(KEY_RESULT)!!

        local = result.scoreOne
        visit = result.scoreTwo

        binding.resultLocal.text = local.toString()
        binding.resultVisit.text = visit.toString()

        interpretacion()


    }

    private fun interpretacion() {
        if(local == visit){
            binding.iterpretacion.text = "Fue un empate \uD83D\uDE15"
        }

        if ( local > visit){
            binding.iterpretacion.text = "¡Ganó el equipo local!"
        }

        if ( local < visit){
            binding.iterpretacion.text = "¡Ganó el equipo visitante!"
        }
    }
}