package models;

public enum VehicleType {
    CAR,
    SUBMARINE,
    BICYCLE,
    HOVERBOARD;

    public static String names() {
        StringBuilder VehicleNames = new StringBuilder();
        for (var fuel : values())
            VehicleNames.append(fuel.name()).append(", ");
        return VehicleNames.substring(0, VehicleNames.length() - 2);
    }
}
