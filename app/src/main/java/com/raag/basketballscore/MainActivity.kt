package com.raag.basketballscore

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.raag.basketballscore.ResultActivity.Companion.KEY_RESULT_LOCAL
import com.raag.basketballscore.ResultActivity.Companion.KEY_RESULT_VISITOR
import com.raag.basketballscore.databinding.ActivityMainBinding
import com.raag.basketballscore.model.Score
import com.raag.basketballscore.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.localScore.observe(this, Observer {
            binding.scoreLocal.text = it.toString()
        })

        viewModel.visitScore.observe(this, Observer {
            binding.scoreVisitante.text = it.toString()
        })

        binding.reset.setOnClickListener {
            viewModel.resetScore()
            Snackbar.make(binding.root, getString(R.string.reset), Snackbar.LENGTH_SHORT).show()
        }
        binding.menosUnoLocal.setOnClickListener {
            viewModel.quitarPointLocal()
        }

        binding.masUnoLocal.setOnClickListener {
            viewModel.aumentarPoint(1, true)
        }

        binding.masDosLocal.setOnClickListener {
            viewModel.aumentarPoint(2, true)
        }

        binding.menosUnoVisit.setOnClickListener {
            viewModel.quitarPointVisit()
        }

        binding.masUnoVisit.setOnClickListener {
            viewModel.aumentarPoint(1, false)
        }

        binding.masDosVisit.setOnClickListener {
            viewModel.aumentarPoint(2, false)
        }

        binding.result.setOnClickListener {
            seeResult()
        }
    }
    private fun seeResult() {
        val i = Intent(this, ResultActivity::class.java)
        i.putExtra(KEY_RESULT_LOCAL, viewModel.localScore.value)
        i.putExtra(KEY_RESULT_VISITOR, viewModel.visitScore.value)
        startActivity(i)

    }
}