package kotlin

import javax.swing.JToolBar.Separator

typealias BoardSquare = Pair<Char, Int>;
typealias File = Array<Piece?>;
typealias AllFiles = Map<Char, File>;
// typealias AllRanks = Map<Int, BoardLine>;

data class Board (
    val gameName:String
){
    var files: AllFiles = mapOf<Char, File>(
        'a' to arrayOfNulls<Piece?>(8), 'b' to arrayOfNulls<Piece?>(8), 
        'c' to arrayOfNulls<Piece?>(8), 'd' to arrayOfNulls<Piece?>(8),
        'e' to arrayOfNulls<Piece?>(8), 'f' to arrayOfNulls<Piece?>(8), 
        'g' to arrayOfNulls<Piece?>(8), 'h' to arrayOfNulls<Piece?>(8)
    );
    // var all pieces map<playercolor, piece array>()
    // fun toString

    // fun emptyBetween(sq1, sq2) : bool
}

public class BoardHandler {
    
    val inputHandler = InputHandler()
    fun tryMovePiece(board: Board, piece: Piece, destination: BoardSquare) {
        // duplicate board
        var newBoard = board.copy();
        // make move on "try" board

        // assess legality (in check?)
        // if legal, return pair (true, null or "valid")
        // if not, return pair(false, invalidReason)
    }

    fun makeMove(board: Board, piece: Piece, destination: BoardSquare) {
        
    }
    
    // isnt this just what is_move_legal supposed to do
    public fun isSquareEmpty(board: Board, square: BoardSquare): Boolean {
        return board.files[square.first]!![square.second] == null
    }
    
    fun isDirectionEmpty(board: Board, square: BoardSquare): Boolean {
        //TODO
        return false
    }
    
    fun scanSquareForPiece(board: Board, square: BoardSquare, piece: Piece) : Boolean {
        return (isSquareEmpty(board, square)) && (board.files[square.first]!![square.second]!!::class == piece::class) 
    }
    
    fun scanDirectionForPiece(board: Board, square: BoardSquare, direction: Direction, distance: Int){
        // switch based on direction
        var potentialLocations = listOf<BoardSquare>()
        when (direction) {
            Direction.OMNI -> {}
            Direction.CARDINAL -> {}
            Direction.DIAGONAL -> {} // TODO: all of this, using getPossibleMoves
            Direction.CHIVALROUS -> {}
            Direction.FORWARD -> {}
            // else -> {}
        }
    }
    
    fun getAllRanks(board: Board) : List<List<Char>> {
        var allRanksList = mutableListOf<MutableList<Char>>();
        for (i in 1..8) {   // Ranks 1-8
            var rankList = mutableListOf<Char>()
            for (j in 1..8) {   // files a-h
                val fileChar = inputHandler.numberToLetter(j)
                val file = board.files[fileChar]
                rankList.add((file!!.getOrNull(j) ?: ' ') as Char)
            }
            allRanksList.add(rankList)
        }
        return allRanksList
    }

    fun printBoard(board: Board) {
        val ranks = getAllRanks(board)
        println("_______________________________________")
        for (rank in ranks) {
            println("| " + rank.joinToString(separator = " | ") + " |"); // needs \n ?
            println("_______________________________________") 
        }
        
    }
    
    fun addPiece(board: Board, piece: Piece){ 
        board.files[piece.location!!.first]!![piece.location!!.second] = piece   // Added to board
        //TODO optional add to allPieces attribute
    }
//    override fun toString(): String {
//        return getAllRanks(this).joinToString {  }
//    }
    //is_move_legal_kingwise
}

