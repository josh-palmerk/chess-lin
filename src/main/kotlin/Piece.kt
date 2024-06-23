package kotlin_chess
import java.awt.Color
import kotlin.*
import kotlin_chess.BoardHandler.*

enum class Direction {
    CARDINAL, DIAGONAL, FORWARD, OMNI, CHIVALROUS
}

// fun moveomni
// TODO: add cardinal and diagonal together

//fun moveChivalrous
// TODO

fun moveHorizontal(square: BoardSquare, yAmount: Int) : BoardSquare {
    val inputHandler = InputHandler()
    return BoardSquare(inputHandler.charMath(square.first, yAmount) ?: 'z', square.second)
}
fun moveVertical(square: BoardSquare, xAmount: Int) : BoardSquare {
    return BoardSquare(square.first, square.second + xAmount)
}


fun getPossibleMoves(board: Board, piece: Piece): List<BoardSquare> {
    var possibleMoves = mutableListOf<BoardSquare>()
    assert(piece.location != null)
    var currLocation = piece.location!!
    val boardHandler = BoardHandler()
    val inputHandler = InputHandler()
    var currChecking:BoardSquare;
    when (piece.moveType) {
        
        Direction.OMNI -> {
            // TODO: add cardinal and diagonal together
        }
        
        Direction.CARDINAL -> {
            
            for (y in 1..piece.moveDistance) { // up (white persp.)
                currChecking = moveVertical(currLocation, y)
                if (boardHandler.isSquareEmpty(board, currChecking) && currChecking.second < 9) {
                    possibleMoves.add(currChecking)
                }
                else break; //TODO: add capture square as possible move to ALL OF THESE!!!!!! ooops
            }
            for (y in -1 downTo -piece.moveDistance) { // down (white persp.)
                currChecking = moveVertical(currLocation, y)
                if (boardHandler.isSquareEmpty(board, currChecking) && currChecking.second > 0) {
                    possibleMoves.add(currChecking)
                }
                else break;
            }
            for (x in 1..piece.moveDistance) { // right (white persp.)
                currChecking = moveHorizontal(currLocation, x)
                if (boardHandler.isSquareEmpty(board, currChecking) && inputHandler.letterToNumber(currChecking.first) != null) {
                    possibleMoves.add(currChecking)
                }
                else break;
            }
            for (x in -1 downTo -piece.moveDistance) { // left (white persp.)
                currChecking = moveHorizontal(currLocation, x)
                if (boardHandler.isSquareEmpty(board, currChecking) && inputHandler.letterToNumber(currChecking.first) != null) {
                    possibleMoves.add(currChecking)
                }
                else break;
            }
        }
        
        Direction.DIAGONAL -> {
            // var currChecking:BoardSquare;
            for (y in 1..piece.moveDistance) { // up-left (white persp.)
                currChecking = moveHorizontal(moveVertical(currLocation, y), -y)
                if (boardHandler.isSquareEmpty(board, currChecking) && currChecking.second < 9) {
                    possibleMoves.add(currChecking)
                }
                else break;
            }
            for (y in -1 downTo -piece.moveDistance) { // down-right (white persp.)
                currChecking = moveHorizontal(moveVertical(currLocation, y), -y)
                if (boardHandler.isSquareEmpty(board, currChecking) && currChecking.second > 0) {
                    possibleMoves.add(currChecking)
                }
                else break;
            }
            for (x in 1..piece.moveDistance) { // up-right (white persp.)
                currChecking = moveVertical(moveHorizontal(currLocation, x), x)
                if (boardHandler.isSquareEmpty(board, currChecking) && inputHandler.letterToNumber(currChecking.first) != null) {
                    possibleMoves.add(currChecking)
                }
                else break;
            }
            for (x in -1 downTo -piece.moveDistance) { // down-left (white persp.)
                currChecking = moveVertical(moveHorizontal(currLocation, x), -x)
                if (boardHandler.isSquareEmpty(board, currChecking) && inputHandler.letterToNumber(currChecking.first) != null) {
                    possibleMoves.add(currChecking)
                }
                else break;
            }
        }
        
        Direction.CHIVALROUS -> {} // TODO: Figure out how the heck a knight moves
        
        
        Direction.FORWARD -> { // TODO: Account for pawn attack 
            if (piece.color == PlayerColor.WHITE) {
                for (y in 1..piece.moveDistance) {
                    currChecking = moveVertical(currLocation, y)
                    if (boardHandler.isSquareEmpty(board, currChecking) && currChecking.second < 9) {
                        possibleMoves.add(currChecking)
                    } else break;
                }
            }
            else {   //if (piece.color == PlayerColor.BLACK) {}
                for (y in -1 downTo piece.moveDistance) {
                    currChecking = moveVertical(currLocation, y)
                    if (boardHandler.isSquareEmpty(board, currChecking) && currChecking.second > 0) {
                        possibleMoves.add(currChecking)
                    }
                    else break;
                }                
            }
        }
    }
    return possibleMoves
}

open class Piece (
    open var location: BoardSquare?,
    open var color: PlayerColor,
) {
    open val moveDistance : Int = 0;
    open val moveType : Direction = Direction.OMNI;
    open val materialValue: Int = 0;
    open var hasMoved : Boolean = false;
    open val selfAsString: String = "G"
    
    fun movePiece(destination: BoardSquare) {
        this.location = destination
        if (!this.hasMoved) {
            this.hasMoved = true;
        }
    };
    
    override fun toString(): String {
        return selfAsString
    }
}


class King (
    override var location: BoardSquare?,
    override var color: PlayerColor,
): Piece(location, color) {
    override val moveDistance = 1;
    override val moveType = Direction.OMNI;
    override val selfAsString: String = "K";
}

class Queen (
    override var location: BoardSquare?,
    override var color: PlayerColor,
): Piece(location, color) {
    override val moveDistance = 16;
    override val moveType = Direction.OMNI;
    override val materialValue: Int = 9;
    override val selfAsString: String = "Q";

}

class Rook (
    override var location: BoardSquare?,
    override var color: PlayerColor,
): Piece(location, color) {
    override val moveDistance = 16;
    override val moveType = Direction.CARDINAL;
    override val materialValue: Int = 5;
    override val selfAsString: String = "R";

}

class Bishop (
    override var location: BoardSquare?,
    override var color: PlayerColor,
): Piece(location, color) {
    override val moveDistance = 16;
    override val moveType = Direction.DIAGONAL;
    override val materialValue: Int = 3;
    override val selfAsString: String = "B";

}

class Knight (
    override var location: BoardSquare?,
    override var color: PlayerColor,
): Piece(location, color) {
    override val moveDistance = 3;
    override val moveType = Direction.CHIVALROUS;
    override val materialValue: Int = 3;
    override val selfAsString: String = "N";

}

class Pawn (
    override var location: BoardSquare?,
    override var color: PlayerColor,
): Piece(location, color) {
    override val moveDistance = 1;
    override val moveType = Direction.FORWARD;
    override val materialValue: Int = 1;
    override val selfAsString: String = "p";

}