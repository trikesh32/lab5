package utils;

/**
 * Интерфейс для всех выполняемых команд.
 * @author trikesh
 */
public interface Executable {
    /**
     * Выполнить команду.
     *
     * @param args Аргумент для выполнения
     * @return результат выполнения
     */
    ExecutionResponse apply(String [] args);
}
