function getIP(){
    import socket
def get_ip():
    return socket.gethostbyname(socket.gethostname())}
print(getIP());
function spoofIP(){
    import socket
def get_ip():
    return socket.gethostbyname(socket.gethostname())}
print(getIP());
from scapy.all import IP, TCP, send

def spoof_ip_packet(source_ip, destination_ip, destination_port=80):
    # Create an IP packet with a spoofed source address
    ip_packet = IP(src=source_ip, dst=destination_ip)
    
    # Add a TCP layer (for example, targeting port 80)
    tcp_packet = TCP(dport=destination_port)
    
    # Combine the layers and send the packet
    packet = ip_packet/tcp_packet
    send(packet)
    
    return f"Sent spoofed packet from {source_ip} to {destination_ip}:{destination_port}"
