package models;

public enum FuelType {
    GASOLINE,
    KEROSENE,
    ALCOHOL,
    MANPOWER;

    public static String names() {
        StringBuilder fuelNames = new StringBuilder();
        for (var fuel : values())
            fuelNames.append(fuel.name()).append(", ");
        return fuelNames.substring(0, fuelNames.length() - 2);
    }
}
