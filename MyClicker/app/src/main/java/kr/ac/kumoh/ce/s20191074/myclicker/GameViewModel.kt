package kr.ac.kumoh.ce.s20191074.myclicker

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import kotlin.math.log2

class GameViewModel(context: Application): AndroidViewModel(context) {
    private val dao = GameDatabase.getDatabase(context)!!.gameDao()
    private val repository = GameRepository(dao)

    var money: Long = 0
    var level: Long = 0
    var seed: Int = 0

    fun connect() {
        var data = dao.select()
        if (data == null){
            Log.i("Database", "INSERT")
            dao.insert((0..99999).random())
            data = dao.select()
        }
        Log.i("Datebase", data.toString())

        money = data.money
        level = data.level
        seed = data.seed
    }

    fun save() {
        val data = GameState(1, money, level, seed)
        dao.update(data)
    }

    fun newGame() {
        dao.delete(GameState(1, money, level, seed))
        dao.insert((0..99999).random())
        val data = dao.select()

        money = data.money
        level = data.level
        seed = data.seed
    }

    fun levelUpCost(l: Long): Long {
        return l * l * log2(l.toDouble()).toLong() + 10L
    }

    fun addMoney() {
        money += level
    }

    fun levelUp() {
        val cost = levelUpCost(level)

        if (money >= cost) {
            money -= cost
            level++
        }
    }
}