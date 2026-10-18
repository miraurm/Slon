public class Slon {

    // ─── Константы команд ───
    private static final String CMD_HELP = "\\help";
    private static final String CMD_EXIT = "\\break";

    // ─── Тексты ───
    private static final String QUESTION = "Купи слона!";
    private static final String REPEAT_QUESTION = "А ты купи слона!";
    private static final String HELP_TEXT =
            "Я хочу уговорить тебя купить слона.";

    // Шаблоны ответов. %s — подстановка реплики пользователя.
    private static final String[] REPLIES = {
            "Ну купи слона!",
            "Все говорят \"%s\", а ты купи слона!",
            "Ну а если подумать — купи слона!",
            "Ты не понимаешь, слон — это выгодное вложение! Купи слона!",
            "Ну пожалуйста, купи слона!"
    };

    private int step = 0;   // счётчик шагов (какой шаблон использовать)

    // ─── Приветствие ───
    public String greeting() {
        return String.format(
                "Привет!%nЯ хочу купить слона.%nДля справки используй %s%n",
                CMD_HELP
        );
    }

    // ─── Проверки команд ───
    public boolean isExitCommand(String line) {
        return line.equals(CMD_EXIT);
    }

    public boolean isHelpCommand(String line) {
        return line.equals(CMD_HELP);
    }

    // ─── Пустая строка ───
    public boolean isEmptyCommand(String line) {
        return line.isEmpty();
    }

    // ─── Ответ на реплику ───
    public String respond(String line) {
        if (isHelpCommand(line)) {
            return HELP_TEXT;
        }

        String template = REPLIES[step % REPLIES.length];
        step++;

        if (template.contains("%s")) {
            return String.format(template, line);
        }
        return template;
    }
}