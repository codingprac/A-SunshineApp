package entities;

/**
 * Created by deep on 6/19/16.
 */
public class ListItems {

    private String image;
    private String firstTitle;
    private String secondTitle;

    public ListItems(String image, String firstTitle, String secondTitle) {
        this.image = image;
        this.firstTitle = firstTitle;
        this.secondTitle = secondTitle;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFirstTitle() {
        return firstTitle;
    }

    public void setFirstTitle(String firstTitle) {
        this.firstTitle = firstTitle;
    }

    public String getSecondTitle() {
        return secondTitle;
    }

    public void setSecondTitle(String secondTitle) {
        this.secondTitle = secondTitle;
    }

    @Override
    public String toString() {
        return "Name='" + firstTitle + '\'' +
                ", Designation='" + secondTitle + '\'';
    }
}
