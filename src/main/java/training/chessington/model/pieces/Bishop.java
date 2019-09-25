package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Bishop extends AbstractPiece {
    public Bishop(PlayerColour colour) {
        super(PieceType.BISHOP, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        ArrayList<Move> movesArr = new ArrayList<>();
        ArrayList<Coordinates> coordArr = new ArrayList<>();


        for (int i = 1; i < 8; i++) {
            coordArr.add(from.plus(-i, -i));
            coordArr.add(from.plus(-i, i));
            coordArr.add(from.plus(i, -i));
            coordArr.add(from.plus(i, i));
        }

//        for (int i = 1; i < 8; i++) {
//            if(shouldBreakHere(from.plus(-i,i))){
//                break;
//            }
//            coordArr.add(from.plus(-i, -i));
//        }

        for ( Coordinates item : coordArr ) {
            if (isSquareOnBoard(item) && !isFriendlyPieceInCoord(board, item)) {
                movesArr.add(new Move(from, item));
            }
        }

        return movesArr;
    }
}
