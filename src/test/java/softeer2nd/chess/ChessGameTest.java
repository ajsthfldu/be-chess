package softeer2nd.chess;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import softeer2nd.chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static softeer2nd.chess.pieces.Piece.*;
import static softeer2nd.chess.pieces.PieceFactory.*;
import static softeer2nd.utils.StringUtils.appendNewLine;

class ChessGameTest {
    ChessGame game;

    @BeforeEach
    public void setup() {
        game = new ChessGame(new Board());
    }

    @Test
    @DisplayName("체스규칙에 따라 초기화해야 한다")
    public void create() throws Exception {
        game.initialize();
        assertEquals(32, game.pieceCount());
        String blankRank = appendNewLine("........");
        assertEquals(
                appendNewLine("RNBQKBNR") +
                        appendNewLine("PPPPPPPP") +
                        blankRank + blankRank + blankRank + blankRank +
                        appendNewLine("pppppppp") +
                        appendNewLine("rnbqkbnr"),
                new ChessView(game.getBoard()).showBoard());
    }

    @Test
    @DisplayName("기물의 수를 파악해야 한다")
    void pieceCount() {
        game.initialize();
        assertEquals(32, game.pieceCount(Piece.Color.NOCOLOR, Piece.Type.NO_PIECE));

        assertEquals(8, game.pieceCount(Piece.Color.WHITE, Piece.Type.PAWN));
        assertEquals(2, game.pieceCount(Piece.Color.WHITE, Piece.Type.KNIGHT));
        assertEquals(2, game.pieceCount(Piece.Color.WHITE, Piece.Type.ROOK));
        assertEquals(2, game.pieceCount(Piece.Color.WHITE, Piece.Type.BISHOP));
        assertEquals(1, game.pieceCount(Piece.Color.WHITE, Piece.Type.QUEEN));
        assertEquals(1, game.pieceCount(Piece.Color.WHITE, Piece.Type.KING));

        assertEquals(8, game.pieceCount(Piece.Color.BLACK, Piece.Type.PAWN));
        assertEquals(2, game.pieceCount(Piece.Color.BLACK, Piece.Type.KNIGHT));
        assertEquals(2, game.pieceCount(Piece.Color.BLACK, Piece.Type.ROOK));
        assertEquals(2, game.pieceCount(Piece.Color.BLACK, Piece.Type.BISHOP));
        assertEquals(1, game.pieceCount(Piece.Color.BLACK, Piece.Type.QUEEN));
        assertEquals(1, game.pieceCount(Piece.Color.BLACK, Piece.Type.KING));
    }

    @Test
    @DisplayName("어떤 위치에 어떤 기물이 있는 지 알 수 있어야 한다")
    public void findPiece() throws Exception {
        game.initialize();

        assertEquals(createBlackRook(), game.findPiece("a8"));
        assertEquals(createBlackRook(), game.findPiece("h8"));
        assertEquals(createWhiteRook(), game.findPiece("a1"));
        assertEquals(createWhiteRook(), game.findPiece("h1"));
    }

    @Test
    @DisplayName("새로운 기물을 지정한 위치에 놓을 수 있어야 한다")
    public void add() throws Exception {
        game.initializeEmpty();

        String position = "b5";
        Piece piece = createBlackRook();
        game.move(position, piece);

        assertEquals(piece, game.findPiece(position));
    }

    @Test
    @DisplayName("선택한 위치의 기물을 지정한 위치에 놓을 수 있어야 한다")
    public void move() throws Exception {
        game.initialize();

        String sourcePosition = "b2";
        String targetPosition = "b3";
        game.move(sourcePosition, targetPosition);
        assertEquals(createBlank(), game.findPiece(sourcePosition));
        assertEquals(createWhitePawn(), game.findPiece(targetPosition));
    }

    @Test
    @DisplayName("색상별 점수를 계산할 수 있어야 한다")
    public void calculatePoint() throws Exception {
        game.initializeEmpty();

        addPiece("b6", createBlackPawn());
        addPiece("e6", createBlackQueen());
        addPiece("a7", createBlackPawn());
        addPiece("c7", createBlackPawn());
        addPiece("d7", createBlackBishop());
        addPiece("b8", createBlackKing());
        addPiece("c8", createBlackRook());

        addPiece("f4", createWhiteKnight());
        addPiece("g4", createWhiteQueen());
        addPiece("f3", createWhitePawn());
        addPiece("h2", createWhitePawn());
        addPiece("f2", createWhitePawn());
        addPiece("g2", createWhitePawn());
        addPiece("e1", createWhiteRook());
        addPiece("f1", createWhiteKing());

        assertEquals(20.0, game.calculatePoint(Color.BLACK), 0.01);
        assertEquals(19.5, game.calculatePoint(Color.WHITE), 0.01);
    }

    private void addPiece(String position, Piece piece) {
        game.move(position, piece);
    }


    @Test
    @DisplayName("색상별 기물의 점수에 따라 정렬된 리스트를 얻을 수 있어야 한다")
    public void getSortedPieces() {
        game.initializeEmpty();

        addPiece("b6", createBlackPawn());
        addPiece("e6", createBlackQueen());
        addPiece("a7", createBlackPawn());
        addPiece("c7", createBlackPawn());
        addPiece("d7", createBlackBishop());
        addPiece("b8", createBlackKing());
        addPiece("c8", createBlackRook());

        addPiece("f4", createWhiteKnight());
        addPiece("g4", createWhiteQueen());
        addPiece("f3", createWhitePawn());
        addPiece("h2", createWhitePawn());
        addPiece("f2", createWhitePawn());
        addPiece("g2", createWhitePawn());
        addPiece("e1", createWhiteRook());
        addPiece("f1", createWhiteKing());

        List<Piece> blackPieces = new ArrayList<>();
        blackPieces.add(createBlackQueen());
        blackPieces.add(createBlackRook());
        blackPieces.add(createBlackBishop());
        blackPieces.add(createBlackPawn());
        blackPieces.add(createBlackPawn());
        blackPieces.add(createBlackPawn());
        blackPieces.add(createBlackKing());

        int sizeOfBlack = blackPieces.size();
        List<Piece> blackTestPieces = game.getSortedBlackPieces(false);
        for (int i = 0; i < sizeOfBlack; i++) {
            assertEquals(blackPieces.get(i), blackTestPieces.get(i));
        }
        blackTestPieces = game.getSortedBlackPieces(true);
        for (int i = 0; i < sizeOfBlack; i++) {
            assertEquals(blackPieces.get(sizeOfBlack - i - 1), blackTestPieces.get(i));
        }

        List<Piece> whitePieces = new ArrayList<>();
        whitePieces.add(createWhiteQueen());
        whitePieces.add(createWhiteRook());
        whitePieces.add(createWhiteKnight());
        whitePieces.add(createWhitePawn());
        whitePieces.add(createWhitePawn());
        whitePieces.add(createWhitePawn());
        whitePieces.add(createWhitePawn());
        whitePieces.add(createWhiteKing());
        int sizeOfWhite = whitePieces.size();
        List<Piece> whiteTestPieces = game.getSortedWhitePieces(false);
        for (int i = 0; i < sizeOfWhite; i++) {
            assertEquals(whitePieces.get(i), whiteTestPieces.get(i));
        }
        whiteTestPieces = game.getSortedWhitePieces(true);
        for (int i = 0; i < sizeOfWhite; i++) {
            assertEquals(whitePieces.get(sizeOfWhite - i - 1), whiteTestPieces.get(i));
        }
    }

}