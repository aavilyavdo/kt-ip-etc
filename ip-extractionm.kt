package com.includehelp [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
import java.net.Inet4Address [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
import java.net.InetAddress [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
import java.net.NetworkInterface [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)

// Функция для поиска IP-адреса [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
fun getSystemIP(): String? { [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
    return try {
        var sysIP: String? [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
        val osName = System.getProperty("os.name") [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
        if (osName.contains("Windows")) {
            sysIP = InetAddress.getLocalHost().hostAddress [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
        } else {
            sysIP = getSystemIP4Linux("eth0") [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
            if (sysIP == null) {
                sysIP = getSystemIP4Linux("eth1") [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
                if (sysIP == null) {
                    sysIP = getSystemIP4Linux("eth2") [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
                    if (sysIP == null) {
                        sysIP = getSystemIP4Linux("usb0") [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
                    }
                }
            }
        }
        sysIP [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
    } catch (E: Exception) {
        System.err.println("System IP Exp : " + E.message) [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
        null [1](https://www.includehelp.com/kotlin/find-ip-address-of-windows-linux-system.aspx)
    }
}

