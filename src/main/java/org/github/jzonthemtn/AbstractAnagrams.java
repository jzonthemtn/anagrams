package org.github.jzonthemtn;

import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Scanner;

public abstract class AbstractAnagrams {

    public abstract List<String> find(final String word);

    public void read() {

        String word;

        while(true) {

            System.out.print("Enter a word: ");
            final Scanner scanner = new Scanner(System.in);
            word = scanner.nextLine();

            if(StringUtils.equals("exit", word)) {

                break;

            } else {

                final long startTime = System.currentTimeMillis();
                final List<String> anagrams = find(word);
                System.out.println("Anagram search took " + (System.currentTimeMillis() - startTime) + " ms");

                if (anagrams.size() > 0) {

                    System.out.println(String.join(", ", anagrams));

                } else {

                    System.out.println("No anagrams found for word " + word);

                }

            }

        }

    }

}
