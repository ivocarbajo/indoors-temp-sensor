#ifndef DHT_FUNCTIONS
#define DHT_FUNCTIONS

class DHT_Reading {
    private:
        float temperature;
        float humidity;
    public:
        DHT_Reading(float _temperature, float _humidity);
        float getTemperature();
        float getHumidity();
};

DHT_Reading getReading();

#endif