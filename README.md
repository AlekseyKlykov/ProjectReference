<h1>Урок 12. Использование ссылок</h1>

<h4>
В рамках данного ДЗ была реализвана бд MySql по схеме https://github.com/Kichmarevitmo/Lesson-11.-Part-1.-Homework?tab=readme-ov-file#mybatis (Вариант 0, таблица с питомцами. при создании ID использовался тип int)<br>
Для замера производительности была использована функция получения одной записи по ID getById(). На ее основе была создана аналогичная функция cacheGetById(), но с приминением Soft reference и map для реализации кеша.<br>
Функция cacheGetById() проверяет существует ли объект в кеше, в случае отсутствия записи в кеш добалвяется полученная информация из БД, и возвращается результат пользователю, в противном случае объект возвращается сразу из кеша.<br>

Перед замером производительности была запущена лишняя команда getById()(т.к. было замечено, что первый вызов отрабатывает больше второго, третьего и т.д.).<br>
Первый вызов функции getById() отработал за 1104 мс, второй вызов этой же функции отработал за 3мс<br>
Далее была фузвана функция cacheGetById() которая отработала за 3мс, но при повторном вызове функция отработала уже 0 мс, т.к. необходимые данные уже лежали в кеше.<br>

Результат работы программы на скриншоте ниже 
![image](https://github.com/user-attachments/assets/1c6344d6-5ffa-4371-b74c-ddf9066f01aa)


Для исталяции MySql в Docker необходимо выполнить команду docker run --name PrjHibernate -p 3306:3306 -d alekseyklykov/prjmysqlforhibernate

</h4>
