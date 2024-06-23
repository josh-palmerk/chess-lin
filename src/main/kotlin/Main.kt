package kotlin

import jdk.internal.foreign.abi.Binding

fun main() {
    val name = "Kotlin"
    println("Hello, " + name + "!")

    for (i in 1..5) {
    println("i = $i")
    }
    
    
    // TODO: input loop
    
    // TODO: display board
}

// typealias MoveSet = Pair<Int, Int>;
enum class PlayerColor {
    WHITE, BLACK
}

class InputHandler {
    val letterToNumberMap = mapOf(
        'a' to 1, 'b' to 2, 'c' to 3, 'd' to 4, 
        'e' to 5, 'f' to 6, 'g' to 7, 'h' to 8,
        null to null, 'z' to null
    )
    val numberToLetterMap = mapOf(
        1 to 'a', 2 to 'b', 3 to 'c', 4 to 'd',
        5 to 'e', 6 to 'f', 7 to 'g', 8 to 'h',
        null to null
    )

    fun letterToNumber(c: Char?): Int? {
        // assert(letterToNumberMap[c] != null)
        return letterToNumberMap[c]
    }
    fun numberToLetter(n: Int?): Char? {
        // assert(numberToLetterMap[n] != null)
        return numberToLetterMap[n]
    }
    
    fun charMath(augend: Char, addend: Int): Char? {
        return numberToLetter(letterToNumber(augend)?.plus(addend))
    }
    
    
    fun decodeMoveInput(move: String) {
        var stripped: String = move.filterNot { it in "+#" } //['+', '++', '#'] }
        assert(!stripped.contains("+") && !stripped.contains("#"))

        when (move.length) {     // TODO: all below
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

class GameHandler {                  // TODO: a ton of this
    //fun exist legal moves
    //fun is in check
    var movesHistory: MutableList<String> = arrayListOf() // maybe moveset list? probably just 
    var activePlayer = PlayerColor.WHITE
    fun nextTurn() {
        
        if (activePlayer == PlayerColor.WHITE) activePlayer = PlayerColor.BLACK else activePlayer = PlayerColor.WHITE  // switch active color
        // log pgn 
    }
    
    fun logMove(move: String) { //maybe moveset?
        // convert & add to moveshistory
    }
    // fun is game over
    // var game over : bool
    // var movelist : list<move>
    // var repeatcounter = 0 // how many times position has repeated
    // var stallCounter = 0 // full moves since last capture or pawn move
}
