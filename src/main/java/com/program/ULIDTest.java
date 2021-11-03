package com.program;

import java.util.concurrent.ThreadLocalRandom;

import io.azam.ulidj.ULID;

/**
 * https://github.com/ulid/spec
 */
public class ULIDTest {

    public static void main(String[] args) {
        System.out.println("ULID....");
        String ulid1 = ULID.random();
        String ulid2 = ULID.random(ThreadLocalRandom.current());
        System.out.println(ulid1);
        System.out.println(ulid2);
    }
}
