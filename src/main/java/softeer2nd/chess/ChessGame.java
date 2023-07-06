package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import static softeer2nd.chess.pieces.Piece.*;

public class ChessGame {
    private final Board board;

    public ChessGame(Board board) {
        this.board = board;
    }

    public Board getBoard() {
        return board;
    }

    public void initialize() {
        for (int i = 0; i < 8; i++) {
            board.getRanks().add(new Rank());
            for (int j = 0; j < 8; j++) {
                if (i == 1) {
                    board.getRanks().get(i).getPieces().add(createBlackPawn());
                } else if (i == 6) {
                    board.getRanks().get(i).getPieces().add(createWhitePawn());
                } else if (i == 0) {
                    if (j == 0 || j == 7) {
                        board.getRanks().get(i).getPieces().add(createBlackRook());
                    } else if (j == 1 || j == 6) {
                        board.getRanks().get(i).getPieces().add(createBlackKnight());
                    } else if (j == 2 || j == 5) {
                        board.getRanks().get(i).getPieces().add(createBlackBishop());
                    } else if (j == 3) {
                        board.getRanks().get(i).getPieces().add(createBlackQueen());
                    } else {
                        board.getRanks().get(i).getPieces().add(createBlackKing());
                    }
                } else if (i == 7) {
                    if (j == 0 || j == 7) {
                        board.getRanks().get(i).getPieces().add(createWhiteRook());
                    } else if (j == 1 || j == 6) {
                        board.getRanks().get(i).getPieces().add(createWhiteKnight());
                    } else if (j == 2 || j == 5) {
                        board.getRanks().get(i).getPieces().add(createWhiteBishop());
                    } else if (j == 3) {
                        board.getRanks().get(i).getPieces().add(createWhiteQueen());
                    } else {
                        board.getRanks().get(i).getPieces().add(createWhiteKing());
                    }
                } else {
                    board.getRanks().get(i).getPieces().add(createBlank());
                }
            }
        }
    }

    public void initializeEmpty() {
        for (int i = 0; i < 8; i++) {
            board.getRanks().add(new Rank());
            for (int j = 0; j < 8; j++) {
                board.getRanks().get(i).getPieces().add(createBlank());
            }
        }
    }


    public int pieceCount() {
        return 64 - pieceCount(Color.NOCOLOR, Type.NO_PIECE);
    }

    public int pieceCount(Color color, Type type) {
        int count = 0;
        for (Rank rank : board.getRanks()) {
            for (Piece piece : rank.getPieces()) {
                if (piece.getColor() == color && piece.getType() == type) {
                    ++count;
                }
            }
        }
        return count;
    }

    public Piece findPiece(String position) {
        Position pos = new Position(position);
        return board.getRanks().get(pos.x).getPieces().get(pos.y);
    }

    public void move(String position, Piece piece) {
        Position pos = new Position(position);
        board.getRanks().get(pos.x).getPieces().set(pos.y, piece);
        if (piece.getColor() == Color.BLACK) {
            board.getBlackPieces().add(piece);
        } else {
            board.getWhitePieces().add(piece);
        }
    }

    public void move(String sourcePosition, String targetPosition) {
        move(targetPosition, findPiece(sourcePosition));
    }

    public double calculatePoint(Color color) {
        double score = 0;
        for (Rank rank : board.getRanks()) {
            for (Piece piece : rank.getPieces()) {
                if (piece.getColor() == color) {
                    score += piece.getType().getDefaultPoint();
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            int pawnCount = 0;
            for (int j = 0; j < 8; j++) {
                Piece piece = board.getRanks().get(j).getPieces().get(i);
                if (piece.getColor() == color && piece.getType() == Type.PAWN) {
                    ++pawnCount;
                }
            }
            if (pawnCount > 1) {
                score -= 0.5 * pawnCount;
            }

        }
        return score;
    }
}
