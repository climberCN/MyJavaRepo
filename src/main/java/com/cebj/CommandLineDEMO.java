package com.cebj;

import org.apache.commons.cli.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author zjh
 * @version V1.0
 * @Package org.ceb
 * @date 2020/8/9 0009 11:58
 */
public class CommandLineDEMO {
    private static Options OPTIONS = new Options();
    private static CommandLine commandLine;
    private static String HELP_STRING = null;

    public static void main(String[] args) {
        posixParseCLI(args);
    }

    public static void posixParseCLI(String[] args) {

        Options options = new Options();
        options.addOption("h", "help", false, "print options' information");
        options.addOption("d", "database", true, "name of a database");
        options.addOption("t", true, "name of a table");

        Option filesOption = OptionBuilder.withArgName("args")
                .withLongOpt("files")
                .hasArgs()
                .withDescription("file names")
                .create("f");
        options.addOption(filesOption);

        // hasArgs()指定后跟参数值得个数
        Option property = OptionBuilder.withArgName("property=name")
                .hasArgs()
                .withValueSeparator()
                .withDescription("use value for a property")
                .create("D");
        options.addOption(property);

        CommandLineParser parser = new PosixParser();
        try {
            CommandLine cli = parser.parse(options, args);
            if (cli.hasOption("h")) {
                HelpFormatter hf = new HelpFormatter();
                hf.printHelp("Options", options);
            } else {
                String database = cli.getOptionValue("d");
                System.out.println("database: " + database);
                String table = cli.getOptionValue("t");
                System.out.println("table: " + table);
                String[] files = cli.getOptionValues("f");
                System.out.println("files: " + Arrays.asList(files));

                Properties properties = cli.getOptionProperties("D");
                String ext = properties.getProperty("ext");
                System.out.println("property ext = " + ext);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        private static String getHelpString() {
        if (HELP_STRING == null) {
            HelpFormatter helpFormatter = new HelpFormatter();

            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintWriter printWriter = new PrintWriter(byteArrayOutputStream);
            helpFormatter.printHelp(printWriter, HelpFormatter.DEFAULT_WIDTH, "scp -help", null,
                    OPTIONS, HelpFormatter.DEFAULT_LEFT_PAD, HelpFormatter.DEFAULT_DESC_PAD, null);
            printWriter.flush();
            HELP_STRING = new String(byteArrayOutputStream.toByteArray());
            printWriter.close();
        }
        return HELP_STRING;
    }
}
