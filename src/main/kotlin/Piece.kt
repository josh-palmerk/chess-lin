package org.example

enum class Direction {
    CARDINAL, DIAGONAL, FORWARD, OMNI, CHIVALROUS
}
class Piece {
    var location = null;
    val moveDistance = 0;
    val moveType = Direction.OMNI;
}