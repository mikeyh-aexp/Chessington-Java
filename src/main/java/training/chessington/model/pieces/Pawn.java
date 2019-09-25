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

        int direction = getColour().equals(PlayerColour.WHITE) ? -1 : 1;

        Coordinates to1square = new Coordinates(from.getRow() + direction, from.getCol());
        Coordinates to1squareDiagonalLeft = new Coordinates(from.getRow() + direction, from.getCol() - 1);
        Coordinates to1squareDiagonalRight = new Coordinates(from.getRow() + direction, from.getCol() + 1);

        if(isPawnStartRow(from)) {
            Coordinates to2squares = new Coordinates(from.getRow() + 2 * direction, from.getCol());
            Move move2 = new Move(from, to2squares);
            movesArr.add(move2);
        }

        if(!isPawnEndRow( from )) {
            if(!isPawnInFront(board, direction, from)) {
                Move moveDiagonalLeft = new Move(from, to1squareDiagonalLeft);
                Move moveDiagonalRight = new Move(from, to1squareDiagonalRight);
                movesArr.add(moveDiagonalLeft);
                movesArr.add(moveDiagonalRight);
                Move move = new Move(from, to1square);
                movesArr.add(move);
            }

        }

        return movesArr;
    }



    private boolean isPawnStartRow( Coordinates from ){
        return getColour().equals(PlayerColour.WHITE) && from.getRow() == 6 || getColour().equals(PlayerColour.BLACK) && from.getRow() == 1;
    }

    private boolean isPawnInFront( Board board, int direction, Coordinates from ) {
        Coordinates squareInFront = new Coordinates( from.getRow() + direction, from.getCol() );
        return board.get(squareInFront) != null;
    }

    private boolean isPawnEndRow( Coordinates from ) {
        return getColour().equals(PlayerColour.WHITE) && from.getRow() == 0 || getColour().equals(PlayerColour.BLACK) && from.getRow() == 7;
    }
//
//    private boolean isPawnDiagonal( Board board, int direction, Coordinates from ) {
//        // if pawn is NOT in a diagonal square
//            // do not allow current pawn to move
//        // only allow to move if pawn can capture
//
//    };

}
