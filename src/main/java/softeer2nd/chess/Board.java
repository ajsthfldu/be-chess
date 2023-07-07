package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;
import softeer2nd.chess.Rank;


import java.util.ArrayList;
import java.util.List;

import static softeer2nd.utils.StringUtils.NEWLINE;

public class Board {

    private final List<Rank> ranks = new ArrayList<>();
    private final List<Piece> whitePieces = new ArrayList<>();
    private final List<Piece> blackPieces = new ArrayList<>();

    public List<Rank> getRanks() {
        return ranks;
    }

    public List<Piece> getWhitePieces() {
        return whitePieces;
    }

    public List<Piece> getBlackPieces() {
        return blackPieces;
    }

    public void initBoard() {
        for (int i = 0; i < 8; i++) {
            ranks.add(new Rank());
        }
    }

    public void initBoard(String boardString) {
        for (String rankString : boardString.split(NEWLINE)) {
            ranks.add(new Rank(rankString));
        }
    }

    public void clear() {
        ranks.clear();
        whitePieces.clear();
        blackPieces.clear();
    }

    public void move(Position position, Piece piece) {
        ranks.get(position.getYDegree()).updatePiece(position.getXDegree(), piece);
        if (piece.getColor() == Piece.Color.BLACK) {
            blackPieces.add(piece);
        } else {
            whitePieces.add(piece);
        }
    }
}

