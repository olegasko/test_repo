package pages;

import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;
import static com.codeborne.selenide.Selenide.$x;

public class HowWeDoItPage extends CommonPage{
    private String CurrentBlocksName;
    public  boolean IsBlocksExist(String blocksName){
        SelenideElement section = $x("//section[contains(string(),'"+ blocksName +"')]");
        CurrentBlocksName = blocksName;
        return section.exists();
    }

    public boolean isListOfBlocksHasCorrectOder(List<String> blocksList){
        List<String> listOfBlocksActualList = $$x("//section[contains(string(),'"+ CurrentBlocksName +"')]//h3").stream().map(SelenideElement::getText).collect(Collectors.toList());
        return blocksList.equals(listOfBlocksActualList);
    }

}
