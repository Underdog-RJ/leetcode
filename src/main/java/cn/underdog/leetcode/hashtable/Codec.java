package cn.underdog.leetcode.hashtable;

import java.util.HashMap;

public class Codec {
    HashMap<String, String> map = new HashMap<>();
    int i1 = 0;

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String shortUrl = String.valueOf(i1++);
        map.put(shortUrl, longUrl);
        return shortUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return map.getOrDefault(shortUrl, "");
    }
}