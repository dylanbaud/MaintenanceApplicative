package menu;

import action.Action;

import java.util.List;

public abstract class MenuAction {

    private final List<Action> actions;

    public MenuAction(List<Action> actions) {
        this.actions = actions;
    }

    public void executeAction(int choice) {
        actions.get(choice).execute();
    }

    public abstract String getIntro();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getIntro());
        for (int i = 1; i < actions.size() + 1; i++) {
            sb.append(i).append(" - ").append(actions.get(i - 1).getName()).append("\n");
        }

        return sb.toString();
    }
}
