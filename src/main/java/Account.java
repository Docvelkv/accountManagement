import java.util.concurrent.atomic.AtomicInteger;

public class Account {

    //region Поля
    private static final AtomicInteger COUNTER = new AtomicInteger(1);
    private int idAcc;
    private String ownersAcc;
    private int balanceAcc;
    //endregion

    //region Конструктор
    public Account(String ownersAcc, int balance) {
        idGeneration();
        this.setOwnersAcc(ownersAcc);
        this.balanceAcc = setInitialBalanceAcc(balance);
    }
    //endregion

    //region Getter&Setter

    /**
     * Получение номера счёта
     * @return int
     */
    public int getIdAcc(){
        return idAcc;
    }

    /**
     * Получение имени владельца счёта
     * @return String
     */
    public String getOwnersAcc() {
        return this.ownersAcc;
    }

    /**
     * Установка имени владельца счёта
     * @param ownersAcc имя
     */
    public void setOwnersAcc(String ownersAcc) {
        this.ownersAcc = ownersAcc;
    }

    /**
     * Получение баланса счёта
     * @return int
     */
    public int getBalanceAcc() {
        return this.balanceAcc;
    }

    /**
     * Установка баланса счёта
     * @param sum сумма изменения баланса
     */
    public void setBalanceAcc(int sum){
        this.balanceAcc = this.getBalanceAcc() + sum;
    }
    //endregion

    //region Методы

    /**
     * Генерация номера счёта
     */
    private void idGeneration(){
        idAcc = COUNTER.getAndIncrement();
    }

    /**
     * Установка начального баланса при открытии счёта
     * @param balance начальная сумма
     * @return int
     */
    private int setInitialBalanceAcc(int balance) {
        if(CustomException.IllegalArgumentException(balance)){
            return balance;
        }
        return 0;
    }

    /**
     * Пополнение счёта
     * @param deposit сумма пополнения
     */
    public void accRefill(int deposit){
        if(CustomException.IllegalArgumentException(deposit)){
            this.balanceAcc = this.getBalanceAcc() + deposit;
            System.out.printf("""
                    Операция выполнена.
                    На счёт № %d зачислено %d.
                    Текущий баланс %d.
                    """, this.getIdAcc(), deposit, this.getBalanceAcc());
        }
    }

    /**
     * Вывод средств со счёта
     * @param summa сумма вывода
     */
    public void withdrawalFromAcc(int summa){
        if(CustomException.InsufficientFundsException(this, summa)){
            this.balanceAcc = this.getBalanceAcc() - summa;
            System.out.printf("""
                    Операция выполнена.
                    Со счёта № %d снято %d.
                    Текущий баланс %d.
                    """, this.getIdAcc(), summa, this.getBalanceAcc());
        }
    }

    public void infoAcc(){
        System.out.println(this);
    }
    //endregion

    //region Переопределение toString
    public String toString(){
        return "№ счёта: " + this.getIdAcc() +
                "; Имя клиента: " + this.getOwnersAcc() +
                "; Баланс: " + this.getBalanceAcc() +
                "\n";
    }
    //endregion
}
