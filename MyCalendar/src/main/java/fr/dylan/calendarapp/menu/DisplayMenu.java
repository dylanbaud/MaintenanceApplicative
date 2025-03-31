package fr.dylan.calendarapp.menu;

import fr.dylan.calendarapp.action.Action;
import fr.dylan.calendarapp.action.ActionManager;

import java.util.List;

public class DisplayMenu extends MenuAction {
    private final ActionManager actionManager;

    public DisplayMenu(List<Action> actions, ActionManager actionManager) {
        super(actions);
        this.actionManager = actionManager;
    }

    @Override
    public String getIntro() {
        return "\n=== Menu de visualisation d'Événements ===\n";
    }

    @Override
    public void executeAction(int choiceId) {
        super.executeAction(choiceId);
        actionManager.setMenuType(MenuType.LOGGED_MENU);
    }
}
