package com.zencloud.wordchen.rxredemo.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import java.io.Serializable;
@Entity(tableName = "mike")
public class Mike implements Serializable{
    @PrimaryKey(autoGenerate=true)
    private int ID;
    private String FullName;
    private String ShortName;
    private String Code;
    private String BarCode;
    private String BoxBarCode;
    private int Brand;
    private String BrandName;
    private int Classify;
    private String ClassifyName;
    private int Category;
    private String CategoryName;
    private int Grade;
    private String GradeName;
    private int TrafficPackaging;
    private String TrafficPackagingName;
    private int Packaging;
    private String PackagingName;
    private int ConvertFactor;
    private int Weight;
    private int Volume;
    private String TDPCode;
    private int SalesState;
    private int BuyPrice;
    private int SalesPrice;
    private int MaxSalesPrice;
    private int MinSalesPrice;
    private String FactoryName;
    private String FactoryCode;
    private String Spec;
    private String Remark;
    private int OwnerType;
    private String ImageGUID;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getShortName() {
        return ShortName;
    }

    public void setShortName(String shortName) {
        ShortName = shortName;
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String code) {
        Code = code;
    }

    public String getBarCode() {
        return BarCode;
    }

    public void setBarCode(String barCode) {
        BarCode = barCode;
    }

    public String getBoxBarCode() {
        return BoxBarCode;
    }

    public void setBoxBarCode(String boxBarCode) {
        BoxBarCode = boxBarCode;
    }

    public int getBrand() {
        return Brand;
    }

    public void setBrand(int brand) {
        Brand = brand;
    }

    public String getBrandName() {
        return BrandName;
    }

    public void setBrandName(String brandName) {
        BrandName = brandName;
    }

    public int getClassify() {
        return Classify;
    }

    public void setClassify(int classify) {
        Classify = classify;
    }

    public String getClassifyName() {
        return ClassifyName;
    }

    public void setClassifyName(String classifyName) {
        ClassifyName = classifyName;
    }

    public int getCategory() {
        return Category;
    }

    public void setCategory(int category) {
        Category = category;
    }

    public String getCategoryName() {
        return CategoryName;
    }

    public void setCategoryName(String categoryName) {
        CategoryName = categoryName;
    }

    public int getGrade() {
        return Grade;
    }

    public void setGrade(int grade) {
        Grade = grade;
    }

    public String getGradeName() {
        return GradeName;
    }

    public void setGradeName(String gradeName) {
        GradeName = gradeName;
    }

    public int getTrafficPackaging() {
        return TrafficPackaging;
    }

    public void setTrafficPackaging(int trafficPackaging) {
        TrafficPackaging = trafficPackaging;
    }

    public String getTrafficPackagingName() {
        return TrafficPackagingName;
    }

    public void setTrafficPackagingName(String trafficPackagingName) {
        TrafficPackagingName = trafficPackagingName;
    }

    public int getPackaging() {
        return Packaging;
    }

    public void setPackaging(int packaging) {
        Packaging = packaging;
    }

    public String getPackagingName() {
        return PackagingName;
    }

    public void setPackagingName(String packagingName) {
        PackagingName = packagingName;
    }

    public int getConvertFactor() {
        return ConvertFactor;
    }

    public void setConvertFactor(int convertFactor) {
        ConvertFactor = convertFactor;
    }

    public int getWeight() {
        return Weight;
    }

    public void setWeight(int weight) {
        Weight = weight;
    }

    public int getVolume() {
        return Volume;
    }

    public void setVolume(int volume) {
        Volume = volume;
    }

    public String getTDPCode() {
        return TDPCode;
    }

    public void setTDPCode(String TDPCode) {
        this.TDPCode = TDPCode;
    }

    public int getSalesState() {
        return SalesState;
    }

    public void setSalesState(int salesState) {
        SalesState = salesState;
    }

    public int getBuyPrice() {
        return BuyPrice;
    }

    public void setBuyPrice(int buyPrice) {
        BuyPrice = buyPrice;
    }

    public int getSalesPrice() {
        return SalesPrice;
    }

    public void setSalesPrice(int salesPrice) {
        SalesPrice = salesPrice;
    }

    public int getMaxSalesPrice() {
        return MaxSalesPrice;
    }

    public void setMaxSalesPrice(int maxSalesPrice) {
        MaxSalesPrice = maxSalesPrice;
    }

    public int getMinSalesPrice() {
        return MinSalesPrice;
    }

    public void setMinSalesPrice(int minSalesPrice) {
        MinSalesPrice = minSalesPrice;
    }

    public String getFactoryName() {
        return FactoryName;
    }

    public void setFactoryName(String factoryName) {
        FactoryName = factoryName;
    }

    public String getFactoryCode() {
        return FactoryCode;
    }

    public void setFactoryCode(String factoryCode) {
        FactoryCode = factoryCode;
    }

    public String getSpec() {
        return Spec;
    }

    public void setSpec(String spec) {
        Spec = spec;
    }

    public String getRemark() {
        return Remark;
    }

    public void setRemark(String remark) {
        Remark = remark;
    }

    public int getOwnerType() {
        return OwnerType;
    }

    public void setOwnerType(int ownerType) {
        OwnerType = ownerType;
    }

    public String getImageGUID() {
        return ImageGUID;
    }

    public void setImageGUID(String imageGUID) {
        ImageGUID = imageGUID;
    }
}
