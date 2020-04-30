package Math;

public class Matrix
{
    private String name;
    private double[][] data;
    public int numberRows, numberColumns;

    public Matrix()
    {
        name = null;
    }
    public Matrix(int _numberRows, int _numberColumns, String _name)
    {
        name = _name;
        numberRows = _numberRows;
        numberColumns = _numberColumns;

        data = new double[numberRows][numberColumns];
    }

    // set the entry
    public void setData(int row, int column, double newValue)
    {
        data[row][column] = newValue;
    }

    // returns the entry at that position of the matrix
    public double getData(int row, int column)
    {
        return data[row][column];
    }

    public String getName()
    {
        return this.name;
    }

    public boolean equals(Matrix matrix)
    {
        System.out.println(matrix.name);

        if(this.name == null || this.name == "")
            return false;
        return (this.name == matrix.name);
    }

    public void print()
    {
        for(int j = 0; j < numberRows; j++)
        {
            for(int i = 0; i < numberColumns; i++)
            {
                System.out.print(String.valueOf(data[j][i]) + '\t');
            }
            System.out.print("\n\n");
        }
    }

}
