import java.util.Scanner;
import java.util.ArrayList;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardOpenOption.*;


public class PersonGenerator {
    public static void main(String[] args) {

        Scanner pipe = new Scanner(System.in);

        boolean done = false;
        ArrayList<String> personList = new ArrayList<String>();
        String ID = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int yearOfBirth = 0;
        String[] record = new String[4];




        do {

                ID = SafeInput.getNonZeroLenString(pipe,"What is your ID?");
                firstName = SafeInput.getNonZeroLenString(pipe,"What is your first name?");
                lastName = SafeInput.getNonZeroLenString(pipe,"What is your last name?");
                title = SafeInput.getNonZeroLenString(pipe,"What is your title name?");
                yearOfBirth = SafeInput.getInt(pipe,"What is your year of birth?");


                personList.add(ID + ", " + firstName + ", " + lastName + ", " + title + ", " + yearOfBirth);
                done = SafeInput.getYNConfirm(pipe, "Are you finished? ");

        }while(!done);

        String nameOfFile;


        nameOfFile = SafeInput.getNonZeroLenString(pipe, "Please enter the name of the file you want to save these records into: ");
        nameOfFile += ".txt";

        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\"+nameOfFile);


        try
        {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));

            for(String rec : personList)
            {
                writer.write(rec, 0, rec.length());
                writer.newLine();
            }
            writer.close();
            System.out.println("data file written");

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    }


