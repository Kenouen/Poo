package br.edu.ifpb;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.*;

public class ServidorSignos implements ObjetoRemotoSignos_IF{
    private Map<String, List<String>> mapasignos;
    private List<String> Frases;
    private Random r = new Random();

    public ServidorSignos() throws IOException {
        mapasignos = new HashMap<>();
        Frases = Files.readAllLines(Paths.get("files/Frases.txt"));

        List<String> signos = Arrays.asList("Áries", "Touro", "Gêmeos", "Câncer", "Leão", "Virgem",
                                            "Libra", "Escorpião", "Sagitário", "Capricórnio", "Aquário", "Peixes");

        for (String signo : signos) {
            List<String> aux = new ArrayList<>();

            for (int i = 0; i < 3; i++) {
                aux.add(Frases.get(r.nextInt(Frases.size())));
            }

            mapasignos.put(signo, aux);
        }
    }

    public static void main(String[] args) {
        try {
            ServidorSignos a = new ServidorSignos();
            ObjetoRemotoSignos_IF stub = (ObjetoRemotoSignos_IF) UnicastRemoteObject.exportObject(a, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("mensagem", stub);
        }

        catch (IOException | AlreadyBoundException o) {
            System.err.println("Deu ruim :(");
        }
    }

    @Override
    public String getMsgSigno(String umsigno) throws RemoteException {
         return mapasignos.get(umsigno).toString().split(",")[r.nextInt(3)];
    }

}
