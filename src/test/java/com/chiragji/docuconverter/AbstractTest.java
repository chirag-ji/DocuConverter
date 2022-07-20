package com.chiragji.docuconverter;

import org.apache.commons.io.FileUtils;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AbstractTest {

    private static final String TEST_DIR = "src/test/resources/";
    private static final String TEST_IN_DIR = TEST_DIR + "in";
    private static final String TEST_OUT_DIR = TEST_DIR + "out";

    protected File getTestInFile(@NonNull String name) {
        return new File(TEST_IN_DIR, name);
    }

    protected File getTestOutFile(@NonNull String name) {
        return new File(TEST_OUT_DIR, name);
    }

    @BeforeAll
    private static void initTests() {
        File dir = new File(TEST_OUT_DIR);
        dir.mkdirs();
    }

    @AfterAll
    private static void cleanupCtx() {
        try {
            FileUtils.forceDelete(new File(TEST_OUT_DIR));
        } catch (IOException e) {
            System.out.println("Fail to delete file: " + TEST_OUT_DIR);
        }
    }

    protected void assertFileExists(File outFile) {
        assertTrue(outFile.exists(), "Assert that out file exists");
    }
}
