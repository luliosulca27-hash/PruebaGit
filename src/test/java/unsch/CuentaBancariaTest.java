package unsch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaBancariaTest {

    // Prueba 1: Deposito inicial
    @Test
    void depositoDebeIncrementarSaldo() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.depositar(50);
        assertEquals(150, cuenta.obtenerSaldo());
    }

    // Prueba 2: Retiro con saldo suficiente
    @Test
    void retirarConSaldoSuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.retirar(200);
        assertEquals(800, cuenta.obtenerSaldo());
    }

    // Prueba 3: Retiro con saldo insuficiente
    @Test
    void retirarConSaldoInsuficiente() {
        CuentaBancaria cuenta = new CuentaBancaria(100);
        cuenta.retirar(500);
        assertEquals(100, cuenta.obtenerSaldo());
    }

    // Prueba 4: Retiro con monto negativo
    @Test
    void retirarMontoNegativo() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.retirar(-200);
        assertEquals(1000, cuenta.obtenerSaldo());
    }

    // Prueba 5: Deposito con monto valido
    @Test
    void depositarMontoValido() {
        CuentaBancaria cuenta = new CuentaBancaria(1000);
        cuenta.depositar(500);
        assertEquals(1500, cuenta.obtenerSaldo());
    }

    // Prueba 6: Transferencia entre cuentas
    @Test
    void transferirDinero() {
        CuentaBancaria origen = new CuentaBancaria(1000);
        CuentaBancaria destino = new CuentaBancaria(500);

        origen.transferir(destino, 200);

        assertEquals(800, origen.obtenerSaldo());
        assertEquals(700, destino.obtenerSaldo());
    }
}