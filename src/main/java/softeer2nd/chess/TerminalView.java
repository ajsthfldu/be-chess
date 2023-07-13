package softeer2nd.chess;

import softeer2nd.chess.pieces.Piece;

import java.util.Scanner;

import static softeer2nd.utils.StringUtils.NEWLINE;

public class TerminalView {
    Game game;

    public void init() {
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
            } else {
                System.out.println("알 수 없는 명령입니다.");
            }
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public void update() {
        System.out.println(showBoard());
    }

    public String showBoard() {
        StringBuilder sb = new StringBuilder();
        int rankNum = 1;
        for (String line : game.getBoardRepresentation().split(NEWLINE)) {
            sb.append(line).append("  ").append(rankNum).append(NEWLINE);
            rankNum++;
        }
        sb.append(NEWLINE).append("abcdefgh");
        return sb.toString();
    }

    public void print(String message) {
        System.out.println(message);
    }
}
