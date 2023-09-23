# Учебный проект. UI-тесты для веб-приложения Stellar Burgers
Протестировано веб-приложение [Stellar Burgers](https://stellarburgers.nomoreparties.site/).

Стэк:
- Java 11
- Selenium 4.11.0
- JUnit 4.13.2
- Allure 2.22.2
- RestAssured 5.3.1
## Что было сделано
1. Элементы, использованные в тестах описаны с помощью Page Object
2. Тесты запускаются в 3-х браузерах: Google Chrome, Firefox и Яндекс.Браузере
3. Подключен Allure-отчёт
4. Тесты разделены по тематике или функциональности. Для тестов созданы отдельные классы
5. Нужные тестовые данные создаются перед тестом и удаляются после того, как он выполнится
6. Если для теста нужен тестовый юзер, он создаётся с помощью API
7. Сделан Allure-отчёт. Отчёт добавлен в пул-реквест
## Тест-кейсы
### Регистрация
- Успешная регистрация
- Ошибка для некорректного пароля. Минимальный пароль — шесть символов.
### Вход 
- вход по кнопке «Войти в аккаунт» на главной
- вход через кнопку «Личный кабинет»
- вход через кнопку в форме регистрации
- вход через кнопку в форме восстановления пароля
### Переход в личный кабинет 
- переход по клику на «Личный кабинет»
- переход из личного кабинета в конструктор 
- переход по клику на «Конструктор» и на логотип Stellar Burgers
### Выход из аккаунта
- выход по кнопке «Выйти» в личном кабинете
### Раздел «Конструктор»
Переходы к разделам:
- «Булки»
- «Соусы»
- «Начинки»
