package kotlin

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
    println("Hello, " + name + "!")

    for (i in 1..5) {
    println("i = $i")
    }
}

typealias MoveSet = Pair<Int, Int>;
enum class PlayerColor {
    WHITE, BLACK
}

class InputHandler {

    fun decodeMoveInput(move: String) {
        var stripped: String = move.filterNot { it in "+#" } //['+', '++', '#'] }
        assert(!stripped.contains("+") && !stripped.contains("#"))

        when (move.length) {
            2 -> {
                //pawn moves
            }

            3 -> {
                // short castle
                // standard piece move (Bf6)
            }

            4 -> {
                // pawn takes
                // piece takes DIS-0
                // piece moves DIS-1
            }

            5 -> {
                // long castle
                // piece takes DIS-1
                // Q moves DIS-2
            }

            6 -> {
                // Q takes DIS-2
            }
        }
    }
}

class GameHandler {
    //fun exist legal moves
    //fun is in check
    // var whose turn
    // fun is game over
    // var game over : bool
    // var movelist : list<move>
    // var repeatcounter = 0 // how many times position has repeated
    // var stallCounter = 0 // full moves since last capture or pawn move
}
