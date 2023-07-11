package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.Scanner;

import static softeer2nd.utils.StringUtils.NEWLINE;

public class TerminalView implements Observer {
    Board board;
    Game game;

    public TerminalView(Board board, Game game) {
        this.board = board;
        this.game = game;
    }

    public void init() {
        board.addObserver(this);
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String input = sc.nextLine();
            if ("start".equals(input)) {
                System.out.println("게임을 시작합니다.");
                game.initialize();
            } else if ("end".equals(input)) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if (input.startsWith("move")) {
                String[] s = input.split(" ");
                game.move(s[1], s[2]);
            }
        }
    }

    @Override
    public void update() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        for (Rank rank : board.getRanks()) {
            sb.append(rank.getRepresentation()).append(NEWLINE);
        }
        return sb.toString();
    }
}
