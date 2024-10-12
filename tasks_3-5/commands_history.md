# Ответы на задания №№3-5 по финальной работе (нумерация в соответствии с файлом с 15 задачами)

## Задание №3: 
Подключить дополнительный репозиторий MySQL. Установить любой пакет
из этого репозитория.

### Ответ №3-1: Подключение репозитория MySQL и установка MySQL
```sh
sudo apt update
sudo apt install software-properties-common
sudo add-apt-repository 'deb http://repo.mysql.com/apt/ubuntu/ focal mysql-8.0'
sudo apt update
sudo apt install mysql-server
```

### Ответ №3-2:Установка пакета из дополнительного репозитория
```sh
sudo apt install mysql-client
```

## Задание №4:
Установить и удалить deb-пакет с помощью dpkg.

### Ответ №4-1: Установка deb-пакета
```sh
sudo apt-get install curl
```

### Ответ №4-2: Проверка установки deb-пакета
```sh
dpkg -l | grep curl
```

### Ответ №4-3: Удаление deb-пакета
```sh
sudo dpkg -r curl
```

### Ответ №4-4: Полное удаление deb-пакета
```sh
sudo dpkg -P curl
```

### Ответ №4-5: Проверка осуществлено ли удаление deb-пакета
```sh
dpkg -l | grep curl
```
## Задание №5: Выложить историю команд в терминале ubuntu
### Ответ №5-1: Сохранение истории использования команд в файл commands_history.txt
```sh
history > commands_history.txt
```