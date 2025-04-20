ffmpeg -i input<?php
/**
 * Extract all IPv4 addresses from the given text
 * 
 * @param string $text The text to search for IP addresses
 * @return array An array of all valid IPv4 addresses found in the text
 */
function extract_ip_addresses($text) {
    // Regular expression pattern for IPv4 addresses
    $ip_pattern = '/\b(?:\d{1,3}\.){3}\d{1,3}\b/';
    
    // Find all matches
    preg_match_all($ip_pattern, $text, $matches);
    
    // Get the list of IP addresses
    $ip_addresses = $matches[0];
    
    // Filter valid IP addresses (each octet <= 255)
    $valid_ips = [];
    foreach ($ip_addresses as $ip) {
        $octets = explode('.', $ip);
        $valid = true;
        
        foreach ($octets as $octet) {
            if ((int)$octet < 0 || (int)$octet > 255) {
                $valid = false;
                break;
            }
        }
        
        if ($valid) {
            $valid_ips[] = $ip;
        }
    }
    
    return $valid_ips;
}

// Example usage
$sample_text = "
    Server IP: 192.168.1.1
    Client connected from 10.0.0.55
    Invalid IPs: 999.888.777.666, 256.256.256.256
    Another valid IP: 172.16.254.1
";

$ips = extract_ip_addresses($sample_text);
echo "Found IP addresses:\n";
foreach ($ips as $ip) {
    echo "- $ip\n";
}
?>