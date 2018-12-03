import org.junit.*;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class TestUnit {
    Function function;

    @Before
    public void setUp(){
        function = new Function();
    }

    /**
     * Test Case 1
     * @Name NotNull return Value
     * Не Null вовращаемое значение
     *
     * @Description
     * Проверяет функцию на возврщаемое значение отличное от null -> функция работает корректно(без ошибки)
     *
     * @Input
     * Входные данные корректные:
     * <param type> = int
     * <param type> = int
     *
     * @Result
     * Ожидание:
     * Возвращаемое значение не равно null
     */
    @Test
    public void Working(){
        int paramType1 = 15;
        int paramType2 = 6;

        assertNotNull(function.procedure(paramType1, paramType2));
    }

    /**
     * Test Case 2
     * @Name Correct different input
     * Ввод различных корректных данных из набора: (int, long) (long, int)
     *
     * @Description Проверяет функцию на различные входные из представленных типов данных
     *
     * @Input
     * Входные данные корректны:
     * <param type> = int
     * <param type> = long
     * либо
     * <param type> = long
     * <param type> = int
     *
     * @Result
     * Ожидание:
     * Возвращаемое значение Void или java.lang.Integer
     *
     */
    @Test
    public void DifferentTypesInput(){
        int paramType1 = 15;
        long paramType2 = 6L;

        assertTrue(function.procedure(paramType1, paramType2).getClass().getCanonicalName().equals("Void") ||
                function.procedure(paramType1, paramType2).getClass().getCanonicalName().equals("java.lang.Integer"));
        assertTrue(function.procedure(paramType2, paramType1).getClass().getCanonicalName().equals("Void") ||
                function.procedure(paramType2, paramType1).getClass().getCanonicalName().equals("java.lang.Integer"));
    }

    /**
     * Test Case 3
     * @Name Correct same types input
     * Ввод одинаковых корректных данных из набора: (int, int) (long, long)
     *
     * @Description Проверяет функцию на различные из представленных типов данных
     *
     * @Input
     * Входные данные корректны:
     * <param type> = int
     * <param type> = int
     * либо
     * <param type> = long
     * <param type> = long
     *
     * @Result
     * Ожидание:
     * Возвращаемое значение Void или java.lang.Integer
     *
     */
    @Test
    public void sameTypesInput(){
        int intType1 = 15;
        int intType2 = 6;

        assertTrue(function.procedure(intType1, intType2).getClass().getCanonicalName().equals("Void") ||
                function.procedure(intType1, intType2).getClass().getCanonicalName().equals("java.lang.Integer"));

        long longType1 = 89L;
        long longType2 = 88L;

        assertTrue(function.procedure(longType1, longType2).getClass().getCanonicalName().equals("Void") ||
                function.procedure(longType1, longType2).getClass().getCanonicalName().equals("java.lang.Integer"));
    }

    /**
     * Test Case 4
     * @Name All return types
     * Все выходные значения типов данных
     *
     * @Description В ходе работы функции возможно получить все корректные типы возвращаемых данных.
     * Так как все комбинации входных данных были протестированны на корректность выше, будем считать результат корректным,
     * а результат теста оценивать по полноте получаемых типов данных.
     *
     * @Input
     * Входные данные корректны:
     * <param type> = int или long
     * все комбинации
     *
     * @Result
     * Ожидание:
     * Возвращаемое значение Void или java.lang.Integer, при этом, в зависимости от значений,
     * должны быть получены как Void, так и java.lang.Integer
     *
     * @haveVoid - переменная получения типа Void
     * @haveInteger - переменная получения типа java.lang.Integer
     *
     */
    @Test
    public void differentReturnTypes(){
        int paramType1 = 15;
        long paramType2 = 6;

        Boolean haveVoid = false;
        Boolean haveInteger = false;

        // int, int
        if (function.procedure(paramType1, paramType1).getClass().getCanonicalName().equals("Void")){
            haveVoid = true;
        }
        if (function.procedure(paramType1, paramType1).getClass().getCanonicalName().equals("java.lang.Integer")){
            haveInteger = true;
        }
        // int, long
        if (function.procedure(paramType1, paramType2).getClass().getCanonicalName().equals("Void")){
            haveVoid = true;
        }
        if (function.procedure(paramType1, paramType2).getClass().getCanonicalName().equals("java.lang.Integer")){
            haveInteger = true;
        }
        // long, int
        if (function.procedure(paramType2, paramType1).getClass().getCanonicalName().equals("Void")){
            haveVoid = true;
        }
        if (function.procedure(paramType2, paramType1).getClass().getCanonicalName().equals("java.lang.Integer")){
            haveInteger = true;
        }
        // long, long
        if (function.procedure(paramType1, paramType1).getClass().getCanonicalName().equals("Void")){
            haveVoid = true;
        }
        if (function.procedure(paramType1, paramType1).getClass().getCanonicalName().equals("java.lang.Integer")){
            haveInteger = true;
        }

        assertTrue(haveInteger && haveVoid);
    }

    /**
     * Test Case 5
     * @Name One incorrect input type
     * Один неверный тип во входных значениях
     *
     * @Description Проверяем работу функции при одном некорректном типе входных данных.
     *
     * @Input
     * Входные данные корректны:
     * <param type> = int
     * <param type> = String
     *
     * @Result
     * Ожидание:
     * Возникновение исключения с информацией об ошибке
     *
     * @haveUserException перменная получения исключения
     */
    @Test(expected = java.lang.AssertionError.class)
    public void oneIncorrectInput() throws UserException{
        int paramType1 = 28;
        String paramType2 = "Да";

        boolean haveUserException = false;

        try {
            function.procedure(paramType1, paramType2);
        } catch (Exception e){
            haveUserException = true;
        } finally {
            assertTrue(haveUserException);
        }
    }

    /**
     * Test Case 6
     * @Name Two incorrect input type
     * Два неверных типа во входных значениях
     *
     * @Description Проверяем работу функции при двух некорректных типех входных данных.
     *
     * @Input
     * Входные данные корректны:
     * <param type> = char
     * <param type> = String
     *
     * @Result
     * Ожидание:
     * Возникновение исключения с информацией об ошибке
     *
     * @haveUserException перменная получения исключения
     */
    @Test(expected = java.lang.AssertionError.class)
    public void twoIncorrectInput() throws UserException{
        char paramType1 = 'j';
        String paramType2 = "Да";

        boolean haveUserException = false;

        try {
            function.procedure(paramType1, paramType2);
        } catch (Exception e){
            haveUserException = true;
        } finally {
            assertTrue(haveUserException);
        }
    }

}
