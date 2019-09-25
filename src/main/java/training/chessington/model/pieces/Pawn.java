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
            if(!isPawnInFront(board, direction, from) && !isPawn2InFront(board, direction, from)) {
                if (isSquareOnBoard(to2squares)) {
                    Move move2 = new Move(from, to2squares);
                    movesArr.add(move2);
                }
            }
        }

        if(!isPawnEndRow( from )) {
            if(!isPawnInFront(board, direction, from)) {
                if (isSquareOnBoard(to1square)){
                    Move move = new Move(from, to1square);
                    movesArr.add(move);
                }
            }
        }

        if (isSquareOnBoard(to1squareDiagonalLeft) && isEnemyPieceInCoord(board, to1squareDiagonalLeft)) {
            Move moveDiagonalLeft = new Move(from, to1squareDiagonalLeft);
            movesArr.add(moveDiagonalLeft);
        }
        if( isSquareOnBoard(to1squareDiagonalRight) && isEnemyPieceInCoord(board,to1squareDiagonalRight)) {
            Move moveDiagonalRight = new Move(from, to1squareDiagonalRight);
            movesArr.add(moveDiagonalRight);
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

    private boolean isPawn2InFront( Board board, int direction, Coordinates from ) {
        Coordinates squareInFront = new Coordinates( from.getRow() + direction * 2, from.getCol() );
        return board.get(squareInFront) != null;
    }

    private boolean isPawnEndRow( Coordinates from ) {
        return getColour().equals(PlayerColour.WHITE) && from.getRow() == 0 || getColour().equals(PlayerColour.BLACK) && from.getRow() == 7;
    }


    private boolean isSquareOnBoard ( Coordinates from) {
        int row = from.getRow();
        int col = from.getCol();
        return row <= 7 && row >= 0 && col <= 7 && col >= 0;
    }

}
