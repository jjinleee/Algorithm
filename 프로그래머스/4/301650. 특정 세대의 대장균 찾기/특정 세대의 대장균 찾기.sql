-- 코드를 작성해주세요
-- CTE 재귀 쿼리 구조
WITH RECURSIVE GenerationTree AS(
    -- 첫 세대(루트)
    SELECT ID, PARENT_ID, 1 AS generation
    FROM ECOLI_DATA
    WHERE PARENT_ID IS NULL
    
    UNION ALL
    
    -- 자식 개체 (부모+1)
    SELECT
        e.ID, e.PARENT_ID, g.generation+1
    FROM ECOLI_DATA e
    JOIN GenerationTree g ON e.PARENT_ID=g.ID
)

-- 원하는 세대 필터링
SELECT ID
FROM GenerationTree 
WHERE generation=3
ORDER BY ID;