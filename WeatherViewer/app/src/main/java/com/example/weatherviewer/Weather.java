package com.example.weatherviewer;


import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class Weather {
    public final String dayOfWeek;
    public final String minTemp;
    public final String maxTemp;
    public final String humidity;
    public final String description;
    public final String iconURL;
    public Weather(long timeStamp, double minTemp, double maxTemp,double humidity, String description, String iconName) {
             // NumberFormat для форматирования температур в целое число
             NumberFormat numberFormat = NumberFormat.getInstance();
             numberFormat.setMaximumFractionDigits(0);
             this.dayOfWeek = convertTimeStampToDay(timeStamp);
             this.minTemp = numberFormat.format(minTemp) + "\u00B0F";
             this.maxTemp = numberFormat.format(maxTemp) + "\u00B0F";
             this.humidity = NumberFormat.getPercentInstance().format(humidity / 100.0);
             this.description = description;
             this.iconURL = "http://openweathermap.org/img/w/" + iconName + ".png";
         }
    // Преобразование временной метки в название дня недели (Monday, ...)
    private static String convertTimeStampToDay(long timeStamp) {
             Calendar calendar = Calendar.getInstance(); // Объект Calendar
             calendar.setTimeInMillis(timeStamp * 1000); // Получение времени
             TimeZone tz = TimeZone.getDefault(); // Часовой пояс устройства

             // Поправка на часовой пояс устройства
             calendar.add(Calendar.MILLISECOND,
                     tz.getOffset(calendar.getTimeInMillis()));

             // Объект SimpleDateFormat, возвращающий название дня недели
            SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE");
            return dateFormatter.format(calendar.getTime());
         }
    }
