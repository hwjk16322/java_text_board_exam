package textBoardExam.appService;

import textBoardExam.Container;
import textBoardExam.entity.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppController {
    List<Post> postList = new ArrayList<>();
    Scanner sc = Container.getSc();
    int postId = 0;

    public void write(String loginUserId) {
        postId++;
        System.out.println("제목을 입력해주세요");
        System.out.printf("입력 ) ");
        String title = sc.nextLine();
        System.out.println("내용을 입력해주세요");
        System.out.printf("입력 ) ");
        String content = sc.nextLine();
        Post newPost = new Post(postId, title, content, loginUserId);
        postList.add(newPost);

        System.out.println("제목 : " + title + "\n내용 : " + content + "\n등록이 완료되었습니다.");

    }

    public void list() {
        System.out.println("게시물 번호 / 제목 / 내용 / 글쓴이");
        for (int i = 0; i < postList.size(); i++) {
            Post post = postList.get(i);
            System.out.printf("%d / %s / %s / %s \n", post.getPostId(), post.getTitle(), post.getContent(), post.getLoginUserId());
        }

    }

    public void modify(String loginUserId) {
        System.out.println(loginUserId + " 님이 작성하신 글 목록입니다.");
        System.out.println("게시물 번호 / 제목 / 내용");
        for (int i = 0; i < postList.size(); i++) {
            Post post = postList.get(i);
            if (post.getLoginUserId().equals(loginUserId)) {
                System.out.printf("%d / %s / %s \n", post.getPostId(), post.getTitle(), post.getContent());
            }
        }
        System.out.println("수정하실 게시물의 번호를 입력해주세요");
        System.out.printf("입력 ) ");
        int postNumber = Integer.parseInt(sc.nextLine());
        Post post = postList.get(postNumber);

        try {
            if (post.getLoginUserId().equals(loginUserId)) {
                System.out.println("수정하실 제목을 입력해주세요");
                System.out.printf("입력 ) ");
                String modifiedTitle = sc.nextLine();
                System.out.println("수정하실 내용을 입력해주세요");
                System.out.printf("입력 ) ");
                String modifiedContent = sc.nextLine();

                postList.get(postNumber - 1).setTitle(modifiedTitle);
                postList.get(postNumber - 1).setContent(modifiedContent);
                System.out.println("수정이 완료되었습니다.");

            } else {
                System.out.println("작성하신 글만 수정할수 있습니다.");
            }
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도해주세요");
        }
    }

    public void delete(String loginUserId) {
        System.out.println(loginUserId + " 님이 작성하신 글 목록입니다.");
        System.out.println("게시물 번호 / 제목 / 내용");
        for (int i = 0; i < postList.size(); i++) {
            Post post = postList.get(i);
            if (post.getLoginUserId().equals(loginUserId)) {
                System.out.printf("%d / %s / %s \n", post.getPostId(), post.getTitle(), post.getContent());
            }
        }
        System.out.println("삭제하실 게시물의 번호를 입력해주세요");
        System.out.printf("입력 ) ");
        int postNumber = Integer.parseInt(sc.nextLine());

        try {
            Post post = postList.get(postNumber);
            if (post.getLoginUserId().equals(loginUserId)) {
                postList.remove(postNumber - 1);
                System.out.println("삭제가 완료되었습니다.");

            } else {
                System.out.println("작성하신 글만 삭제할수 있습니다.");
            }
        } catch (Exception e) {
            System.out.println("오류가 발생했습니다. 다시 시도해주세요");
        }
    }
}



