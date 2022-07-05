#include "DHT.h"
#include "dht_functions.h"
#define DHTPIN 4     
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);


DHT_Reading::DHT_Reading(float _temperature, float _humidity) {
    temperature = _temperature;
    humidity = _humidity;
}

float DHT_Reading::getTemperature() {
    return temperature;
}

float DHT_Reading::getHumidity() {
    return humidity;
}

DHT_Reading getReading() {
    return DHT_Reading(dht.readTemperature(), dht.readHumidity());
}