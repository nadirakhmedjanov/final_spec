package model.package_scanner;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PackageScanner {
    private String packageName;

    public PackageScanner(String packageName) {
        this.packageName = packageName;
    }

    public List<String> getSimpleClassNamesInLastPackages() {
        List<String> simpleClassNames = new ArrayList<>();
        String path = packageName.replace('.', '/');

        try {
            URL packageURL = Thread.currentThread().getContextClassLoader().getResource(path);

            if (packageURL != null) {
                File directory = new File(packageURL.getFile());
                if (directory.exists()) {
                    findSimpleClassNamesInLastPackages(directory, packageName, simpleClassNames);
                }
            }
        } catch (Exception e) {
            // Print stack trace for debugging and give a user-friendly message
            System.err.println("Error while scanning package: " + e.getMessage());
            e.printStackTrace();
        }

        return simpleClassNames;
    }

    private void findSimpleClassNamesInLastPackages(File directory, String packageName, List<String> simpleClassNames) {
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        boolean hasSubPackages = false;

        for (File file : files) {
            if (file.isDirectory()) {
                hasSubPackages = true;
                findSimpleClassNamesInLastPackages(file, packageName + "." + file.getName(), simpleClassNames);
            }
        }

        if (!hasSubPackages) {
            for (File file : files) {
                if (file.getName().endsWith(".class")) {
                    String fullClassName = packageName + '.' + file.getName().substring(0, file.getName().length() - 6);
                    String simpleClassName = fullClassName.substring(fullClassName.lastIndexOf('.') + 1);
                    simpleClassNames.add(simpleClassName);
                }
            }
        }
    }
}
