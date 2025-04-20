import re

def extract_ip_addresses(text):
    """
    Extract all IPv4 addresses from the given text.
    
    Args:
        text (str): The text to search for IP addresses
        
    Returns:
        list: A list of all IPv4 addresses found in the text
    """
    # Regular expression pattern for IPv4 addresses
    ip_pattern = r'\b(?:\d{1,3}\.){3}\d{1,3}\b'
    
    # Find all matches
    ip_addresses = re.findall(ip_pattern, text)
    
    # Optional: Filter valid IP addresses (each octet <= 255)
    valid_ips = []
    for ip in ip_addresses:
        octets = ip.split('.')
        if all(0 <= int(octet) <= 255 for octet in octets):
            valid_ips.append(ip)
    
    return valid_ips