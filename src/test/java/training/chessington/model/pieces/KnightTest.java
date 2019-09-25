package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class KnightTest {


    @Test
    public void whiteKnightCanMoveInLShape() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 4);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, new Coordinates(3, 2)));
        assertThat(moves).contains(new Move(coords, new Coordinates(5, 2)));
        assertThat(moves).contains(new Move(coords, new Coordinates(3, 6)));
    }

    @Test
    public void isWhiteKnightOutOfBounds() {
        // Arrange
        Board board = Board.empty();
        Piece knight = new Knight(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(5, 7);
        board.placePiece(coords, knight);

        // Act
        List<Move> moves = knight.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, new Coordinates(3, 8)));
        assertThat(moves).contains(new Move(coords, new Coordinates(7, 8)));
        assertThat(moves).contains(new Move(coords, new Coordinates(3, 9)));

    }

}
