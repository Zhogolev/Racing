Racing [![Build Status](https://travis-ci.org/Zhogolev/Racing.svg?branch=master)](https://travis-ci.org/Zhogolev/Racing)&nbsp;
==========

## The task

  Консольное приложение на языке Java, которое симулирует гонки по кругу. В гонках участвуют разные типы транспортных средств: грузовики, легковушки и мотоциклы. Все транспортные средства стартуют одновременно, проходят один круг и останавливаются. Как только все они останавливаются, приложение выводит таблицу первенства и спрашивает пользователя, хочет ли он отправить их ещё на один круг.
***
  У каждого из транспортных средств есть своя скорость и вероятность прокола колеса. Когда колесо прокалывается, транспортное средство останавливается на какое-то время и сообщает о проколе в консоль.
***
  Перед началом движения каждое транспортное средство пишет в консоль свои параметры: скорость и вероятность прокола колеса. Дополнительно грузовик должен написать, какой у него вес груза, легковушка – сколько в ней людей, а мотоцикл – есть ли у него коляска. Во время движения каждое транспортное средство пишет, какое расстояние оно уже прошло. 
***
Количество и типы транспортных средств, их параметры и длина круга считываются из конфигурационного файла.  

## How to run 

```
Compile app in console :
-javac -sourcepath ./src -d bin src/com/company/main/Main.java
```

## Run

```
Command in console from root project to run the Race 
-java -classpath ./bin com/company/main/Main
```

## Before run

```
Copy "resources" folder from src/com/company/ to bin/com/company/ 
folder resources contain the config file RaceConfig.json
```

### About config file 

``` 
"distance"  mean lap distance 
"vehicals" in same file is an array of veh. for race.
```
