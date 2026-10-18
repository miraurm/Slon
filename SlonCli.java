import java.util.Scanner;

public class SlonCli {
    public static void main(String[] args) {
        Slon slon = new Slon();
        Scanner scanner = new Scanner(System.in);

        System.out.println(slon.greeting());


        System.out.println("Купи слона!");

        while (true) {
            System.out.print("> ");
            String line = scanner.nextLine().trim();

            if (slon.isExitCommand(line)) {
                System.out.println("Пока.");
                return;
            }

            if (slon.isEmptyCommand(line)) {
                continue;
            }

            System.out.println(slon.respond(line));
        }
    }
}