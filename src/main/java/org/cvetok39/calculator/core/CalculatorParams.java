package org.cvetok39.calculator.core;

public class CalculatorParams {
    private String _flower;
    private String _height;
    private String _color;
    private int _flowersCount;
    private String _bouquetsCount;
    private String _pack;

    public String getFlower() {
        return _flower;
    }

    public void setFlower(String flower) {
        _flower = flower;
    }

    public String getHeight() {
        return _height;
    }

    public void setHeight(int height) {
        _height = height + " см";
    }

    public String getBouquetsCount() {
        return _bouquetsCount;
    }

    public void setBouquetsCount(int count) {
        _bouquetsCount = count + " букет";
    }

    public int getFlowersCount() {
        return _flowersCount;
    }

    public void setFlowersCount(int count) {
        _flowersCount = count;
    }

    public String getPack() {
        return _pack;
    }

    public void setPack(CalculatorPack pack) {
        switch (pack) {
            case RAFFIA -> {
                _pack = "Рафия";
                break;
            }

            case FILM -> {
                _pack = "Пленка";
                break;
            }

            case RIBBON -> {
                _pack = "Лента";
                break;
            }

            case GRID -> {
                _pack = "Сетка";
                break;
            }

            case EMPTY -> {
                _pack = "Без упаковки";
                break;
            }
        }
    }

    public String getColor() {
        return _color;
    }

    public void setColor(CalculatorColor color) {
        switch (color) {
            case MIX -> {
                _color = "Микс";
                break;
            }

            case RED -> {
                _color = "Красный";
                break;
            }

            case WHITE -> {
                _color = "Белый";
                break;
            }

            case PINK -> {
                _color = "Розовый";
                break;
            }

            case CRIMSON -> {
                _color = "Малиновый";
                break;
            }

            case ORANGE -> {
                _color = "Оранжевый";
                break;
            }

            case YELLOW -> {
                _color = "Желтый";
                break;
            }
        }
    }
}
