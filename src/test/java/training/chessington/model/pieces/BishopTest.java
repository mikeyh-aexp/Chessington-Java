package training.chessington.model.pieces;

import org.junit.Test;
import training.chessington.model.Board;
import training.chessington.model.Coordinates;
import training.chessington.model.Move;
import training.chessington.model.PlayerColour;

import java.util.List;

import static training.chessington.model.pieces.PieceAssert.*;
import static org.assertj.core.api.Assertions.*;

public class BishopTest {

    @Test
    public void bishopOnlyMoveDiagonal() {
        // Arrange
        Board board = Board.empty();
        Piece bishop = new Bishop(PlayerColour.WHITE);
        Coordinates coords = new Coordinates(4, 5);
        board.placePiece(coords,bishop);

        // Act
        List<Move> moves = bishop.getAllowedMoves(coords, board);

        // Assert
        assertThat(moves).contains(new Move(coords, new Coordinates(2, 3)));
        assertThat(moves).contains(new Move(coords, new Coordinates(2, 7)));
        assertThat(moves).contains(new Move(coords, new Coordinates(3, 6)));
        assertThat(moves).doesNotContain(new Move(coords, new Coordinates(4, 4)));
        assertThat(moves).doesNotContain(new Move(coords, new Coordinates(4, 6)));
        assertThat(moves).doesNotContain(new Move(coords, new Coordinates(5, 5)));

    }
}
