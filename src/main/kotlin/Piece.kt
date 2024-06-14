package kotlin
import kotlin.*

enum class Direction {
    CARDINAL, DIAGONAL, FORWARD, OMNI, CHIVALROUS
}


open class Piece (
    open var location: BoardSquare?,
    open var color: PlayerColor,
) {
    open val moveDistance : Int = 0;
    open val moveType : Direction = Direction.OMNI;
    open val materialValue: Int = 0;
    open var hasMoved : Boolean = false;
    //fun movePiece(destination: Pair<Int,Int>);
}


class King (
    override var location: BoardSquare?,
    override var color: PlayerColor,
): Piece(location, color) {
    override val moveDistance = 1;
    override val moveType = Direction.OMNI;

}

class Queen (
    override var location: BoardSquare?,
    override var color: PlayerColor,
): Piece(location, color) {
    override val moveDistance = 16;
    override val moveType = Direction.OMNI;
    override val materialValue: Int = 9;
}

class Rook (
    override var location: BoardSquare?,
    override var color: PlayerColor,
): Piece(location, color) {
    override val moveDistance = 16;
    override val moveType = Direction.CARDINAL;
    override val materialValue: Int = 5;
}

class Bishop (
    override var location: BoardSquare?,
    override var color: PlayerColor,
): Piece(location, color) {
    override val moveDistance = 16;
    override val moveType = Direction.DIAGONAL;
    override val materialValue: Int = 3;
}

class Knight (
    override var location: BoardSquare?,
    override var color: PlayerColor,
): Piece(location, color) {
    override val moveDistance = 3;
    override val moveType = Direction.CHIVALROUS;
    override val materialValue: Int = 3;
}

class Pawn (
    override var location: BoardSquare?,
    override var color: PlayerColor,
): Piece(location, color) {
    override val moveDistance = 1;
    override val moveType = Direction.FORWARD;
    override val materialValue: Int = 1;
}