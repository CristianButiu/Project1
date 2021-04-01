package Model;

import static org.junit.jupiter.api.Assertions.*;


import Model.Operatii;
import Model.Polinom;

import static org.junit.jupiter.api.Assertions.*;

class OperatiiTest {
    Operatii c = new Operatii();
    Polinom p1 = c.stringToPolinom("1x^3-2x^2+6x^1-5x^0");
    Polinom p2 = c.stringToPolinom("1x^2-1x^0");
    @org.junit.jupiter.api.Test
    void testAdunareSauScadare() {
        assertEquals("+1.0x^3-1.0x^2+6.0x^1-6.0x^0", c.adunareSauScadare(p1, p2, 0).toString());
        assertEquals("+1.0x^3-3.0x^2+6.0x^1-4.0x^0", c.adunareSauScadare(p1, p2, 1).toString());
    }

    @org.junit.jupiter.api.Test
    void testIntegrare() {
        assertEquals("+0.25x^4-0.6666666666666666x^3+3.0x^2-5.0x^1",c.integrare(p1).toString());

    }

    @org.junit.jupiter.api.Test
    void testDerivare() {
        assertEquals("+3.0x^2-4.0x^1+6.0x^0", c.derivare(p1).toString());
    }

    @org.junit.jupiter.api.Test
    void testInmultire() {
        assertEquals("+1.0x^5-2.0x^4+5.0x^3-3.0x^2-6.0x^1+5.0x^0", c.inmultire(p1, p2).toString());
    }

    @org.junit.jupiter.api.Test
    void testImpartire() {
        assertEquals("+1.0x^1-2.0x^0", c.impartire(p1, p2).get(0).toString());
        assertEquals("+7.0x^1-7.0x^0", c.impartire(p1, p2).get(1).toString());

    }
}