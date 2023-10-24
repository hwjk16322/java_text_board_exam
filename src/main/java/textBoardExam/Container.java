package textBoardExam;

import lombok.Getter;

import java.util.Scanner;

public class Container {
    @Getter
    private static Scanner sc;

    public static void init() {
        sc = new Scanner(System.in);
    }

    public static void close() {
        sc.close();
    }


}
