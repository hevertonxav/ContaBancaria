import entities.ContaCorrente;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedAnnotationTypes;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContaBancariaTest {

    @Test
    public void deveVerificarSaldo(){
        ContaCorrente conta = new ContaCorrente("Ana", 800.0);
        assertEquals("Saldo = R$ 800.00 \nLimite = R$ 0.00", conta.consultar());
    }

    @Test
    public void deveDepositarValor(){
        ContaCorrente conta = new ContaCorrente ("Bruno", 1000.0);
        conta.depositar(200.0);
        assertEquals("Saldo = R$ 1200.00 \nLimite = R$ 0.00", conta.consultar());
    }

    @Test
    public void deveSacarValorUsandoLimite(){
        ContaCorrente conta = new ContaCorrente("Lucia", 200.0,  2000.0, true);
        conta.sacar(1000);
        assertEquals("Saldo = R$ 0.00 \nLimite = R$ 1200.00",conta.consultar());
    }

    @Test
    public void usouLimiteEspecial(){
        ContaCorrente conta = new ContaCorrente("Danilo", 200.0,  2000.0, true);
        conta.sacar(1000.0);
        boolean usouLimite = conta.verificarUsoEspecial();
        assertTrue(usouLimite);
    }


}
