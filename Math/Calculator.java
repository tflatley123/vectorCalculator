package Math;
import java.util.Arrays;
import java.util.Random;

public class Calculator
{
    private Matrix[] matrices;


    public Calculator(int i, int j)
    {
        matrices = null;

    }


    // create a new matrix
    // return true on succsess, and false if a matrix exists with that name.
    public boolean makeMatrix(int numberRows, int numberColumns, String _name)
    {
        Matrix newMatrix = new Matrix(numberRows, numberColumns, _name);
        if(matrices == null)
        {
            matrices = new Matrix[1];
            matrices[0] = newMatrix;
            return true;
        }
        for(Matrix matrix : matrices)
        {
            // this will make sure it is a unique Matrix name
            if(matrix.equals(newMatrix))
                return false;
        }

        addMatrix(newMatrix);
        return true;
    }

    public boolean deleteMatrix(Matrix delMatrix)
    {
        // find where matrix is
        for(int i = 0; i < matrices.length; i++)
        {
            if(delMatrix.equals(matrices[i]))
            {

                // copy the array upto and after that position
                // copyRange (original array, from pos, to pos) (to is exclusive)
                Matrix[] before =  Arrays.copyOfRange(matrices, 0, i);
                Matrix[] after = Arrays.copyOfRange(matrices, i+1, matrices.length + 1);

                // make new matrix then copy the others to it
                matrices = new Matrix[matrices.length-1];
                System.arraycopy(before, 0, matrices, 0, before.length);
                System.arraycopy(after, 0, matrices, before.length, after.length);

            }
        }
        // otherwise it could find a matrix with that name
        return false;
    }

    public void replaceMatrix(String oldName, Matrix newMatrix)
    {
        for(Matrix matrix : matrices)
        {
            if(matrix.getName() == oldName)
            {
                matrix = newMatrix;
            }
        }
    }

    private void addMatrix(Matrix newMatrix)
    {
        // make new array of size + 1
        matrices = Arrays.copyOf(matrices, matrices.length + 1);

        // make the last element = newMatrix
        matrices[matrices.length - 1] = newMatrix;
    }

    public Matrix getMatrix(String name)
    {
        for(Matrix matrix : matrices)
        {
            if(matrix.getName() == name)
            {
                return matrix;
            }
        }
        Matrix zero = new Matrix(1, 1, "zero");
        return zero;
        // need to add something
    }

    public static void main(String[] args)
    {
        Random rndm = new Random();
        Calculator c = new Calculator(3, 4);
        c.makeMatrix(3, 2, "example");
        for(int i = 0; i < c.getMatrix("example").numberColumns; i++)
        {
            for(int j = 0; j < c.getMatrix("example").numberRows; j++)
            {
                    c.getMatrix("example").setData(j, i, rndm.nextDouble() * 30);
            }
        }
        c.getMatrix("example").print();
        System.out.println();
        Operations.transpose(c.getMatrix("example")).print();


    }


}
