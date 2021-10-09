import core.Config;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.spring.CucumberContextConfiguration;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
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
    public static void createRequestSpecification() {
    }

    @BeforeClass
    public static void createResponseSpecification() {

    }

}
