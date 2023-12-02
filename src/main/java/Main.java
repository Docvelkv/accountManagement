public class Main {
    public static void main(String[] args) {
        // Введена отрицательная сумма
        Account acc1 = new Account("client1", -50);
        acc1.infoAcc();
        // Пополнение счёта
        acc1.accRefill(75);
        acc1.infoAcc();

        Account acc2 = new Account("client2", 100);
        acc2.infoAcc();
        // Снятие со счёта
        acc2.withdrawalFromAcc(50);
        acc2.infoAcc();
        // Открытие кредитного счёта
        CreditAccount creditAcc = new CreditAccount("client1", 200, acc1);
        creditAcc.infoAcc();
        acc1.infoAcc();
        // Погашение кредита
        creditAcc.repayment(220, acc2);
        creditAcc.repayment(220, acc1);
        System.out.println(creditAcc.getBalanceAcc());
    }
}
