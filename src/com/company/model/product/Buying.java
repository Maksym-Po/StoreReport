package com.company.model.product;

public class Buying {

    public Product getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    private Product product;
    private int count;

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Buying(Product product, int count) {
        this.product = product;
        this.count = count;
    }

}
