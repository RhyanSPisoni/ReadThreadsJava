import java.util.Scanner;

public class App {

    public static void main(String[] args) throws Exception {

        try (Scanner in = new Scanner(System.in)) {
            System.out.println("\n Qual o nome que deseja procurar?");
            String nome = in.nextLine();

            System.out.println("\n Deseja continuar em qual modo?");
            System.out.println("\n 1 - Paralelo");
            System.out.println("\n 2 - Sincronco");
            String modo = in.nextLine();
            switch (modo) {
                case "1":
                    Reader.ReaderSearch(true, nome);
                    Reader.ReaderSearch(false, nome);
                    break;
                case "2":
                    Reader.ReaderSearchNoP(nome);
                    break;
                default:
                    break;
            }
        }

    }
}