package softeer2nd;

import softeer2nd.chess.Board;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Board board = new Board();

        while (sc.hasNext()) {
            String input = sc.nextLine();
            if ("start".equals(input)) {
                System.out.println("게임을 시작합니다.");
                board.initialize();
                System.out.println(board.print());
            }
            if ("end".equals(input)) {
                System.out.println("게임을 종료합니다.");
                break;
            }
        }
    }
}