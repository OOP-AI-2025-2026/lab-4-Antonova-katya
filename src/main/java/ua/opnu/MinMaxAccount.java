package ua.opnu;

public class MinMaxAccount extends BankingAccount {
        private int minBalance;
        private int maxBalance;

        public MinMaxAccount(Startup s) {
            super(s);
            int currentBalance = getBalance();
            this.minBalance = currentBalance;
            this.maxBalance = currentBalance;
        }

        public int getMin() {
            return this.minBalance;
        }

        public int getMax() {
            return this.maxBalance;
        }

        public void updatingValues() {
            int currentBalance = super.getBalance();
            if (currentBalance > maxBalance) {
                maxBalance = currentBalance;
            }
            if (currentBalance < minBalance) {
                minBalance = currentBalance;
            }
        }

        @Override
        public void debit(Debit d) {
            super.debit(d);
            updatingValues();
        }

        @Override
        public void credit(Credit c) {
            int number = c.getBalance();
            if (number < 0) number = -number;
            super.credit(new Credit(number));
            updatingValues();
        }
}
