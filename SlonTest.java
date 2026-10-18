import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SlonTest {

    @Test
    void teasesBackWithUsersOwnLine() {
        Slon slon = new Slon();
        String response = slon.respond("Привет");
        assertTrue(response.contains("Привет"));
        assertTrue(response.contains("купи слона"));
    }

    @Test
    void helpCommandReturnsHelpText() {
        Slon slon = new Slon();
        String response = slon.respond("\\help");
        assertTrue(response.contains("уговорить"));
    }

    @Test
    void exitCommandIsRecognized() {
        Slon slon = new Slon();
        assertTrue(slon.isExitCommand("\\break"));
        assertFalse(slon.isExitCommand("Привет"));
    }

    @Test
    void helpCommandIsRecognized() {
        Slon slon = new Slon();
        assertTrue(slon.isHelpCommand("\\help"));
        assertFalse(slon.isHelpCommand("\\break"));
    }

    @Test
    void emptyLineIsEmptyCommand() {
        Slon slon = new Slon();
        assertTrue(slon.isEmptyCommand(""));
        assertFalse(slon.isEmptyCommand("Привет"));
    }

    @Test
    void greetingContainsHelpHint() {
        Slon slon = new Slon();
        assertTrue(slon.greeting().contains("\\help"));
    }
}