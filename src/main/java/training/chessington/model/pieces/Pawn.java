package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends AbstractPiece {
    public Pawn(PlayerColour colour) {
        super(Piece.PieceType.PAWN, colour);
    }

    @Override
    public List<Move> getAllowedMoves(Coordinates from, Board board) {

        ArrayList<Move> movesArr = new ArrayList<>();

        int direction = getColour().equals(PlayerColour.WHITE) ?
                -1 : 1;

        Coordinates to = new Coordinates(from.getRow() + direction, from.getCol());
        if(isPawnStartRow(from)) {
            Coordinates to2 = new Coordinates(from.getRow() + 2 * direction, from.getCol());
            Move move2 = new Move(from, to2);
            movesArr.add(move2);
        }

        Move move = new Move(from, to);
        movesArr.add(move);

        return movesArr;
    }



    private boolean isPawnStartRow( Coordinates from ){
        return getColour().equals(PlayerColour.WHITE) && from.getRow() == 6 || getColour().equals(PlayerColour.BLACK) && from.getRow() == 1;
    }


}
