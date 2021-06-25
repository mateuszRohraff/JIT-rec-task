Zadanie zostało rozwiązane poprzez stworzenie prostego API, które pozwala na na dodawanie, aktualizowanie i usuwnie Pokemonów z bazyt danych.

Wybrałem bazę H2 jako, że jest to najprostsze i najszybsze rozwiązanie jakie znam. Zapytania do bazy tworzę za pomocą frameworka MyBatis.

API udostępnia cztery endpointy GET. Kolejno: 
- pokemon/all - wyświetla wszystkie zawarte w bazie pokemony
- pokemon?pokemonId="?" wyświetla pokemona o wybranym id
- pokemon/type?type="?" wyświetla wszystkie pokemony o podanym type (jako, że typy pokemonów są skońćzone, aplikacja sprawdza czy dany typ istnieje)
- pokemon/name?name="?" wyświetla wszystkie pokemony o podanym imieniu

API zawiera endpoint do dodawania pokemonów
- pokemon/add?name="?"&type="?" dodoaje do bazy Pokemona o podanej nazwie i typie (ID jest automatycznie incrementowane, typ jest walidowany)

API zawiera endpoint do aktualizowania pokemonów
-pokemon?id="?"&name="?"&type"?" podanie Id jest obowiązkowe natomiast type i name nie. Jeśli podamy Type to jest on walidowany.

Api zawiera endpoint do usuwania 
-pokemon?id="?" jeśli istnieje to usuwany jest pokemon o danym ID.

Niestety z powodu braku czasu musiałem się ograniczyć do wykonania jednego dodatkowego podpunktu. Mam nadzięję, że poprawność wykonanego 
zadania pozwoli na udział w dalszym procesie rekrutacji, natomiast jeśli oczekują Państwo wykonania zadania w większym zakresie,
jestem chętny do podjęcia się wyzwania przez weekend. 