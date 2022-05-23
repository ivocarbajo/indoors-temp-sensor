#include "DHT.h"
#include <ArduinoJson.h>
#include <ESP8266WiFi.h>
#include <ESP8266HTTPClient.h>
#include <WiFiClient.h>

#define DHTPIN 4     
#define DHTTYPE DHT11

DynamicJsonDocument doc(1024);
DHT dht(DHTPIN, DHTTYPE);

const char* ssid = "Cody's LANd";
const char* password = "B_J_(a}m'tdh47Mp:2R";

//Your Domain name with URL path or IP address with path
String baseUrl = "http://10.1.0.1:8080/api/";
bool firstTempRetrived = false;

DynamicJsonDocument temperatureReading(1024);

unsigned long lastTime = 0;
unsigned long timerDelay = 5*60*1000;

void setup() {
  Serial.begin(115200);

  WiFi.begin(ssid, password);
  Serial.println("Connecting");
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.print("Connected to WiFi network with IP Address: ");
  Serial.println(WiFi.localIP());

  Serial.println("Timer set to 5 seconds (timerDelay variable), it will take 5 seconds before publishing the first reading.");
}

void loop() {
  // Send an HTTP POST request depending on timerDelay
  getTemperature();
  if ((millis() - lastTime) > timerDelay && firstTempRetrived) {
    Serial.println(sendPostReq());
    lastTime = millis();
  }
}

void getTemperature(){
  int humidity = dht.readHumidity();
  int temperature = dht.readTemperature();
  if (humidity != 0 && temperature != 0 && humidity < 100 && temperature < 100) {
    temperatureReading["humidity"] = humidity;
    temperatureReading["temperature"] = temperature;
    Serial.println(temperature);
    if (!firstTempRetrived) {
      firstTempRetrived = true;
    }
  }
}

int sendPostReq() {
  if (WiFi.status() == WL_CONNECTED) {
    WiFiClient client;
    HTTPClient http;

    String serverPath = baseUrl + "reading";

    // Your Domain name with URL path or IP address with path
    http.begin(client, serverPath.c_str());

    // Send HTTP GET request
    http.addHeader("Content-Type", "application/json");
    String parsedReading = "";
    serializeJson(temperatureReading, parsedReading);
    int httpResponseCode = http.POST(parsedReading);

    http.end();
    return httpResponseCode;
  }
  else {
    Serial.println("WiFi Disconnected");
  }
  
  return 999;
}
