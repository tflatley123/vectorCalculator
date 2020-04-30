package Math;

public class Operations
{
    public Operations()
    {}

    //public Matrix cross(Matrix a, Matrix b)
    //{}

    public double dot(Matrix a, Matrix b)
    {
        if(a.numberColumns == b.numberRows)
        {
            Matrix result = Matrix(a.numberRows, b.numberColumns, (a.getName() + "_dot_" + b.getName()));
            double sum;
            for(int i = 0; i < b.numberColumns; i++)
            {
                sum = 0;
                for(int j = 0; j < a.numberRows; j++)
                {
                    sum += a.getData(i,j) * b.getData(j,i)
                }

            }
        }
        System.out.println("matrices can not be ")
        return Matrix(1, 1, "zero");
    }

    //public Matrix add(Matrix a, Matrix b)
    //{}

    //public Matrix subtract(Matrix a, Matrix b)
    //{}

    //public Matrix ref(Matrix a)
    //{}

    public static Matrix transpose(Matrix a)
    {
        // make the
        Matrix transposed = new Matrix(a.numberColumns, a.numberRows, (a.getName() + "_t"));

        for(int i = 0; i < a.numberColumns; i++)
        {
            for(int j = 0; j < a.numberRows; j++)
            {
                transposed.setData(i, j, a.getData(j, i));
            }
        }

        return transposed;
    }
}
