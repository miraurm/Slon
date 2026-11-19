package ru.oop.slon;

public class Slon {

    private static final String CMD_HELP = "\\help";
    private static final String CMD_EXIT = "\\break";

    private static final String HELP_TEXT =
            "Я хочу уговорить тебя купить слона.";

    public String greeting() {
        return String.format(
                "Привет!%nЯ хочу купить слона.%nДля справки используй %s%n",
                CMD_HELP
        );
    }

    public boolean isExitCommand(String line) {
        return line.equals(CMD_EXIT);
    }

    public boolean isHelpCommand(String line) {
        return line.equals(CMD_HELP);
    }

    public boolean isEmptyCommand(String line) {
        return line.isEmpty();
    }

    public String respond(String line) {
        if (isHelpCommand(line)) {
            return HELP_TEXT;
        }

        return String.format("Все говорят \"%s\", а ты купи слона!", line);
    }
}