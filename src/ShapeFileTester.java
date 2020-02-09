/**
 *  Test program to read text from file then create and display various shape.
 *
 *  Created by Nonthakorn Sukprom 60070503435,
 *  6 February 2020.
 */
public class ShapeFileTester
{
    /**
     * Driver method of the program, opens file
     * specified in input argument
     * read each line and create object according to that line contents.
     * Then print out information of the newly create object.
     * @param args      Name of file to open and read.
     */
    public static void main (String[] args)
    {
        if (args.length < 1)
        {
            System.out.println("You must specify a patient data file as a command line argument");
            System.exit(0);
        }
        ShapeReader sReader = new ShapeReader();
        System.out.print("Trying to open file ‘"+ args[0] + "’.... ");
        boolean bOk = sReader.open(args[0]);
        if (bOk)
        {
            System.out.println("success!\n");
            AbstractShape latestShape = null;
            int i = 1;
            while ((latestShape = sReader.readShape()) != null)
            {
                System.out.println("readShape returned an object: " + latestShape.getClass());
                System.out.println("\ttoString: " + latestShape.toString());
                System.out.println("\tperimeter: " + latestShape.calcPerimeter());
                System.out.println();
            }
            System.out.println("\nClosing file and exiting");
            sReader.close();
        }
        else
        {
            System.out.println("\nError opening file \"" + args[0] + "\"");
            System.exit(1);
        }
    }
}
