# Втора лабораториска вежба – Софтверско инженерство 2026

**Име:** Леонид Арабаџиев  
**Број на индекс:** 236061

---

## Control Flow Graph

### searchBookByTitle
<img width="691" height="972" alt="searchBookByTitle drawio" src="https://github.com/user-attachments/assets/fab35c0c-6c52-477b-97c9-643ab2e26fdb" />

### borrowBook
<img width="691" height="982" alt="borrowBook drawio" src="https://github.com/user-attachments/assets/d7e5ea61-64f1-405c-9d3a-afe43c9b35c0" />

---

## Цикломатска комплексност

### searchBookByTitle
Предикатни јазли: N2 (title.isEmpty), N5 (for loop), N6 (title matches && !isBorrowed), N8 (results.isEmpty)  
P = 4 → M = P + 1 = **5**

### borrowBook
Предикатни јазли: N2 (title.isEmpty || author.isEmpty), N4 (for loop), N5 (title && author matches), N6 (!isBorrowed)  
P = 4 → M = P + 1 = **5**

---

## Тест случаи – Every Statement (searchBookByTitle)

| Тест | Опис | Покриени линии |
|------|------|---------------|
| T1 | title е празен → IllegalArgumentException | S1, S2 |
| T2 | книгата е изнајмена → null | S1, S3, S4, S5, S7, S8 |
| T3 | книгата е слободна → листа со резултати | S1, S3, S4, S5, S6, S7, S9 |

Минимален број на тест случаи: **3**

---

## Тест случаи – Every Branch (borrowBook)

| Тест | Опис | Покриени гранки |
|------|------|----------------|
| T1 | title е празен → IllegalArgumentException | B1 |
| T2 | книгата не постои → RuntimeException | B2, B3, B4 |
| T3 | книгата е слободна → успешно | B2, B4, B5, B6 |
| T4 | книгата е изнајмена → RuntimeException | B2, B4, B5, B7 |

Минимален број на тест случаи: **4**

---

## Тест случаи – Multiple Condition

### searchBookByTitle – if (title matches && !isBorrowed)

| Тест | titleMatches | !isBorrowed | Резултат |
|------|-------------|-------------|---------|
| T1 | false | false | null |
| T2 | false | true | null |
| T3 | true | false | null |
| T4 | true | true | листа |

### borrowBook – if (title.isEmpty() || author.isEmpty())

| Тест | title.isEmpty() | author.isEmpty() | Резултат |
|------|----------------|-----------------|---------|
| T1 | false | false | продолжи |
| T2 | false | true | throw |
| T3 | true | false | throw |
| T4 | true | true | throw |

Минимален број на тест случаи: **4**
