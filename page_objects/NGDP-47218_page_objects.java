*****************

//Page Object Code (Java - Example)

public class CartPage {

    //WebElements or other locators here using Selenium (example)
    private WebDriver driver;

    public CartPage(){
        //Initialize driver
    }

    public void navigateToCart(){
        //Implement navigation logic
    }

    public boolean areOtherMembersItemsVisible(){
        //Implement logic to verify items are visible.  Return true/false
        return true;
    }


    public void removeItem(String itemName){
        //Implement logic to remove item
    }

    public boolean isNoItemsMessageDisplayed(){
        //Implement logic to check for "No Items" message. Return true/false
        return true;
    }

    public boolean isNoItemsMessageCorrectlyStyled(){
        //Implement logic to compare with figma design. Return true/false
        return true;
    }


}

//Other page objects for other screens would go here