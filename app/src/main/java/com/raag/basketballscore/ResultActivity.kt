package com.raag.basketballscore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.raag.basketballscore.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    companion object{
        const val KEY_RESULT_LOCAL = "local"
        const val KEY_RESULT_VISITOR = "visit"
    }
    private lateinit var binding: ActivityResultBinding

    private var local:Int = 0
    private var visit: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle = intent.extras
        local = bundle?.getInt(KEY_RESULT_LOCAL)!!
        visit = bundle.getInt(KEY_RESULT_VISITOR)

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