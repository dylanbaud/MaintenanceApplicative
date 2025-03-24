package action.logged;

import action.Action;
import action.ActionManager;
import menu.MenuType;

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
