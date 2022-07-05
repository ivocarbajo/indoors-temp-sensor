#include "wifi_connector.h"
#include "http_requests.h"
#include "dht_functions.h"
#include <ArduinoJson.h>

#define BASE_URL "http://10.1.0.1:8080/api/"

StaticJsonDocument<200> jsonBuffer;

//Your Domain name with URL path or IP address with path

void setup() {
  Serial.begin(115200);
  connectToWifi();
}

void loop() {
  static unsigned long lastTime = 0;
  static unsigned long timerDelay = 5*60*1000;
  static bool firstTempRetrived = false;
  static bool firstRequestSent = false;


  // Send an HTTP POST request depending on timerDelay
  DHT_Reading dht_reading = getReading();
  jsonBuffer["temperature"] = dht_reading.getTemperature();
  jsonBuffer["humidity"] = dht_reading.getHumidity();

  firstTempRetrived = true;
  if (((millis() - lastTime) > timerDelay && firstTempRetrived) || (!firstRequestSent && firstTempRetrived)) {
    String reading;
    serializeJsonPretty(jsonBuffer, reading);
    Serial.println(reading);
    Serial.println(sendPostReq(BASE_URL "reading", reading));
    firstRequestSent = true;
    lastTime = millis();
  }
}