import action.ActionManager;
import event.CalendarManager;
import user.UserManager;

public class CalendarApp {
    public static void main(String[] args) {
        CalendarManager calendar = new CalendarManager();

        UserManager userManager = new UserManager();

        ActionManager actionManager = new ActionManager(userManager, calendar);

        while (actionManager.isRunning()) {
            actionManager.askChoice();
        }
    }
}