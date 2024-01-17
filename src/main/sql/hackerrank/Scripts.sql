--05/01/2024
--https://www.hackerrank.com/challenges/weather-observation-station-5/problem
SELECT CITY, length(CITY)
FROM STATION
WHERE length(CITY) = (SELECT MIN(LENGTH(CITY)) FROM STATION)
ORDER BY CITY limit 1;

SELECT CITY, LENGTH(CITY)
FROM STATION
WHERE length(CITY) = (SELECT MAX(LENGTH(CITY)) FROM STATION)
ORDER BY CITY limit 1;


--05/01/2024
--https://www.hackerrank.com/challenges/weather-observation-station-2/problem?isFullScreen=true
SELECT ROUND(SUM(LAT_N), 2),
       ROUND(SUM(LONG_W), 2)
FROM STATION;


--05/01/2024
--https://www.hackerrank.com/challenges/revising-aggregations-the-average-function/problem?isFullScreen=true
SELECT AVG(POPULATION)
FROM CITY
WHERE DISTRICT = "California";


SELECT EU.UIN, EMP.NAME
FROM EMPLOYEE AS EMP
         JOIN EMPLOYEE_UIN AS EU ON EMP.ID = EU.ID
WHERE EMP.AGE < 25
ORDER BY EMP.NAME ASC