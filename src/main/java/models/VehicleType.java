package models;

/**
 * Перечисление всех типов VehicleType
 * @author trikesh
 */
public enum VehicleType {
    CAR,
    SUBMARINE,
    BICYCLE,
    HOVERBOARD;
    /**
     * @return возвращает строку со всеми значениями через запятую
     */
    public static String names() {
        StringBuilder VehicleNames = new StringBuilder();
        for (var fuel : values())
            VehicleNames.append(fuel.name()).append(", ");
        return VehicleNames.substring(0, VehicleNames.length() - 2);
    }
}
