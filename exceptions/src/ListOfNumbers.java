/*
 * Copyright (c) 1995, 2008, Oracle and/or its affiliates. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *
 *   - Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *
 *   - Neither the name of Oracle or the names of its
 *     contributors may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS
 * IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR
 * PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL THE COPYRIGHT OWNER OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO,
 * PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Edits by Rafi:
 * - Added readList
 * - Modified cat (see cat for accurate description of editing)
 *
 * Note:
 * This file must be placed in a directory called src/ and the input file must be named InFile.txt and also be placed
 * in src/ for the program to work correctly.
 */
public class ListOfNumbers {
    private List<Integer> list;
    private static final int SIZE = 10;

    /**
     * Tests readList
     * @param args unused parameter
     */
    public static void main(String args[]) {
        ListOfNumbers nums = new ListOfNumbers();
        nums.readList();
    }

    public ListOfNumbers () {
        list = new ArrayList<Integer>(SIZE);
        for (int i = 0; i < SIZE; i++)
            list.add(new Integer(i));
    }

    public void writeList() {
        PrintWriter out = null;

        try {
            System.out.println("Entering try statement");
            out = new PrintWriter(new FileWriter("src/OutFile.txt"));

            for (int i = 0; i < SIZE; i++)
                out.println("Value at: " + i + " = " + list.get(i));
        } catch (IndexOutOfBoundsException e) {
            System.err.println("Caught IndexOutOfBoundsException: " +
                    e.getMessage());
        } catch (IOException e) {
            System.err.println("Caught IOException: " + e.getMessage());
        } finally {
            if (out != null) {
                System.out.println("Closing PrintWriter");
                out.close();
            } else {
                System.out.println("PrintWriter not open");
            }
        }
    }

    /**
     * Reads ints off of a file in src/ called InFile.txt
     *
     * Help from reading files from:
     * http://stackoverflow.com/questions/303913/java-reading-integers-from-a-file-into-an-array/304061#304061
     */
    public void readList() {
        // try catch for when the file is not found
        try {
            // creates a new scanner on the file
            Scanner scanner = new Scanner(new File("src/InFile.txt"));

            // searches for more ints in the file
            while (scanner.hasNextInt()) {
                // prints the next int and adds it to the list
                int num = scanner.nextInt();
                System.out.println(num);
                list.add(num);
            }

            // Tyler helped with closing the scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("No file found");
            e.printStackTrace();
        }
    }

    /**
     * Reads and prints the contents of a file
     *
     * Edits by Rafi:
     * See code
     * @param file the file to be read off of
     */
    public static void cat(File file) {
        RandomAccessFile input = null;
        String line = null;

        try {
            input = new RandomAccessFile(file, "r");
            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }
            // removed unnecessary return
        // added catch clauses
        } catch (IOException e) {
            // input output exception
            e.printStackTrace();
        // happens after the try catch no matter what
        } finally {
            if (input != null) {
                // added try catch for input output exception
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}