import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class JUnit {
    // Patron AAA : Arrange, Act, Assert
    // Arrange = prépare les données et objets
    // Act = exécuter les actions à tester
    // Assert = vérifie les résultats

    // assertEquals(attendu, réel) : compare deux valeurs
    // assertTrue(condition) : vérifie qu'une condition est vraie
    // assertNotNull(objet) : vérifie qu'une référence existe
    // assertThrows(Exception.class, ...) : vérifie qu'une exception est lancée
}

class Calculator{
    public Calculator(){

    }

    int add(int a, int b){
        return a+b;
    }

    int substract(int a, int b){
        return a-b;
    }

    int multiply(int a, int b){
        return a*b;
    }

    int divide(int a, int b){
        return a/b;
    }
}

class CalculatorTest{
    @Test
    void add_returnsCorrectSum(){
        // Arrange
        Calculator calc = new Calculator();
        // Act
        int result = calc.add(3,2);
        // Assert
        assertEquals(5, result);
    }
}
