# PersistStateExample
Пример как использовать https://developer.android.com/reference/android/R.attr.html#persistableMode

Данные, которые вы сохраните таким способом, останутся у вас даже после перезагрузки девайса.

1. Установите android:persistableMode="persistAcrossReboots" в манифесте для активити
2. Используйте перегруженные методы у активити, в которых есть android.os.PersistableBundle
