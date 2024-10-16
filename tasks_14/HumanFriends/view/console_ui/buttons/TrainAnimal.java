package view.console_ui.buttons;

import view.console_ui.ConsoleUI;

public class TrainAnimal extends Button {
    public TrainAnimal(ConsoleUI consoleUI) {
        super("Learn new command.", consoleUI);
    }

    @Override
    public void execute() {
        getConsoleUI().trainAnimal();
    }
}
