# Ответы на вопросы задания №7-13 по финальной работе (нумерация в соответствии с файлом с 15 задачами)

## Задание №7: 
В подключенном MySQL репозитории создать базу данных “Друзья
человека”

### Ответ №7: Создание базы данных Human_Friends (в Linux)

```sh
sudo mysql
CREATE DATABASE Human_Friends;
USE Human_Friends;
```

## Задание №8: 
В подключенном MySQL репозитории создать базу данных “Друзья
человека”

### Ответ №8-1:Создание таблицы Pets

```sh
CREATE TABLE Pets (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(30),
    Type VARCHAR(20),
    BirthDate DATE,
    Commands TEXT);
```
### Ответ №8-2:Создание таблицы Packs
```sh
CREATE TABLE PackAnimals (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(30),
    Type VARCHAR(20),
    BirthDate DATE,
    Commands TEXT);
```
## Задание №9: 
Заполнить низкоуровневые таблицы именами(животных), командами
которые они выполняют и датами рождения

### Ответ №9-1: Заполнение таблицы Pets
```sh
INSERT INTO Pets (Name, Type, BirthDate, Commands) VALUES
('Maks', 'Dog', '2024-03-05', 'Gav-gav'),
('Martin', 'Cat', '2023-04-26', 'Myau'),
('Verblyud', 'Hamster', '2023-01-12', 'Go'),
('Tuzik', 'Dog', '2022-11-19', 'Sit, Gav-gav'),
('Laura', 'Cat', '2022-07-01', 'Sit, Myau'),
('Rembo', 'Hamster', '2023-01-04', 'Sit'),
('Layka', 'Dog', '2024-09-16', 'Sit'),
('Kleopatra', 'Cat', '2019-11-05', 'Myau, Sit'),
('Sahara', 'Hamster', '2023-11-27', 'Sit, go');
```

### Ответ №9-2: Заполнение таблицы Pets
```sh
INSERT INTO Packs (Name, Type, BirthDate, Commands) VALUES
('Skakun', 'Horse', '2020-08-01', 'Sit'),
('Kizilkum', 'Camel', '2017-01-27', 'Walk, Sit'),
('Vasya', 'Donkey', '2018-01-11', 'Sit'),
('Izabella', 'Horse', '2018-08-09', 'Run'),
('Karakum', 'Camel', '2024-03-08', 'Walk, Run');
```

## Задание №10:
Удалив из таблицы верблюдов, т.к. верблюдов решили перевезти в другой питомник на зимовку. Объединить таблицы лошади, и ослы в одну таблицу.

### Ответ №10-1: Удаление верблюдов
```sh
DELETE FROM Packs WHERE Type = 'Camel';
```
### Ответ №10-2: Объединение таблиц c лошадmvb и ослами
```sh
CREATE TABLE Joined_Animals AS
SELECT ID, Name, Type, BirthDate, Commands FROM Packs WHERE Type IN ('Horse', 'Donkey');
```
## Задание №11:
Создать новую таблицу “молодые животные” в которую попадут все
животные старше 1 года, но младше 3 лет и в отдельном столбце с точностью до месяца подсчитать возраст животных в новой таблице.

### Ответ №11: Создание новой таблицы с животными  от 1 года до 3 лет, а также создание нового столбца с вычислением возраста с точностью до месяца
```sh
CREATE TABLE Young_Animals AS
SELECT ID, Name, Type, BirthDate, Commands,
       TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) AS AgeMonths
FROM Pets
WHERE TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) BETWEEN 1 AND 3;
```

## Задание №12-13:
Объединить все таблицы в одну, при этом сохраняя поля, указывающие на прошлую принадлежность к старым таблицам. Создать класс с Инкапсуляцией методов и наследованием по диаграмме.

### Ответ №12-13:Объединение все[] таблиц в одну

```sh
CREATE TABLE All_Animals AS
SELECT ID, Name, Type, BirthDate, Commands, 'Pets' AS Source
FROM Pets
UNION ALL
SELECT ID, Name, Type, BirthDate, Commands, 'Packs' AS Source
FROM Packs
WHERE Type IN ('Horse', 'Donkey');
```
