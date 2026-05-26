public class SavingsAccount {
    public static double annualInterestRate;
    private double balance;

    public SavingsAccount(double balance) {
        this.balance = balance;
    }

    public void calculerMonthlyInterest(){
        balance += (balance * annualInterestRate) / 12;
    }

    public void modifyInterestRate(double rate){
        this.annualInterestRate = rate;
    }

    static void main() {
        SavingsAccount saver1 = new SavingsAccount(2000);
        SavingsAccount saver2 = new SavingsAccount(3000);
        saver1.modifyInterestRate(0.04);
        saver2.modifyInterestRate(0.04);

        saver1.calculerMonthlyInterest();
        System.out.println(saver1.balance);

        saver2.calculerMonthlyInterest();
        System.out.println(saver2.balance);

        saver1.modifyInterestRate(0.05);
        saver2.modifyInterestRate(0.05);

        saver1.calculerMonthlyInterest();
        System.out.println(saver1.balance);

        saver2.calculerMonthlyInterest();
        System.out.println(saver2.balance);
    }
}
