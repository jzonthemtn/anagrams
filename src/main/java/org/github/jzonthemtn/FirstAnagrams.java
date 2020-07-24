package org.github.jzonthemtn;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class FirstAnagrams extends AbstractAnagrams {

    final private List<String> dictionary;

    public static void main(String[] args) throws IOException {

        final String dictionaryFile = args[0];
        final FirstAnagrams firstAnagrams = new FirstAnagrams(dictionaryFile);
        firstAnagrams.read();

    }

    public FirstAnagrams(final String dictionaryFile) throws IOException {

        final long startTime = System.currentTimeMillis();
        dictionary = FileUtils.readLines(new File(dictionaryFile), Charset.defaultCharset());

        System.out.println("Loaded " + dictionary.size() + " in " + (System.currentTimeMillis() - startTime) + " ms");

    }

    @Override
    public List<String> find(final String word) {

        final List<String> anagrams = new LinkedList<>();

        final List<Character> letters = word.chars().mapToObj(e -> (char)e).collect(Collectors.toList());
        final Collection<List<Character>> permutations = CollectionUtils.permutations(letters);

        System.out.println("permutations = " + permutations.size());

        for(List<Character> characters : permutations) {

            final StringBuilder sb = new StringBuilder();
            for(Character c : characters) {
                sb.append(c);
            }

            final String candidate = sb.toString();

            if(dictionary.contains(candidate)) {
                anagrams.add(candidate);
            }

        }

        return anagrams;

    }



}
