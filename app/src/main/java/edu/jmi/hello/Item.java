package edu.jmi.hello;

/**
 * Created by Jet Shang on 2018/11/22.
 */

public class Item {
    private int imgId;
    private String name;

    public Item() {

    }

    public Item(int imgId, String name) {
        this.imgId = imgId;
        this.name = name;
    }

    public int getImgId() {
        return imgId;
    }

    public void setImgId(int imgId) {
        this.imgId = imgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
