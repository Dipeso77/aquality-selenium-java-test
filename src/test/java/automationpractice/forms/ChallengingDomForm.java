package automationpractice.forms;

import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class ChallengingDomForm extends Form {

    private final String locatorCellRow5Column5 = "//tr[5]/td[5]";
    private final String locatorCellRow3Column5 = "//tr[3]/td[5]";
    private final String locatorCellRow7Column5 = "//tr[7]/td[5]";
    private final String locatorCellRow5Column3 = "//tr[5]/td[3]";
    private final String locatorCellRow5Column7 = "//tr[5]/td[7]";

    private ILabel cellInRow3Column5 = getElementFactory().getLabel(By.xpath(locatorCellRow3Column5), "CellInRow3Column5");
    private ILabel cellInRow5Column5 = getElementFactory().getLabel(By.xpath(locatorCellRow5Column5), "CellInRow5Column5");
    private ILabel cellInRow7Column5 = getElementFactory().getLabel(By.xpath(locatorCellRow7Column5), "CellInRow7Column5");
    private ILabel cellInRow5Column7 = getElementFactory().getLabel(By.xpath(locatorCellRow5Column7), "CellInRow5Column7");
    private ILabel cellInRow5Column3 = getElementFactory().getLabel(By.xpath(locatorCellRow5Column3), "CellInRow5Column3");

    public ChallengingDomForm() {
        super(By.xpath("//h3[contains(text(),'Challenging DOM')]"), "Challenging DOM");
    }

    public ILabel getCellInRow3Column5() {
        return cellInRow3Column5;
    }

    public ILabel getCellInRow5Column5() {
        return cellInRow5Column5;
    }

    public ILabel getCellInRow7Column5() {
        return cellInRow7Column5;
    }

    public ILabel getCellInRow5Column7() {
        return cellInRow5Column7;
    }

    public ILabel getCellInRow5Column3() {
        return cellInRow5Column3;
    }

    public String getLocatorCellRow5Column5() {
        return locatorCellRow5Column5;
    }

    public String getLocatorCellRow3Column5() {
        return locatorCellRow3Column5;
    }

    public String getLocatorCellRow7Column5() {
        return locatorCellRow7Column5;
    }

    public String getLocatorCellRow5Column3() {
        return locatorCellRow5Column3;
    }

    public String getLocatorCellRow5Column7() {
        return locatorCellRow5Column7;
    }
}
