package textBoardExam;

import textBoardExam.appService.AppController;
import textBoardExam.systemService.SystemController;

public class App {
    public void run() {
        AppController appController = new AppController();
        SystemController systemController = new SystemController();
        System.out.println("==게시판 앱==");
        boolean isLogin = true;
        while (true) {
            String loginUserId = systemController.loginUserId;
            if (loginUserId == null) {
                isLogin = true;
            }
            if (loginUserId != null && isLogin) {
                System.out.println("\n" + loginUserId + "님 안녕하세요!");
                isLogin = false;
            }

            System.out.println("\n명령어 ) 동록, 목록, 수정, 삭제, 회원가입, 로그인, 로그아웃, 종료");
            System.out.print("입력 ) ");
            String command = Container.getSc().nextLine();
            switch (command) {

                case "종료":
                    System.out.println("앱을 종료합니다..");
                    return;


                case "등록":
                    if (loginUserId == null) {
                        systemController.plzLogin(command);
                        break;
                    }
                    appController.write(loginUserId);
                    break;


                case "목록":
                    appController.list();
                    break;


                case "수정":
                    if (loginUserId == null) {
                        systemController.plzLogin(command);
                        break;
                    }
                    appController.modify(loginUserId);
                    break;


                case "삭제":
                    if (loginUserId == null) {
                        systemController.plzLogin(command);
                        break;
                    }
                    appController.delete(loginUserId);
                    break;


                case "회원가입":
                    systemController.sign();
                    break;


                case "로그인":
                    systemController.login();
                    break;


                case "로그아웃":
                    systemController.logout();
                    break;


            }
        }
    }
}