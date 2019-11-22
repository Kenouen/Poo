package br.edu.ifpb;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;
import java.util.stream.Collectors;

public class ServidorSignos implements ObjetoRemotoSignos_IF{
    private Map<String, List<String>> mapasignos;
    private List<String> Frases;
    private Random r = new Random();

    public ServidorSignos() throws IOException {
        mapasignos = new HashMap<>();
        // Path p = Paths.get("files/Frases.txt");

        InputStream inputStream = ServidorSignos.class.getResourceAsStream("/files/Frases.txt");
        InputStreamReader inputStreamReader = new InputStreamReader( inputStream ); // ponte

        BufferedReader bufferedReader = new BufferedReader( inputStreamReader );

        Frases = bufferedReader.lines().collect(Collectors.toList());

        //BufferedInputStream bf = new BufferedInputStream(inputStream);
        //byte[] bytes = bf.readAllBytes();
        //String s = new String( bytes, StandardCharsets.UTF_8);
        //System.out.println(s);


        //  Frases = Files.readAllLines(p, Charset.defaultCharset());

        List<String> signos = Arrays.asList("Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem",
                                            "Libra", "Escorpião", "Sagitário", "Capricórnio", "Aquário", "Peixes");

        for (String signo : signos) {
            List<String> aux = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                aux.add(this.Frases.get(r.nextInt(this.Frases.size())));
            }

            mapasignos.put(signo, aux);
        }
    }

    public static void main(String[] args) {
        try {
            ServidorSignos a = new ServidorSignos();
            ObjetoRemotoSignos_IF stub = (ObjetoRemotoSignos_IF) UnicastRemoteObject.exportObject(a, 0);
            System.setProperty("java.rmi.server.hostname",args[0]);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("signos", stub);
            System.out.println("Servidor Pronto :)");
        }

        catch (IOException | AlreadyBoundException o) {
            System.err.println("Deu ruim :( Erro: " + o.toString());
        }
    }

    @Override
    public String getMsgSigno(String umsigno) throws RemoteException {
         return mapasignos.get(umsigno).toString().split(",")[r.nextInt(3)];
    }

}
