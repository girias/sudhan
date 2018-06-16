package com.java.example.JavaSBA_InvoicePayment_3rdProgram;

public class CreditCardPayment extends Payment {

    private String cardNumber;
    private String cvv;
    private String cardName;

    public CreditCardPayment(String accountHolderName, double amount, String cardNumber, String cvv, String cardName) {
        super(accountHolderName, amount);
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.cardName = cardName;
    }

    public CreditCardPayment() {

    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public Double calculateTotalAmount() throws InvalidPaymentException {
        if (!cardNumber.matches("[0-9]{16}$"))
            throw new InvalidPaymentException("Invalid Card Details");

        if (!cvv.matches("[0-9]{3}$"))
            throw new InvalidPaymentException("Invalid Card Details");

        return (amount + (amount * 0.1));
    }

}
