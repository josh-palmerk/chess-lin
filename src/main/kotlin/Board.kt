package kotlin

typealias BoardSquare = Pair<Char, Int>;
typealias File = Array<Piece?>;
typealias AllFiles = Map<Char, File>;
// typealias AllRanks = Map<Int, BoardLine>;

class Board {
    var files: AllFiles = mapOf<Char, File>();
    
    

    // fun emptyBetween(sq1, sq2) : bool
}

class MoveHandler {
    //trymovepiece: 
        // duplicate board
        // make move on "try" board
        // assess legality (in check?)
        // if legal, return pair (true, null)
        // if not, return pair(false, reason)
        // isnt this just what is_move_legal supposed to do
    //movepiece
    //scan(Direction, length)
    //is_move_legal
}

