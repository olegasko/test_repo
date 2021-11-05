package pages;

import com.codeborne.selenide.SelenideElement;


import java.util.List;
import java.util.stream.Collectors;

import static com.codeborne.selenide.Selenide.$$x;

public class HowWeDoItPage extends CommonPage {
    public  List<String> listOfSections(){
        List<String> section = $$x("//section//h2").stream().map(SelenideElement::getText).collect(Collectors.toList());
        return section;
    }

    public List<String> listOfBlocks(){
        List<String> listOfBlocksActualList = $$x("//section//h3").stream().map(SelenideElement::getText).collect(Collectors.toList());
        return listOfBlocksActualList;
    }
}
