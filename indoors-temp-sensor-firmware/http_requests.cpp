#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClient.h>

int sendPostReq(String address, String json) {
  if (WiFi.status() == WL_CONNECTED) {
    WiFiClient client;
    HTTPClient http;

    // Your Domain name with URL path or IP address with path
    http.begin(client, address);
    http.addHeader("Content-Type", "application/json");

    // Send HTTP GET request
    int httpResponseCode = http.POST(json);
    
    http.end();

    return 0;
  
  } else {
    Serial.println("WiFi Disconnected");
    return 0;
  }
}
