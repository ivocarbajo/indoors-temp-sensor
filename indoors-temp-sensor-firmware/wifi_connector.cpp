#include "wifi_connector.h"

const char* ssid = "Cody's LANd Guest";
const char* password = "GordonFreeman";

void connectToWifi(){
  WiFi.begin(ssid, password);
  Serial.println("Connecting");
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to WiFi network with IP Address: ");
  Serial.println(WiFi.localIP());
}
