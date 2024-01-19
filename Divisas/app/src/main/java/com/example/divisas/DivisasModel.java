package com.example.divisas;

import android.view.View;

public class DivisasModel {

    public String divisaAbrev;
    public String divisaValor;

    public DivisasModel(String divisaAbrev, String divisaValor) {

        this.divisaAbrev = divisaAbrev;
        this.divisaValor = divisaValor;
    }

    public String getDivisaAbrev() {
        return divisaAbrev;
    }

    public String getDivisaValor() {
        return divisaValor;
    }

}

