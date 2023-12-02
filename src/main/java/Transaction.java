public class Transaction {

    /**
     * Перевод со счёта на счёт
     * @param acc1 счёт для снятия средств
     * @param acc2 счёт пополнения
     * @param sum сумма для пополнения
     */
    public static void transaction(Account acc1, Account acc2, int sum){
        if(CustomException.IllegalArgumentException(sum) &&
            CustomException.InsufficientFundsException(acc1, sum)){
            acc1.setBalanceAcc(sum * -1);
            acc2.setBalanceAcc(sum);
            System.out.printf("""
                Операция выполнена.
                Перевод со счёта № %d на счёт № %d.
                Сумма перевода %d.
                """, acc1.getIdAcc(), acc2.getIdAcc(), sum);
        }
    }
}
