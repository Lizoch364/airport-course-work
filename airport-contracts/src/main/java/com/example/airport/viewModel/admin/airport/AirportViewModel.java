package com.example.airport.viewModel.admin.airport;

public class AirportViewModel {
     private int id;
     private String name;
     private String city;

     public AirportViewModel(int id, String name, String city) {
        setId(id);
        setName(name);
        setCity(city);
     }

     protected AirportViewModel() {}

     public int getId() {
       return id;
     }

     public String getName() {
       return name;
     }

     public String getCity() {
       return city;
     }

     public void setId(int id) {
       this.id = id;
     }

     public void setName(String name) {
       this.name = name;
     }

     public void setCity(String city) {
       this.city = city;
     }
}
