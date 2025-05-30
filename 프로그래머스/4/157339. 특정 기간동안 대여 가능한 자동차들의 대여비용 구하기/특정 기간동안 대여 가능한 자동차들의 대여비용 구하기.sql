-- 코드를 입력하세요
SELECT C.CAR_ID, C.CAR_TYPE, CAST(C.DAILY_FEE * 30 *(1-D.DISCOUNT_RATE*0.01)AS SIGNED)  AS FEE
FROM CAR_RENTAL_COMPANY_CAR C JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN D
ON C.CAR_TYPE=D.CAR_TYPE
WHERE C.CAR_ID NOT IN(
    SELECT DISTINCT CAR_ID
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
    WHERE START_DATE <='2022-11-30' AND END_DATE >='2022-11-01'
)
AND C.CAR_TYPE IN ('세단','SUV') 
AND D.DURATION_TYPE='30일 이상'
AND C.DAILY_FEE*30*(1-D.DISCOUNT_RATE*0.01)>=500000
AND C.DAILY_FEE*30*(1-D.DISCOUNT_RATE*0.01)<2000000
ORDER BY FEE DESC, C.CAR_TYPE, C.CAR_ID DESC