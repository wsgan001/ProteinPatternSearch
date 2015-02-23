package protka.main;

import java.io.IOException;

public class MetaMain {

  public enum Task {
    COMPUTE_STATS, FILTER_DAT_FEATURES, FILTER_ROWS, FASTA_AND_DAT_FILTER
  }

  public static void printHelp() {
    System.out.println("Usage: protPS <taskname> <settings.properties file path>");
    System.out.println("\t Available tasks are:");
    for (Task task : Task.values()) {
      System.out.println(" " + task.toString());
    }
  }

  public static void main(String args[]) throws IOException {
    if (args.length != 2) {
      MetaMain.printHelp();
      return;
    }
    String whichTaskStr = args[0];
    Task whichTask = Task.valueOf(whichTaskStr);
    String propFileName = args[1];
    String[] argsToPass = {propFileName};

    switch (whichTask) {
      case COMPUTE_STATS: ComputeHDStats.main(argsToPass); break;
      case FILTER_DAT_FEATURES: FilteringDat.main(argsToPass); break;
      case FILTER_ROWS: FilterRows.main(argsToPass); break;
      case FASTA_AND_DAT_FILTER: MainProteinFilter.main(argsToPass); break; 
      default: printHelp(); break;
    }
  }
  
}