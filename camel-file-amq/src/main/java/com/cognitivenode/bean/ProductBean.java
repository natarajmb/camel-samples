package com.cognitivenode.bean;

import java.io.Serializable;

/**
 * Bean to hold product data parsed from CSV file
 *
 * @author nataraj.basappa
 * @version 1.0, 26/11/2012
 */
public class ProductBean implements Serializable {

    String productCode;
    String rangeID;
    String rangeType;
    String rangeVariant;
    String primaryRelationship;
    String shortProductDescription;
    String forecastSellingPrice;
    String markedDownPrice;
    String guidePrice;
    String displayRRP;
    String netMargin;
    String productHierarchyID;
    String brand;
    String image1;
    String image2;
    String image3;
    String image4;
    String primaryCarriage;
    String secondaryCarriage;
    String carrierCode;
    String oversized;
    String ageRestricted;
    String webExclusive;
    String packagedHeight;
    String packagedWidth;
    String packagedDepth;
    String packagedWeight;
    String salesDescription;
    String approvalStatus;
    String productStatus;

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getRangeID() {
        return rangeID;
    }

    public void setRangeID(String rangeID) {
        this.rangeID = rangeID;
    }

    public String getRangeType() {
        return rangeType;
    }

    public void setRangeType(String rangeType) {
        this.rangeType = rangeType;
    }

    public String getRangeVariant() {
        return rangeVariant;
    }

    public void setRangeVariant(String rangeVariant) {
        this.rangeVariant = rangeVariant;
    }

    public String getPrimaryRelationship() {
        return primaryRelationship;
    }

    public void setPrimaryRelationship(String primaryRelationship) {
        this.primaryRelationship = primaryRelationship;
    }

    public String getShortProductDescription() {
        return shortProductDescription;
    }

    public void setShortProductDescription(String shortProductDescription) {
        this.shortProductDescription = shortProductDescription;
    }

    public String getForecastSellingPrice() {
        return forecastSellingPrice;
    }

    public void setForecastSellingPrice(String forecastSellingPrice) {
        this.forecastSellingPrice = forecastSellingPrice;
    }

    public String getMarkedDownPrice() {
        return markedDownPrice;
    }

    public void setMarkedDownPrice(String markedDownPrice) {
        this.markedDownPrice = markedDownPrice;
    }

    public String getGuidePrice() {
        return guidePrice;
    }

    public void setGuidePrice(String guidePrice) {
        this.guidePrice = guidePrice;
    }

    public String getDisplayRRP() {
        return displayRRP;
    }

    public void setDisplayRRP(String displayRRP) {
        this.displayRRP = displayRRP;
    }

    public String getNetMargin() {
        return netMargin;
    }

    public void setNetMargin(String netMargin) {
        this.netMargin = netMargin;
    }

    public String getProductHierarchyID() {
        return productHierarchyID;
    }

    public void setProductHierarchyID(String productHierarchyID) {
        this.productHierarchyID = productHierarchyID;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getImage4() {
        return image4;
    }

    public void setImage4(String image4) {
        this.image4 = image4;
    }

    public String getPrimaryCarriage() {
        return primaryCarriage;
    }

    public void setPrimaryCarriage(String primaryCarriage) {
        this.primaryCarriage = primaryCarriage;
    }

    public String getSecondaryCarriage() {
        return secondaryCarriage;
    }

    public void setSecondaryCarriage(String secondaryCarriage) {
        this.secondaryCarriage = secondaryCarriage;
    }

    public String getCarrierCode() {
        return carrierCode;
    }

    public void setCarrierCode(String carrierCode) {
        this.carrierCode = carrierCode;
    }

    public String getOversized() {
        return oversized;
    }

    public void setOversized(String oversized) {
        this.oversized = oversized;
    }

    public String getAgeRestricted() {
        return ageRestricted;
    }

    public void setAgeRestricted(String ageRestricted) {
        this.ageRestricted = ageRestricted;
    }

    public String getWebExclusive() {
        return webExclusive;
    }

    public void setWebExclusive(String webExclusive) {
        this.webExclusive = webExclusive;
    }

    public String getPackagedHeight() {
        return packagedHeight;
    }

    public void setPackagedHeight(String packagedHeight) {
        this.packagedHeight = packagedHeight;
    }

    public String getPackagedWidth() {
        return packagedWidth;
    }

    public void setPackagedWidth(String packagedWidth) {
        this.packagedWidth = packagedWidth;
    }

    public String getPackagedDepth() {
        return packagedDepth;
    }

    public void setPackagedDepth(String packagedDepth) {
        this.packagedDepth = packagedDepth;
    }

    public String getPackagedWeight() {
        return packagedWeight;
    }

    public void setPackagedWeight(String packagedWeight) {
        this.packagedWeight = packagedWeight;
    }

    public String getSalesDescription() {
        return salesDescription;
    }

    public void setSalesDescription(String salesDescription) {
        this.salesDescription = salesDescription;
    }

    public String getApprovalStatus() {
        return approvalStatus;
    }

    public void setApprovalStatus(String approvalStatus) {
        this.approvalStatus = approvalStatus;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Product Code :  : ").append(productCode + "\n");
        builder.append("Range ID : ").append(rangeID + "\n");
        builder.append("Range Type : ").append(rangeType + "\n");
        builder.append("Range Variant : ").append(rangeVariant + "\n");
        builder.append("Primary Relationship : ").append(primaryRelationship + "\n");
        builder.append("Short Product Description : ").append(shortProductDescription + "\n");
        builder.append("Forecast Selling Price : ").append(forecastSellingPrice + "\n");
        builder.append("Marked Down Price : ").append(markedDownPrice + "\n");
        builder.append("Guide Price : ").append(guidePrice + "\n");
        builder.append("Display RRP : ").append(displayRRP + "\n");
        builder.append("Net Margin : ").append(netMargin + "\n");
        builder.append("Product Hierarchy ID : ").append(productHierarchyID + "\n");
        builder.append("Brand : ").append(brand + "\n");
        builder.append("Image 1 : ").append(image1 + "\n");
        builder.append("Image 2 : ").append(image2 + "\n");
        builder.append("Image 3 : ").append(image3 + "\n");
        builder.append("Image 4 : ").append(image4 + "\n");
        builder.append("Primary Carriage : ").append(primaryCarriage + "\n");
        builder.append("Secondary Carriage : ").append(secondaryCarriage + "\n");
        builder.append("Carrier Code : ").append(carrierCode + "\n");
        builder.append("Oversized : ").append(oversized + "\n");
        builder.append("Age Restricted : ").append(ageRestricted + "\n");
        builder.append("Web Exclusive : ").append(webExclusive + "\n");
        builder.append("Packaged Height (mm) : ").append(packagedHeight + "\n");
        builder.append("Packaged Width (mm) : ").append(packagedWidth + "\n");
        builder.append("Packaged Depth (mm) : ").append(packagedDepth + "\n");
        builder.append("Packaged Weight (kg) : ").append(packagedWeight + "\n");
        builder.append("Sales Description : ").append(salesDescription + "\n");
        builder.append("Approval Status : ").append(approvalStatus + "\n");
        builder.append("Product Status : ").append(productStatus + "\n");
        return builder.toString();
    }
}
