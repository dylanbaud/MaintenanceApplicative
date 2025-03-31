package fr.dylan.calendarapp.display;

import fr.dylan.calendarapp.action.Action;
import fr.dylan.calendarapp.action.ActionManager;
import fr.dylan.calendarapp.menu.MenuType;

public class GoBackAction implements Action {

    private final ActionManager actionManager;

    public GoBackAction(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    @Override
    public void execute() {
        actionManager.setMenuType(MenuType.LOGGED_MENU);
    }

    @Override
    public String getName() {
        return "Retour";
    }
}
