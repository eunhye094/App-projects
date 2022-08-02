package kr.ac.kumoh.ce.s20191074.myclicker

import android.annotation.SuppressLint
import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kr.ac.kumoh.ce.s20191074.myclicker.databinding.ActivityMainBinding
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    private lateinit var view: ActivityMainBinding
    private lateinit var viewModel: GameViewModel

    var level: Long = 0
        get() = viewModel.level
    var seed: Int = 0
        get() = viewModel.seed

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityMainBinding.inflate(layoutInflater);
        setContentView(view.root)

        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        connect()

        view.btnLevelUp.setOnClickListener {
            viewModel.levelUp()

            setMoney()
            setLevelUp()
            view.gameView.invalidate()
        }

        view.btnNewGame.setOnClickListener {
            newGame()
        }

        view.btnSaveGame.setOnClickListener {
            save()
        }
    }

    override fun onStop() {
        super.onStop()

        save()
    }

    fun connect() {
        Thread(Runnable {
            viewModel.connect()

            setMoney()
            setLevelUp()
        }).start()
    }

    fun save() {
        val task = object: AsyncTask<Unit, Unit, Unit>() {
            override fun doInBackground(vararg p0: Unit?) {
                viewModel.save()
            }

            override fun onPostExecute(result: Unit) {
                super.onPostExecute(result)

                Toast.makeText(getApplication(), "Game saved", Toast.LENGTH_SHORT).show()
            }
        }
        task.execute(Unit)
    }

    fun newGame() {
        val task = object: AsyncTask<Unit, Unit, Unit>() {
            override fun doInBackground(vararg p0: Unit?) {
                viewModel.newGame()
            }

            override fun onPostExecute(result: Unit) {
                super.onPostExecute(result)

                setMoney()
                setLevelUp()
                view.gameView.invalidate()

                Toast.makeText(getApplication(), "Game Deleted", Toast.LENGTH_SHORT).show()
            }
        }
        task.execute(Unit)
    }

    fun setMoney() {
        val f = DecimalFormat("$###,###")
        view.textView.text = f.format(viewModel.money)
    }

    fun setLevelUp() {
        val cost = viewModel.levelUpCost(viewModel.level)
        val f = DecimalFormat("$###,###")
        val next = f.format(cost)
        view.btnLevelUp.text = "[현재 레벨: ${viewModel.level}] 레벨 업 ($next 필요)"
    }

    fun addMoney() {
        viewModel.addMoney()
        setMoney()
    }
}