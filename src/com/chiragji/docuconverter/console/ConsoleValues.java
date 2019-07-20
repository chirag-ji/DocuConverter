package com.chiragji.docuconverter.console;

import org.kohsuke.args4j.Option;

/**
 * This class defines the command line arguments
 *
 * @author Chirag Gupta (chirag-ji)
 */
public class ConsoleValues {
    @Option(name = "-input", aliases = {"-i", "-in"}, metaVar = "<path>",
            usage = "Specifies input file path")
    private String inputPath;

    @Option(name = "-output", aliases = {"-o", "-out"}, metaVar = "<path>",
            usage = "Specifies output file path")
    private String outPath;

    @Option(name = "-verbose", aliases = "-v", usage = "To see intermediate processing messages.")
    private boolean verbose;

    @Option(name = "-version", aliases = "-ver", usage = "View current Library Version")
    private boolean showVersion;

    @Option(name = "-help", aliases = "-h", usage = "Shows this message")
    private boolean showHelp;

    public String getInputPath() {
        return inputPath;
    }

    public String getOutPath() {
        return outPath;
    }

    public boolean isVerbose() {
        return verbose;
    }

    public boolean isShowVersion() {
        return showVersion;
    }

    public boolean isShowHelp() {
        return showHelp;
    }
}
