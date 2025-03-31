package fr.dylan.calendarapp.logged;

import fr.dylan.calendarapp.action.Action;
import fr.dylan.calendarapp.action.ActionManager;
import fr.dylan.calendarapp.menu.MenuType;

public class DisplayEvents implements Action {

    private final ActionManager actionManager;

    public DisplayEvents(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    @Override
    public void execute() {
        actionManager.setMenuType(MenuType.DISPLAY_MENU);
    }

    @Override
    public String getName() {
        return "Voir les événements";
    }
}
