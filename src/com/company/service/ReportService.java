package com.company.service;

import com.company.dto.BuyingDto;
import com.company.dto.ReportDto;
import com.company.dto.StoreDto;
import com.company.model.Store;
import com.company.model.product.Buying;
import com.company.model.product.Product;

import java.util.Arrays;

public class ReportService {

    public static final String SUMMARY_REPORT = "Summary report";

    public Store[] getStores() {
        return stores;
    }

    public void setStores(Store[] stores) {
        this.stores = stores;
    }

    private Store[] stores;

    public ReportService(Store[] stores) {
        this.stores = stores;
    }

    public ReportDto build() {
        StoreDto[] storeDtos = mapStores();
        BuyingDto[] buyingDtos = mergeBuyings(storeDtos);
        double totalSum = 0;
        for (BuyingDto buyingDto : buyingDtos) {
            totalSum += buyingDto.getSum();
        }
        return new ReportDto(SUMMARY_REPORT, buyingDtos, totalSum);
    }

    private BuyingDto[] mergeBuyings(StoreDto[] storeDtos) {
        int count = getCount(storeDtos);
        BuyingDto[] totalArr = new BuyingDto[count];
        int i = 0;
        for (StoreDto storeDto : storeDtos) {
            for (BuyingDto sell : storeDto.getSells()) {
                totalArr[i++] = sell;
            }

        }
        return totalArr;
    }

    private int getCount(StoreDto[] storeDtos) {
        int count = 0;
        for (StoreDto storeDto : storeDtos) {
            count += storeDto.getSells().length;
        }
        return count;
    }

    private StoreDto[] mapStores() {
        StoreDto[] array = new StoreDto[stores.length];

        for (int i = 0; i < array.length; i++) {
            Store store = stores[i];
            String name = store.getName();
            BuyingDto[] buyingDtos = new BuyingDto[store.getSales().length];
            for (int j = 0; j < store.getSales().length; j++) {
                Buying sale = store.getSales()[j];
                double sum = sale.getProduct().getCost() * sale.getCount();
                buyingDtos[j] = new BuyingDto(sale.getProduct().getName(), sale.getCount(), sum);
                System.out.println(buyingDtos[j]);
            }
            array[i] = new StoreDto(name, buyingDtos);
        }
        return array;


    }

}

