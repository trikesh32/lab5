package models;

/**
 * Перечисление всех типов FuelType
 * @author trikesh
 */
public enum FuelType {
    GASOLINE,
    KEROSENE,
    ALCOHOL,
    MANPOWER;

    /**
     * @return возвращает строку со всеми значениями через запятую
     */
    public static String names() {
        StringBuilder fuelNames = new StringBuilder();
        for (var fuel : values())
            fuelNames.append(fuel.name()).append(", ");
        return fuelNames.substring(0, fuelNames.length() - 2);
    }
}
