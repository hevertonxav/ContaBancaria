package entities;

public class ContaCorrente {

    private String titular;
    private String numeroConta;
    private double saldo;
    private double limite;
    private boolean especial;


    public ContaCorrente(String titular,  double saldo) {
        this.titular = titular;
        this.saldo = saldo;
    }

    public ContaCorrente(String titular, double saldo, double limite, boolean especial) {
        this.titular = titular;
        this.saldo = saldo;
        this.limite = especial ? limite : 0;
        this.especial = especial;
    }


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        if(especial) {
            this.limite = limite;
        }
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }




    public String consultar() {

        if(verificarUsoEspecial()) {
            return String.format("Saldo = R$ 0.00 \nLimite = R$ %.2f", limite);
        }

        return String.format("Saldo = R$ %.2f \nLimite = R$ %.2f", saldo, limite);
    }

    public void depositar(double valor) {

        if(saldo < 0){
            saldo += valor;
            if(saldo < 0) {
                limite += valor;
                return;
            }
            limite += valor - saldo;
            return;
        }
        saldo += valor;


    }

    public void sacar(double valor) {

        if(valor <= 0){
            return;
        }

        if(valor <= saldo + limite){

            saldo -= valor;
            if(saldo < 0) {
                limite += saldo;
            }
            return;
        }

        System.out.println("Saldo insuficiente");
    }

    public boolean verificarUsoEspecial(){
        if(saldo < 0){
            return true;
        }
        return false;
    }
}