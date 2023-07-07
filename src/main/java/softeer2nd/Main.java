package softeer2nd;

import softeer2nd.chess.Board;
import softeer2nd.chess.ChessGame;
import softeer2nd.chess.ChessView;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        ChessGame game = new ChessGame(board);
        ChessView view = new ChessView(board);

        while (sc.hasNext()) {
            String input = sc.nextLine();
            if ("start".equals(input)) {
                System.out.println("게임을 시작합니다.");
                game.initialize();
                System.out.println(view.showBoard());
            } else if ("end".equals(input)) {
                System.out.println("게임을 종료합니다.");
                break;
            } else if (input.startsWith("move")) {
                String[] s = input.split(" ");
                game.move(s[1], s[2]);
                System.out.println(view.showBoard());
            }
        }
    }
}