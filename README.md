DatePickerWheel  v1.0
==================
[Image](capture/screen.png)

Library base in [android-wheel-datepicker](https://bitbucket.org/igor_kostromin/android-wheel-datepicker/wiki/Home)

# How to use

Download the [library DatePickerWheel](DatePickerWheel-v1.0.aar) and import how module in Android Studio, then add to dependencies.

# In a dialog:

Only call R.layout.datepickerwheel to set view.

```java
    // Declare 
    private WheelDatePicker mDatePicker;
    
    ...
    
    public void createDialog() {
      final Dialog dialog = new Dialog(MainActivity.this);
      dialog.setContentView(R.layout.datepickerwheel);
      mDatePicker = (WheelDatePicker) dialog.findViewById(R.id.datepicker);
      mDatePicker.setLocale(locale.US); // Too new Locale("es", "ES")  (Only english and spanish)
      mDatePicker.setVisibleItems(5);
      mDatePicker.setMinMaxYears(1970, 2015);  //Range
      mDatePicker.setDay(10);
      mDatePicker.setMonth(8);
      mDatePicker.setYear(2013);
      mDatePicker.addDateChangedListener(new WheelDatePicker.IDateChangedListener() {
          @Override
          public void onChanged(WheelDatePicker sender, int oldDay, int oldMonth, int oldYear, int day, int month, int year) {{{
              Toast.makeText(getApplicationContext(), "Date: " + day + "/" + month + "/" + year, Toast.LENGTH_SHORT).show();
          }
      });

      dialog.show();
    }
```

Same logic for use with LayoutInflater, and add in a layout to use:

```xml
  <include
      android:id="@+id/datepicker"
      layout="@layout/datepickerwheel"/>
```
