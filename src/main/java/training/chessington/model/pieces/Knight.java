package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Knight extends AbstractPiece {
    public Knight(PlayerColour colour) {
        super(PieceType.KNIGHT, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        ArrayList<Move> movesArr = new ArrayList<>();
        ArrayList<Coordinates> coordArr = new ArrayList<>();

        coordArr.add(from.plus(-2, -1));
        coordArr.add(from.plus(-2,+1));
        coordArr.add(from.plus(-1,-2));
        coordArr.add(from.plus(+1,-2));
        coordArr.add(from.plus(+2,-1));
        coordArr.add(from.plus(+2,+1));
        coordArr.add(from.plus(-1,+2));
        coordArr.add(from.plus(+1,+2));

        for ( Coordinates item : coordArr ) {

            if (isEnemyPieceInCoord(board, item)) {
                movesArr.add(new Move(from, item));
            }
        }
        return movesArr;
    }
}
