package br.edu.ifpb;


import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ObjetoRemotoSignos_IF extends Remote
{
    public String getMsgSigno(String umsigno) throws RemoteException;
}
