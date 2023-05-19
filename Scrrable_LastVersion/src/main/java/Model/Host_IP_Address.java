package Model;

import java.net.*;

public class Host_IP_Address { /* Save the IP address of host  */

   private static String hostIp;

    public Host_IP_Address() throws SocketException {
       hostIp = findLocalIP();
    }

    public String findLocalIP() throws SocketException {
        NetworkInterface wifiInterface = NetworkInterface.getByName("en0");
        InetAddress wifiAddress = null;
        if (wifiInterface != null) {
            for (InterfaceAddress address : wifiInterface.getInterfaceAddresses()) {
                if (address.getAddress().isLinkLocalAddress()) {
                    continue;
                }
                if (!(address.getAddress() instanceof Inet4Address)) {
                    continue;
                }
                wifiAddress = address.getAddress();
                break;
            }
        }
        if (wifiAddress != null) {
//            System.out.println("Local host Wi-Fi IP address: " + wifiAddress.getHostAddress());
            hostIp = wifiAddress.getHostAddress();

        } else {
            System.out.println("Local host Wi-Fi IP address not found");
            hostIp = null;
        }
        return hostIp;

    }

    public String getHostIp(){ return hostIp;}
}
