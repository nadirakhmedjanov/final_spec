package view.console_ui.buttons;

import view.console_ui.ConsoleUI;

public class SortAnimalsByBirtDate extends Button {
    public SortAnimalsByBirtDate(ConsoleUI consoleUI) {
        super("Sort all animals by birth date.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().getAnimalsSortedByBirthdate();
    }
}
