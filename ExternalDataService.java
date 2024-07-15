public class ExternalDataService {
    private static final String WEATHER_API_URL = "https://api.weather.com/v3/weather/forecast";

    public void fetchWeatherData(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(WEATHER_API_URL + "?location=" + location)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    String responseData = response.body().string();
                    callback.onSuccess(responseData);
                } else {
                    callback.onFailure(new Exception("Failed to fetch weather data"));
                }
            }
        });
    }
}
