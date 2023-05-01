import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

public class Reader {

    String getCurrentDirectory() {
        return this.getClass().getClassLoader().getResource("").getPath();
    }

    public static void ReaderSearch(boolean vdd, String nomeP) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    var start = System.currentTimeMillis();

                    String path = new String();
                    String directoryName = new Reader().getCurrentDirectory();

                    if (directoryName.startsWith("/")) {
                        directoryName = directoryName.substring(1);
                    }

                    path = directoryName.replaceAll("/bin/", "") + "/src/Files";
                    var ff = new File(path);
                    File[] arquivos = ff.listFiles();

                    final List<String> listArquivos = new ArrayList<String>();

                    Boolean t = vdd;
                    for (File f : arquivos) {

                        if (t == true) {

                            listArquivos.add(f.toString());

                            t = false;
                            continue;
                        }
                        t = true;
                    }

                    for (String f : listArquivos) {

                        Path caminho = Paths.get(f);

                        List<String> texto = Files.readAllLines(caminho);

                        if (texto.contains(nomeP)) {
                            var Line = texto.indexOf(nomeP);

                            var fim = System.currentTimeMillis();
                            var segundos = (fim - start) / 1000;
                            var mili = fim - start;
                            System.out.println("Nome foi encontrado em: " + segundos + " segundos " + mili
                                    + " milissegundos | Na linha: "
                                    + (Line + 1));

                            System.exit(200);
                        }
                    }

                } catch (Exception e) {
                }
            }
        }).start();
    }

    public static void ReaderSearchNoP(String nomeP) {
        try {
            var start = System.currentTimeMillis();

            String path = new String();
            String directoryName = new Reader().getCurrentDirectory();

            if (directoryName.startsWith("/")) {
                directoryName = directoryName.substring(1);
            }

            path = directoryName.replaceAll("/bin/", "") + "/src/Files";
            var ff = new File(path);
            File[] arquivos = ff.listFiles();

            for (File f : arquivos) {
                Path caminho = Paths.get(f.toString());

                List<String> texto = Files.readAllLines(caminho);

                if (texto.contains(nomeP)) {
                    var Line = texto.indexOf(nomeP);

                    var fim = System.currentTimeMillis();
                    var segundos = (fim - start) / 1000;
                    var mili = fim - start;
                    System.out.println("Nome foi encontrado em: " + segundos + " segundos " + mili
                            + " milissegundos | Na linha: "
                            + (Line + 1));

                    System.exit(200);
                }
            }

        } catch (Exception e) {
        }
    }
}