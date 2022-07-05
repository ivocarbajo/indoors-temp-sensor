#include "wifi_connector.h"

const char* ssid = "Cody's LANd";
const char* password = "B_J_(a}m'tdh47Mp:2R";

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
