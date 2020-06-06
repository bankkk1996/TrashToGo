package jn.example.trashtogo;

public class Factory {
    private String name;
    private String address;
    private String image;
    private String imageName;

    public Factory(String address,String image , String imageName, String name) {
        this.name = name;
        this.address = address;
        this.image = image;
        this.imageName = imageName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
}
