package trivia;

import java.util.HashMap;
import java.util.LinkedList;

public class QuestionManager {
    HashMap<Category, LinkedList<String>> questions = new HashMap<>();

    public QuestionManager() {
        for (Category category : Category.values()) {
            LinkedList<String> questionList = new LinkedList<>();
            for (int i = 0; i < 50; i++) {
                questionList.addLast(category + " Question " + i);
            }
            questions.put(category, questionList);
        }
    }

    public void askQuestion(int place) {
        Category category = currentCategory(place);
        System.out.println("The category is " + category);
        System.out.println(questions.get(category).removeFirst());
    }

    private Category currentCategory(int place) {
        return Category.values()[(place - 1) % questions.size()];
    }
}
