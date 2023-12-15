package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cajero")
public class CajeroController {

    /*
     
Consultar los movimientos de cualquiera de sus cuentas, eligiendo cuál. ¿Qué entendemos por movimientos? Ingresos y retiradas de efectivo, comisiones que se le hayan cargado, transferencias salientes y entrantes. No hace falta que pueda filtrar ni que sean endpoints separados, pero sí que tiene que saber de qué tipo es cada movimiento.
Sacar dinero solo de la cuenta a la que esté asociada la tarjeta que haya introducido en el cajero. Si la tarjeta es de débito, solo podrá sacar dinero si tiene saldo suficiente. Si la tarjeta es de crédito, podrá sacar también cuando no supere el máximo de crédito del que puede disponer. No podrá sacar dinero por encima del límite que tenga configurado para su tarjeta, sea de débito o de crédito. Si el cajero que está utilizando es de otro banco, se deberán tener en cuenta las comisiones que aplique esa entidad.
Ingresar dinero, pero solo en la cuenta a la que esté asociada la tarjeta que ha introducido y solo si el cajero es del mismo banco. No se puede ingresar dinero desde cajeros de otras entidades.
Hacer transferencias a otras cuentas del mismo o de distinto banco. Se deberá validar que el IBAN de destino es un IBAN válido y se deberá tener en cuenta que las transferencias a otros bancos pueden tener comisiones.
Activar su tarjeta si es la primera vez que la utiliza. ¡Ojo! No podrá hacer ninguna otra operación de las descritas anteriormente si todavía no ha activado su tarjeta.
Cambiar su código PIN. Podrá hacerlo cuantas veces quiera, pero será obligatorio tras la activación inicial de la tarjeta.

     */
    @GetMapping("/status")
    public String getCajeroStatus() {
        return "Cajero is operational";
    }

    @GetMapping("/movements")
    public String getMovements() {
        return "movements";
    }

    @PostMapping("/withdraw")
    public String withdraw() {
        return "withdraw";
    }

    @PostMapping("/deposit")
    public String deposit() {
        return "deposit";
    }

    @PostMapping("/transfer")
    public String transfer() {
        return "transfer";
    }

    @PostMapping("/activate")
    public String activate() {
        return "activate";
    }

    @PostMapping("/change-pin")
    public String changePin() {
        return "change-pin";
    }

    @PostMapping("/change-limit")
    public String changeLimit() {
        return "change-limit";
    }

    @PostMapping("/create-account")
    public String createAccount() {
        return "create-account";
    }

    // Add more methods for other endpoints as needed

}
