package OX

import java.util.Scanner

var arrOX = arrayOf(
        arrayOf(' ', '1', '2', '3'),
        arrayOf('1', '-', '-', '-'),
        arrayOf('2', '-', '-', '-'),
        arrayOf('3', '-', '-', '-')
)
var flag = true;
var player = 'X';
fun main() {
    val kb = Scanner(System.`in`)
    var round = 0;
    showWelcome()
    showTable()
    while (flag) {
        showTurn(round)
        var inputRow = kb.next();
        var inputCol = kb.next();
        setTable(inputRow, inputCol, player)
        showTable()
        checkHorizantal(player)
        checkVertical(player)
        chcekDiagonal(player)
        checkIsDraw(round)
        round++;
    }
}

fun showWelcome() {
    println("Welcome to OX Game")
}
fun showTurn(round: Int) {
    if (round % 2 == 0) {
        player = 'X'
        println("X turn")
        print("Please input Row Col: ")
    } else {
        player = 'O'
        println("O turn")
        print("Please input Row Col: ")
    }
}

fun setTable(row: String, col: String, player: Char) {
    try {
        if (arrOX[row.toInt()][col.toInt()] === '-') {
            arrOX[row.toInt()][col.toInt()] = player
        } else {
            flag = false;
            println("Fail your stupid press!!!!")
        }
    } catch (e: Throwable) {
        flag = false;
        println("Fail your stupid press!!!!")
    }
}

fun showTable() {
    for (i in arrOX.indices) {
        for (j in arrOX[i].indices) {
            print(" ${arrOX[i][j]}")
        }
        println()
    }
}

fun checkHorizantal(player: Char) {
    var count = 0;
    for (i in arrOX.indices) {
        for (j in arrOX[i].indices) {
            if (arrOX[i][j] === player) {
                count++;
            }
        }
        if (count === 3) {
            flag = false;
            println("${player} WIN ")
        }
        count = 0;
    }
}

fun checkVertical(player: Char) {
    var count = 0;
    for (i in arrOX.indices) {
        for (j in arrOX[i].indices) {
            if (arrOX[j][i] === player) {
                count++;
            }
        }
        if (count === 3) {
            flag = false;
            println("${player} WIN ")
        }
        count = 0;
    }
}

fun chcekDiagonal(player: Char) {
    if (arrOX[1][1] === player && arrOX[2][2] === player && arrOX[3][3] === player) {
        println("${player} WIN ")
        flag = false;
    } else if (arrOX[1][3] === player && arrOX[2][2] === player && arrOX[3][1] === player) {
        println("${player} WIN ")
        flag = false;
    }
}

fun checkIsDraw(round: Int) {
    if (round == 8 && flag) {
        println("DRAW!!!!")
        flag = false
    }
}


