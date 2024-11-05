package unit02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Practice01Test{

    @Test
    void testArrayToStringWithNonEmptyArray(){
        
        int[] testArray = {1, 2, 3};
        String expected = "[1, 2, 3]";
        
        String result = Practise01.arrayToString(testArray);
        assertEquals(expected, result);
    }
    
    @Test
    void testArrayToStringWithEmptyArray(){
    
        int[] testArray = {};
        String expected = "[]";
        
        String result = Practise01.arrayToString(testArray);
        
        assertEquals(expected, result);
    }
}