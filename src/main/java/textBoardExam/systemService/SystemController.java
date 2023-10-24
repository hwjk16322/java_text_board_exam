package textBoardExam.systemService;

import textBoardExam.Container;
import textBoardExam.entity.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SystemController {
    List<User> userList = new ArrayList<>();
    Scanner sc = Container.getSc();

    public String loginUserId;

    public void sign() {
        if (loginUserId != null) {
            System.out.println("이미 로그인되어있습니다.");
            return;
        }

        String userId;
        String userPw;
        System.out.println("사용하실 아이디를 적어주세요");
        System.out.println("취소하시려면 취소를 입력해주세요");
        while (true) {
            boolean checkID = true;
            System.out.print("입력 ) ");
            userId = sc.nextLine();
            if (userId.equals("취소")) {
                break;
            }

            for (int i = 0; i < userList.size(); i++) {
                if (userList.get(i).getUserId().equals(userId)) {
                    checkID = false;
                    System.out.println("이미 사용중인 아이디입니다. 다시 입력해주세요");
                }
            }

            if (checkID) {
                break;
            }

        }
        if (userId.equals("취소")) {
            return;
        }
        System.out.println("사용하실 비밀번호를 입력해주세요");
        while (true) {
            System.out.print("입력 ) ");
            userPw = sc.nextLine();
            System.out.println("비밀번호 확인");
            System.out.print("입력 ) ");
            String passwordCheck = sc.nextLine();
            if (userPw.equals(passwordCheck)) {
                System.out.println("회원가입이 완료되었습니다.");
                break;
            } else {
                System.out.println("비밀번호가 다릅니다. 다시 입력해주세요.");
            }
        }

        User newUser = new User(userId, userPw);
        userList.add(newUser);
    }

    public void login() {
        if (loginUserId != null) {
            System.out.println("이미 로그인되어있습니다.");
            return;
        }
        boolean loginError = true;
        System.out.println("로그인하실 아이디를 입력해주세요");
        System.out.print("입력 ) ");
        String enteredId = sc.nextLine();

        System.out.println("로그인하실 비밀번호를 입력해주세요");
        System.out.print("입력 ) ");
        String enteredPW = sc.nextLine();

        for (int i = 0; i < userList.size(); i++) {
            if (userList.get(i).getUserId().equals(enteredId) && userList.get(i).getUserPW().equals(enteredPW)) {
                loginUserId = userList.get(i).getUserId();
                loginError = false;
            }
        }
        if (loginError) {
            System.out.println("회원정보가 없습니다. 다시 시도해주세요.");
        }
    }

    public void logout() {
        if (loginUserId == null) {
            System.out.println("로그인 정보가 없습니다. 확인해주세요");
            return;
        }
        loginUserId = null;
        System.out.println("로그아웃이 완료되었습니다.");
    }

    public void plzLogin(String command){
        System.out.println("로그인해야 "+command+"할 수 있습니다.");
    }
}
