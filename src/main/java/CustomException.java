public class CustomException extends Throwable{

    //region Исключения
    /**
     * Проверка доступности суммы для снятия со счёта
     * @param acc счёт
     * @param sum сумма для снятия
     * @return истина или ложь
     */
    public static boolean InsufficientFundsException(Account acc, int sum){
        try{
            if(acc.getBalanceAcc() < sum){
                throw new Exception(String.format("""
                        Операция не выполнена.
                        На счёте № %d недостаточно средств.
                        Текущий баланс %d, требуется %d
                        """, acc.getIdAcc(), acc.getBalanceAcc(), sum));
            }
            else return true;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }

    /**
     * Проверка правильности ввода суммы
     * @param sum сумма
     * @return истина или ложь
     */
    public static boolean IllegalArgumentException(int sum){
        try{
            if(sum <= 0){
                throw new Exception("""
                        Операция не выполнена.
                        Сумма для зачисления не может быть отрицательной.
                        """);
            }
            else return true;
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return false;
    }
    //endregion
}
