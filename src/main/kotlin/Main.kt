package kotlin_chess


fun main() {
    val name = "Kotlin"
    println("Hello, " + name + "!")

    for (i in 1..5) {
    println("i = $i")
    }
    val boardHandler = BoardHandler()
    val inputHandler = InputHandler()
    val gameHandler = GameHandler()
    var move = ""
    var pieceChoice : Piece? = null
    var pieceInput = ""
    // TODO: input loop
    
    // TODO: display board
    val gameBoard = gameHandler.startGame("testing")
    boardHandler.printBoard2(gameBoard)

    println("Location of piece you'd like to move?")
    pieceInput = readln()
    pieceChoice = boardHandler.pieceAt(gameBoard, Pair(pieceInput[0], pieceInput[1].digitToInt()))
    
    println("Make a move:")
    move = readln()
    
    boardHandler.makeMove(gameBoard, pieceChoice, Pair(move[0], move[1].digitToInt()));
    // inputHandler.decodeMoveInput(gameBoard, move, gameHandler.activePlayer)

    boardHandler.printBoard2(gameBoard)

}

// typealias MoveSet = Pair<Int, Int>;
enum class PlayerColor {
    WHITE, BLACK
}
val boardHandler = BoardHandler()
class InputHandler {
    
    val letterToNumberMap = mapOf(
        'a' to 1, 'b' to 2, 'c' to 3, 'd' to 4, 
        'e' to 5, 'f' to 6, 'g' to 7, 'h' to 8,
        null to null, //'z' to null
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
    
    
    fun decodeMoveInput(board: Board, move: String, color: PlayerColor) {
        var stripped: String = move.filterNot { it in "+# " } //['+', '++', '#'] }
        assert(!stripped.contains("+") && !stripped.contains("#"))

        when (move.length) {     // TODO: all below
            2 -> {
                //pawn moves
                if (letterToNumberMap.containsKey(stripped[0])) {
                    if (color == PlayerColor.WHITE) {
                        boardHandler.makeMove(board, boardHandler.pieceAt(board, Pair(stripped[0], stripped[1].digitToInt() - 1)), Pair(stripped[0], stripped[1].digitToInt() - 1))
                    }
                    else {
                        boardHandler.makeMove(board, boardHandler.pieceAt(board, Pair(stripped[0], stripped[1].digitToInt() + 1)), Pair(stripped[0], stripped[1].digitToInt() - 1))
                    }
                    
                }
                else {
                    // TODO: error message
                }
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
    
    fun startGame(gameName: String) : Board {
        val board = Board(gameName)
        val boardHandler = BoardHandler()
        for (piece in standardGameStart) {
            boardHandler.addPiece(board, piece)
        }
        return board
    }
    //fun exist legal moves
    //fun is in check
    var movesHistory: MutableList<String> = arrayListOf() // maybe moveset list? probably just 
    var activePlayer = PlayerColor.WHITE
    fun nextTurn() {
        
        if (activePlayer == PlayerColor.WHITE) activePlayer = PlayerColor.BLACK else activePlayer = PlayerColor.WHITE  // switch active color
        // OPTIONAL  log pgn 
    }
    
    fun logMove(move: String) { //maybe moveset?
        // OPTIONAL  convert & add to moveshistory
    }
    // fun is game over
    // var game over : bool
    // var movelist : list<move>
    // var repeatcounter = 0 // how many times position has repeated
    // var stallCounter = 0 // full moves since last capture or pawn move
}

val standardGameStart: Array<Piece> = arrayOf(
    Rook(Pair('a', 1), PlayerColor.WHITE),
    Rook(Pair('a', 8), PlayerColor.BLACK),
    
    Knight(Pair('b', 1), PlayerColor.WHITE),
    Knight(Pair('b', 8), PlayerColor.BLACK),
    
    Bishop(Pair('c', 1), PlayerColor.WHITE),
    Bishop(Pair('c', 8), PlayerColor.BLACK),
    
    Queen(Pair('d', 1), PlayerColor.WHITE),
    Queen(Pair('d', 8), PlayerColor.BLACK),
    
    King(Pair('e', 1), PlayerColor.WHITE),
    King(Pair('e', 8), PlayerColor.BLACK),
    
    Bishop(Pair('f', 1), PlayerColor.WHITE),
    Bishop(Pair('f', 8), PlayerColor.BLACK),
    
    Knight(Pair('g', 1), PlayerColor.WHITE),
    Knight(Pair('g', 8), PlayerColor.BLACK),
    
    Rook(Pair('h', 1), PlayerColor.WHITE),
    Rook(Pair('h', 8), PlayerColor.BLACK),

    Pawn(Pair('a', 2), PlayerColor.WHITE),
    Pawn(Pair('b', 2), PlayerColor.WHITE),
    Pawn(Pair('c', 2), PlayerColor.WHITE),
    Pawn(Pair('d', 2), PlayerColor.WHITE),
    Pawn(Pair('e', 2), PlayerColor.WHITE),
    Pawn(Pair('f', 2), PlayerColor.WHITE),
    Pawn(Pair('g', 2), PlayerColor.WHITE),
    Pawn(Pair('h', 2), PlayerColor.WHITE),

    Pawn(Pair('a', 7), PlayerColor.BLACK),
    Pawn(Pair('b', 7), PlayerColor.BLACK),
    Pawn(Pair('c', 7), PlayerColor.BLACK),
    Pawn(Pair('d', 7), PlayerColor.BLACK),
    Pawn(Pair('e', 7), PlayerColor.BLACK),
    Pawn(Pair('f', 7), PlayerColor.BLACK),
    Pawn(Pair('g', 7), PlayerColor.BLACK),
    Pawn(Pair('h', 7), PlayerColor.BLACK),
    )