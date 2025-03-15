package vn.iotstar.ltmob140325.Retrofit2;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CategoryModel implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("category_name")
    private String cateName;
    @SerializedName("category_img")
    private String cateImg;
    @SerializedName("category_desc")
    private String cateDesc;

    public CategoryModel(int id, String cateName, String cateImg, String cateDesc) {
        this.id = id;
        this.cateName = cateName;
        this.cateImg = cateImg;
        this.cateDesc = cateDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateImg() {
        return cateImg;
    }

    public void setCateImg(String cateImg) {
        this.cateImg = cateImg;
    }

    public String getCateDesc() {
        return cateDesc;
    }

    public void setCateDesc(String cateDesc) {
        this.cateDesc = cateDesc;
    }
}
