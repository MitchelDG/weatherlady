package com.mkdev.weatherlady.dto;

public enum WindDirection {
    NORTH(337.6, 22.5),
    NORTH_EAST(22.6, 67.5),
    EAST(67.6, 112.5),
    SOUTH_EAST(112.6, 157.5),
    SOUTH(157.6, 202.5),
    SOUTH_WEST(202.6, 247.5),
    WEST(247.6, 292.5),
    NORTH_WEST(292.6, 337.5);

    public final double minValue;
    public final double maxValue;

    private WindDirection(double minValue, double maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public double getMinValue() {
        return minValue;
    }

    public double getMaxValue() {
        return maxValue;
    }

}