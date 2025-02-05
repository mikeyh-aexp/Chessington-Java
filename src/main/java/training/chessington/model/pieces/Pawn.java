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

        if(getColour() == PlayerColour.WHITE) {
            Coordinates to = new Coordinates(from.getRow() - 1, from.getCol());
            Move move = new Move(from, to);
            movesArr.add(move);
        } else {
            Coordinates to = new Coordinates(from.getRow() + 1, from.getCol());
            Move move = new Move(from, to);
            movesArr.add(move);
        }

        return movesArr;
    }
}
