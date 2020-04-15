import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
public class RunCucumberTest {

    @BeforeClass
    public static void before() {
        System.out.println("Put here anything yun need before all tests");
    }
}
