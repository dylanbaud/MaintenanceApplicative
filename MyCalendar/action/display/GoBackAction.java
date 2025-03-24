package action.display;

import action.Action;
import action.ActionManager;
import menu.MenuType;

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
