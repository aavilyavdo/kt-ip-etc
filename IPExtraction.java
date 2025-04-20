package com.includehelp;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;

public class IPExtraction {
    
    // Function to find the IP address
    public static String getSystemIP() {
        try {
            String sysIP;
            String osName = System.getProperty("os.name");
            if (osName.contains("Windows")) {
                sysIP = InetAddress.getLocalHost().getHostAddress();
            } else {
                sysIP = getSystemIP4Linux("eth0");
                if (sysIP == null) {
                    sysIP = getSystemIP4Linux("eth1");
                    if (sysIP == null) {
                        sysIP = getSystemIP4Linux("eth2");
                        if (sysIP == null) {
                            sysIP = getSystemIP4Linux("usb0");
                        }
                    }
                }
            }
            return sysIP;
        } catch (Exception e) {
            System.err.println("System IP Exp : " + e.getMessage());
            return null;
        }
    }

    // Function to get IP address for Linux systems
    public static String getSystemIP4Linux(String netInterface) {
        try {
            NetworkInterface networkInterface = NetworkInterface.getByName(netInterface);
            if (networkInterface == null) {
                return null;
            }
            
            Enumeration<InetAddress> addresses = networkInterface.getInetAddresses();
            while (addresses.hasMoreElements()) {
                InetAddress address = addresses.nextElement();
                if (!address.isLoopbackAddress() && address instanceof Inet4Address) {
                    return address.getHostAddress();
                }
            }
        } catch (Exception e) {
            System.err.println("Linux IP Exp: " + e.getMessage());
        }
        return null;
    }
    
    // Example main method to test the functionality
    public static void main(String[] args) {
        String ip = getSystemIP();
        if (ip != null) {
            System.out.println("System IP Address: " + ip);
        } else {
            System.out.println("Could not determine IP address");
        }
    }
}



