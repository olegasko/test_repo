import core.Config;
import gherkin.ast.ScenarioOutline;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"},
        features = "src/test/resources",
        snippets = CucumberOptions.SnippetType.CAMELCASE)
@CucumberContextConfiguration
@ContextConfiguration(classes = Config.class)
public class RunCucumberTest {

    @BeforeClass
    public static void before() {
        System.setProperty("webdriver.chrome.driver", "src/test/java/drivers/chromedriver.exe");
    }
}
