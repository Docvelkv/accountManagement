public class CreditAccount extends Account{

    /**
     * Конструктор кредитного счёта
     * @param ownersAcc имя на кого оформлен кредит
     * @param loanAmount сумма кредита
     * @param acc счёт для перевода средств
     */
    public CreditAccount(String ownersAcc, int loanAmount, Account acc) {
        super(ownersAcc, loanAmount);
        Transaction.transaction(this, acc, loanAmount);
        this.setBalanceAcc(loanAmount / 100 * -110);
    }

    /**
     * Погашение кредита
     * @param sum сумма погашения
     * @param acc счёт с которого переводятся средства
     */
    public void repayment(int sum, Account acc){
        if(this.getBalanceAcc() < 0){
            Transaction.transaction(acc, this, sum);
        }
        if(this.getBalanceAcc() > 0){
            int returnAmount = this.getBalanceAcc();
            Transaction.transaction(this, acc, returnAmount);
        }
        if(this.getBalanceAcc() == 0){
            System.out.println("Кредит погашен");
        }
    }

    /**
     * Переопределение toString
     * @return String
     */
    public String toString(){
        return String.format("Кредитный счёт № %d, имя клиента: %s, баланс: %d",
                this.getIdAcc(), this.getOwnersAcc(), this.getBalanceAcc());
    }
}
