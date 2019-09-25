package training.chessington.model.pieces;

import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.PlayerColour;

public abstract class AbstractPiece implements Piece {

    protected final Piece.PieceType type;
    protected final PlayerColour colour;

    protected AbstractPiece(Piece.PieceType type, PlayerColour colour) {
        this.type = type;
        this.colour = colour;
    }

    @Override
    public Piece.PieceType getType() {
        return type;
    }

    @Override
    public PlayerColour getColour() {
        return colour;
    }

    @Override
    public String toString() {
        return colour.toString() + " " + type.toString();
    }

    protected boolean isEnemyPieceInCoord(Board board, Coordinates coord ) {
        return board.get(coord) != null && !board.get(coord).getColour().equals(getColour());
    }

    protected boolean isFriendlyPieceInCoord(Board board, Coordinates coord) {
        return board.get(coord) != null && board.get(coord).getColour().equals(getColour());
    }

    protected boolean isSquareOnBoard (Coordinates from) {
        int row = from.getRow();
        int col = from.getCol();
        return row <= 7 && row >= 0 && col <= 7 && col >= 0;
    }
}
