package action.display;

import event.CalendarManager;

public class DisplayAll extends DisplayAction {
    private final CalendarManager calendar;

    public DisplayAll(CalendarManager calendar) {
        this.calendar = calendar;
    }

    @Override
    public void execute() {
        calendar.displayEvents();
    }

    @Override
    public String getName() {
        return "Afficher TOUT les événements";
    }
}
