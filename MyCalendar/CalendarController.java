public class CalendarController {
    private final HomeManager homeManager;
    private final MainMenuManager mainMenuManager;

    public CalendarController() {
        CalendarManager calendar = new CalendarManager();
        UserManager userManager = new UserManager();
        this.homeManager = new HomeManager(userManager);
        this.mainMenuManager = new MainMenuManager(calendar, homeManager);
    }

    public void start() {
        while (true) {
            if (!homeManager.isUserConnected()) {
                homeManager.handleHomeMenu();
            } else {
                mainMenuManager.handleMainMenu();
            }
        }
    }
}