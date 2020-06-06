package jn.example.trashtogo;

public class Trash {
    private String name;
    private String imageName;
    private String image;
    private String price;
    private String type;

    public Trash(String name, String imageName, String image, String price, String type) {
        this.name = name;
        this.imageName = imageName;
        this.image = image;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
