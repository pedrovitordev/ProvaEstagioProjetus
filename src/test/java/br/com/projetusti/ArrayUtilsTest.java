package br.com.projetusti;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

public class ArrayUtilsTest {

    /**
     * Teste Case 1: Lista com os elementos de 0 a 10 em ordem decrescente.
     */
    private static final String TEST_CASE_1 = "test_case_1.txt";

    /**
     * Teste Case 2: Lista com os elementos de 1 a 1001 em ordem aleatória.
     */
    private static final String TEST_CASE_2 = "test_case_2.txt";

    private static final ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

    /**
     * Dado o nome do arquivo, retorna a lista de inteiros nesse arquivo. O
     * números devem estar separados por vírgula.
     *
     * @param fileName Nome do Arquivo.
     * @return Lista de inteiros presentes no arquivo.
     */
    private List<Integer> getListInt(final String fileName) throws URISyntaxException, IOException {
        final Path path = Paths.get(getClass().getClassLoader().getResource(fileName).toURI());
        final String content = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
        return Arrays.stream(content.split(",")).map(Integer::valueOf).collect(Collectors.toList());
    }

    @Test
    public void findMedianCase1Test() throws Exception {
        Assert.assertEquals(5, ArrayUtils.findMedian(getListInt(TEST_CASE_1)));
    }

    @Test
    public void findMedianCase2Test() throws Exception {
        Assert.assertEquals(501, ArrayUtils.findMedian(getListInt(TEST_CASE_2)));
    }

    @Test
    public void doOperationAddTest() {

        boolean add = ArrayUtils.doOperation(array, ArrayUtils.Operation.ADD, 8);

        Assert.assertTrue(add);
    }

    @Test
    public void doOperationRemoveTest() {

        boolean remove = ArrayUtils.doOperation(array, ArrayUtils.Operation.REMOVE, 4);
        Assert.assertTrue(remove);
    }

    @Test
    public void doOperationNotRemoveTest() {

        boolean remove = ArrayUtils.doOperation(array, ArrayUtils.Operation.REMOVE, 7);
        Assert.assertFalse(remove);
    }

    @Test
    public void doOperationExistTest() {

        boolean exist = ArrayUtils.doOperation(array, ArrayUtils.Operation.EXISTS, 3);
        Assert.assertTrue(exist);
    }

    @Test
    public void doOperationNotExistTest() {

        boolean exist = ArrayUtils.doOperation(array, ArrayUtils.Operation.EXISTS, 7);
        Assert.assertFalse(exist);
    }

    @Test
    public void findAtExistTest() {

        int exist = ArrayUtils.findAt(array, 3);
        Assert.assertEquals(exist, 4);
    }
   
    @Test
    public void findAtNotExistTest() {
        int exist = ArrayUtils.findAt(array, 6);
        Assert.assertEquals(exist, -1);
    }
    
    @Test
    public void ExistTest() {
        
        boolean exist = ArrayUtils.exists(array, 4);
        Assert.assertTrue(exist);
    }
          
    @Test
    public void NotExistTest() {
        
        boolean exist = ArrayUtils.exists(array, 6);
        Assert.assertFalse(exist);
    }
     
    
}
