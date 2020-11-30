package com.example.midtermretrofit.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;
import java.util.List;

public class breedList {

        @SerializedName("breeds")
        @Expose
        private List<breeds> breeds = null;

        public List<breeds> getBreeds() {
            return breeds;
        }

        public void setBreeds(List<breeds> breeds) {
            this.breeds = breeds;
        }


}
