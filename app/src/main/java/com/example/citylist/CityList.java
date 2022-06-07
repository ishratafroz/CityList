package com.example.citylist;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects
 */
public class CityList {
    private List<City> cities = new ArrayList<>();

    /**
     * This adds a city to the list if that city does not exist
     * @param city
     *      This is the city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * This returns a sorted list of citits using city name for params 1
     * and if for params 2 this will return sorted list of cities using province
     * @return
     *      Return the sorted list of cities
     *
     */
    public List<City> getCities(int params) {
        List<City> cityList = cities;
        if(params == 1){
            Collections.sort(cityList);
        }
        else{
            Collections.sort(cityList, new Comparator<City>() {
                @Override
                public int compare(City city, City t1) {
                    return city.getProvinceName().compareTo(t1.getProvinceName());
                }
            });
        }

        return cityList;
    }

    /**
     * This will delete the city if city doesn't exist it will gives us a exception
     * @param city
     */
    public void delete(City city){
        if(!cities.contains(city)){
            throw new IllegalArgumentException();
        }else{
            cities.remove(city);
        }
    }

    /**
     * This will return the total size of cities
     * @return
     */
    public int count(){
        return cities.size();
    }
}