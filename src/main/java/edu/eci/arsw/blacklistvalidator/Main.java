/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.blacklistvalidator;

import java.util.List;

/**
 *
 * @author hcadavid
 */
public class Main {
    public static void main(String a[]){
        HostBlackListsValidator hblv=new HostBlackListsValidator();
        /*List<Integer> blackListOcurrences=hblv.checkHost("200.24.34.55");
        System.out.println("The host was found in the following blacklists:"+blackListOcurrences);

        SearchIP s = new SearchIP(0, 100, "200.24.34.55");
        Thread t = new Thread(s);

        t.start();*/
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        /*System.out.println(s.getInstances());*/

        SearchByChunks.checkHosts( "200.24.34.55", 100);
    }
}