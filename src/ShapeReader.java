/**
 *  Subclass of TextFileReader.java.
 *  Read data from text file and create object specified in the text.
 *  Text in the text file should be like in this example format:
 *                      SQUARE 120 100 80
 *
 *  Created by Nonthakorn Sukprom 60070503435,
 *  6 February 2020.
 */
public class ShapeReader extends TextFileReader
{
    /**
     * Read line from file then split each field
     * and recognise what shape that line is
     * then create that shape object by parsing field from the file.
     * @return      AbstractShape object that is created.
     */
    public AbstractShape readShape ()
    {
        AbstractShape latestShape = null;

        String lineRead = getNextLine();
        if(lineRead != null)
        {
            String[] fields = lineRead.split(" ");
            if (fields[0].equals("TRIANGLE"))
            {
                if (fields.length == 7)
                {
                    try
                    {
                        int[] coordinate = new int[fields.length - 1];  // {x1, y1, x2, y2, x3, y3}
                        for (int i = 0; i < coordinate.length; i++)
                        {
                            coordinate[i] = Integer.parseInt(fields[i + 1]);
                        }
                        latestShape = new Triangle(coordinate[0],coordinate[1],coordinate[2],
                                                    coordinate[3],coordinate[4],coordinate[5]);
                    }

                    catch (NumberFormatException nfe)
                    {
                    }
                }
            }
            if (fields[0].equals("SQUARE"))
            {
                if (fields.length == 4)
                {
                    try
                    {
                        int[] coordinate = new int[fields.length - 1];  // {x, y, side}
                        for (int i = 0; i < coordinate.length; i++)
                        {
                            coordinate[i] = Integer.parseInt(fields[i + 1]);
                        }
                        latestShape = new Square(coordinate[0], coordinate[1], coordinate[2]);
                    }
                    catch (NumberFormatException nfe)
                    {
                    }
                }
            }
            if (fields[0].equals("DIAMOND"))
            {
                if (fields.length == 5)
                {
                    try
                    {
                        int[] coordinate = new int[fields.length - 1];  // {x, y, verticalAxis, horizontalAxis}
                        for (int i = 0; i < coordinate.length; i++)
                        {
                            coordinate[i] = Integer.parseInt(fields[i + 1]);
                        }
                        latestShape = new Diamond(coordinate[0], coordinate[1], coordinate[2], coordinate[3]);
                    }
                    catch (NumberFormatException nfe)
                    {
                    }
                }
            }
            if (fields[0].equals("CIRCLE"))
            {
                if (fields.length == 4)
                {
                    try
                    {
                        int[] coordinate = new int[fields.length - 1];  // {x, y, radius}
                        for (int i = 0; i < coordinate.length; i++)
                        {
                            coordinate[i] = Integer.parseInt(fields[i + 1]);
                        }
                        latestShape = new Circle(coordinate[0], coordinate[1], coordinate[2]);
                    }
                    catch (NumberFormatException nfe)
                    {
                    }
                }
            }
        }

        return latestShape;
    }
}
