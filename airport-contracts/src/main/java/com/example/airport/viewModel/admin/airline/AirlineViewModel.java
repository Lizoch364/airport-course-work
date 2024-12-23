package com.example.airport.viewModel.admin.airline;

public class AirlineViewModel {
    private int id;
    private String name;

    public AirlineViewModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    protected AirlineViewModel() {}

    public int getId() {
      return id;
    }

    public String getName() {
      return name;
    }

    public void setId(int id) {
      this.id = id;
    }

    public void setName(String name) {
      this.name = name;
    }
}
