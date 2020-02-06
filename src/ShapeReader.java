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
    public AbstractShape readShape(String filename)
    {
        AbstractShape shape = null;

        String lineRead = getNextLine();

        return shape;
    }
}
