package com.chiragji.docuconverter;

import com.chiragji.docuconverter.api.ConvertToType;
import com.chiragji.docuconverter.api.DocuConverter;
import com.chiragji.docuconverter.api.DocumentType;
import com.chiragji.docuconverter.console.ConsoleValues;
import com.chiragji.docuconverter.exceptions.DocuConverterException;
import org.kohsuke.args4j.CmdLineParser;

import java.io.File;
import java.nio.file.Files;

/**
 * This is the entry point for the application that interprets the console arguments
 *
 * @author Chirag Gupta (chirag-ji)
 */
public class Bootstrap {
    public static void main(String... args) throws Exception {
        processConsoleArgs(args);
    }

    private static void processConsoleArgs(String... cmdArgs) throws Exception {
        ConsoleValues consoleValues = new ConsoleValues();
        CmdLineParser cmdLineParser = new CmdLineParser(consoleValues);
        if (cmdArgs.length == 0) {
            printVersion();
            cmdLineParser.printUsage(System.out);
            System.exit(0);
        }
        cmdLineParser.parseArgument(cmdArgs);
        if (consoleValues.isShowVersion()) {
            printVersion();
            System.exit(0);
        } else if (consoleValues.isShowHelp()) {
            printVersion();
            cmdLineParser.printUsage(System.out);
            System.exit(0);
        }
        long start = System.currentTimeMillis();
        String inputFile = consoleValues.getInputPath();
        String outputFile = consoleValues.getOutPath();
        if (inputFile == null || inputFile.trim().isEmpty())
            throw new IllegalArgumentException("Input file path not defined");
        else if (outputFile == null || outputFile.trim().isEmpty())
            throw new IllegalArgumentException("Output file path not defined");
        File inFile = new File(consoleValues.getInputPath());
        File outFile = new File(consoleValues.getOutPath());
        DocumentType inType = getDocumentType(inFile);
        ConvertToType toType = getConvertToType(outFile);
        DocuConverter docuConverter = DocuConverter.getConverter(Files.newInputStream(inFile.toPath()), inType, toType);
        docuConverter.setVerbose(consoleValues.isVerbose());
        docuConverter.convertIn(Files.newOutputStream(outFile.toPath()));
        long total = System.currentTimeMillis() - start;
        System.out.println("File conversion succeed in " + total + " ms");
    }

    private static DocumentType getDocumentType(File inFile) throws DocuConverterException {
        String extension = getExtension(inFile);
        for (DocumentType documentType : DocumentType.values()) {
            if (documentType.name().equalsIgnoreCase(extension))
                return documentType;
        }
        throw new DocuConverterException("Unsupported input type: " + extension);
    }

    private static ConvertToType getConvertToType(File outFile) throws DocuConverterException {
        String extension = getExtension(outFile);
        for (ConvertToType convertToType : ConvertToType.values()) {
            if (convertToType.name().equalsIgnoreCase(extension))
                return convertToType;
        }
        throw new DocuConverterException("Unsupported input type: " + extension);
    }

    private static String getExtension(File file) {
        if (file.isDirectory())
            throw new IllegalArgumentException("File was expected but directory supplied");
        String fileName = file.getName();
        int idx = fileName.lastIndexOf('.');
        return fileName.substring(idx + 1);
    }

    private static void printVersion() {
        System.out.println(BuildConfig.APP_NAME + " [Version " + BuildConfig.BUILD + "]\nCopyright (c) " +
                BuildConfig.COPYRIGHT_YEAR + " Chirag Gupta (https://github.com/chirag-ji) under MIT Licence\n");
    }
}
